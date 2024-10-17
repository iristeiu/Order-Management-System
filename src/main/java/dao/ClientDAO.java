package dao;

import java.util.logging.Logger;

import model.Clients;

/**
 * This class provides data access operations for the Clients table in the database.
 * It extends the AbstractDAO class, which provides generic database operations.
 */
public class ClientDAO extends AbstractDAO<Clients>{




//	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
//	private static final String insertStatementString = "INSERT INTO clients (name_client,address,age,email)"
//			+ " VALUES (?,?,?,?)";
//	private final static String findStatementString = "SELECT * FROM clients where id = ?";

//	public static Client findById(int clientId) {
//		Client toReturn = null;
//
//		Connection dbConnection = ConnectionFactory.getConnection();
//		PreparedStatement findStatement = null;
//		ResultSet rs = null;
//		try {
//			findStatement = dbConnection.prepareStatement(findStatementString);
//			findStatement.setLong(1, clientId);
//			rs = findStatement.executeQuery();
//			rs.next();
//
//			String name = rs.getString("name_client");
//			String address = rs.getString("address");
//			String email = rs.getString("email");
//			int age = rs.getInt("age");
//			toReturn = new Client(clientId, name, address, email, age);
//		} catch (SQLException e) {
//			LOGGER.log(Level.WARNING,"StudentDAO:findById " + e.getMessage());
//		} finally {
//			ConnectionFactory.close(rs);
//			ConnectionFactory.close(findStatement);
//			ConnectionFactory.close(dbConnection);
//		}
//		return toReturn;
//	}
//
//	public static int insert(Client student) {
//		Connection dbConnection = ConnectionFactory.getConnection();
//
//		PreparedStatement insertStatement = null;
//		int insertedId = -1;
//		try {
//			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
//			insertStatement.setString(1, student.getName_client());
//			insertStatement.setString(2, student.getAddress());
//			insertStatement.setInt(3, student.getAge());
//			insertStatement.setString(4, student.getEmail());
//			insertStatement.executeUpdate();
//
//			ResultSet rs = insertStatement.getGeneratedKeys();
//			if (rs.next()) {
//				insertedId = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			LOGGER.log(Level.WARNING, "StudentDAO:insert " + e.getMessage());
//		} finally {
//			ConnectionFactory.close(insertStatement);
//			ConnectionFactory.close(dbConnection);
//		}
//		return insertedId;
//	}
}
