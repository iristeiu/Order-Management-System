package dao;

import connection.ConnectionFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * AbstractDAO is a generic Data Access Object (DAO) that provides basic
 * CRUD (Create, Read, Update, Delete) operations using reflection and
 * generics to map Java objects to database tables.
 *
 * @param <T> the type parameter representing the entity type
 *
 * @author : Risteiu Ioana
 * @since : May 19, 2024
 *
 */
public class AbstractDAO<T> {
    // // Logger for logging messages
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    /**
     * Constructor that determines the generic type at runtime.
     */
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * Creates a SQL SELECT query string for the specified field.
     *
     * @param field the field to select by
     * @return the SQL SELECT query string
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Creates a SQL SELECT query string to select all records.
     *
     * @return the SQL SELECT query string
     */
    private String createSelectAllQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT *");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        return sb.toString();
    }

    /**
     * Creates a SQL INSERT query string with the specified fields.
     *
     * @param fields the fields to insert
     * @return the SQL INSERT query string
     */
    private String createInsertQuery(String fields) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName());
        sb.append(fields);
        return sb.toString();
    }

    /**
     * Creates a SQL UPDATE query string with the specified values.
     *
     * @param values the values to update
     * @return the SQL UPDATE query string
     */
    private String createUpdateQuery(String values) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET ");
        sb.append(values);
        sb.append("WHERE id = ?");
        return sb.toString();
    }

    /**
     * Creates a SQL DELETE query string to delete a record by ID.
     *
     * @return the SQL DELETE query string
     */
    private String createDeleteQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE id = ?");

        return sb.toString();
    }

    /**
     * Finds an entity by its ID.
     *
     * @param id the ID of the entity
     * @return the entity if found, or null otherwise
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Finds all entities.
     *
     * @return a list of all entities
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return createObjects(resultSet);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:getAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }


    /**
     * Inserts a new entity into the database.
     *
     * @param t the entity to insert
     * @return the number of rows affected, or -1 if an error occurred
     */
    public int insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createInsertQuery(getFields(t));
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int index = 1;
            boolean firstFieldSkipped = false;
            for (Field field : t.getClass().getDeclaredFields()) {
                if (!firstFieldSkipped) {
                    firstFieldSkipped = true;
                    continue; // Skip setting value for the first field
                }
                field.setAccessible(true);
                Object value = field.get(t);
                if (value instanceof Integer) {
                    statement.setInt(index, (Integer) value);
                } else if (value instanceof String) {
                    statement.setString(index, (String) value);
                } else if (value instanceof Float) {
                    statement.setFloat(index, (Float) value);
                }
                index++;
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return -1;
    }

    /**
     * Updates an existing entity in the database.
     *
     * @param t the entity to update
     * @return the number of rows affected, or -1 if an error occurred
     */
    public int update(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createUpdateQuery(getUpdateString(t));
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int index = 1, id = 0;
            boolean firstFieldSkipped = false;
            for (Field field : t.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (!firstFieldSkipped) {
                    id = field.getInt(t);
                    firstFieldSkipped = true;
                    continue; // Skip setting value for the first field
                }
                field.setAccessible(true);
                Object value = field.get(t);
                if (value instanceof Integer) {
                    statement.setInt(index, (Integer) value);
                } else if (value instanceof String) {
                    statement.setString(index, (String) value);
                } else if (value instanceof Float) {
                    statement.setFloat(index, (Float) value);
                }
                index++;
            }
            statement.setInt(index, id);
            return statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return -1;
    }

    /**
     * Deletes an entity by its ID.
     *
     * @param id the ID of the entity to delete
     * @return the number of rows affected, or -1 if an error occurred
     */
    public int delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createDeleteQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            return statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return -1;
    }

    /**
     * Creates a list of entities from the given ResultSet.
     *
     * @param resultSet the ResultSet to parse
     * @return a list of entities
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Constructs a SQL UPDATE query string with placeholders for the entity's fields,
     * except for the first field, which is typically the ID.
     *
     * @param t the entity instance to generate the update string for
     * @return a SQL UPDATE query string with placeholders
     */
    private String getUpdateString(T t) {
        StringBuilder fields = new StringBuilder(" ");
        int index = 0;
        for (Field field : type.getDeclaredFields()) {
            if (index > 0) {
                String fieldName = field.getName();
                fields.append(fieldName);
                fields.append(" = ?");
                fields.append(" ,");
            }
            index++;
        }
        fields.deleteCharAt(fields.length() - 1);
        return fields.toString();
    }

    /**
     * Constructs a SQL INSERT query string with placeholders for the entity's fields,
     * except for the first field, which is typically the ID.
     *
     * @param t the entity instance to generate the insert string for
     * @return a SQL INSERT query string with placeholders for values
     */
    public String getFields(T t) {
        StringBuilder fields = new StringBuilder(" (");
        StringBuilder values = new StringBuilder("VALUES (");
        int index = 0;
        for (Field field : type.getDeclaredFields()) {
            if (index > 0) {
                String fieldName = field.getName();
                fields.append(fieldName);
                fields.append(",");
                values.append("?,");
            }
            index++;
        }
        fields.deleteCharAt(fields.length() - 1);
        values.deleteCharAt(values.length() - 1);
        values.append(")");
        fields.append(") ");
        fields.append(values);
        return fields.toString();
    }


}
