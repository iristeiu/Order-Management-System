package dao;

import connection.ConnectionFactory;
import model.Orders;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The OrderDAO class provides data access methods for interacting with the Orders table in the database.
 * It extends the AbstractDAO class, inheriting common data access methods.
 */
public class OrderDAO  extends AbstractDAO<Orders>{
//    protected static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());
//    private static final String insertStatementString = "INSERT INTO orders (product_id,client_id,quantity)"
//			+ " VALUES (?,?,?)";
//
//    public static int insert(Orders order) {
//		Connection dbConnection = ConnectionFactory.getConnection();
//
//		PreparedStatement insertStatement = null;
//		int insertedId = -1;
//		try {
//			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
//			insertStatement.setInt(1, order.getProduct_id());
//			insertStatement.setInt(2, order.getClient_id());
//			insertStatement.setInt(3, order.getQuantity());
//			insertStatement.executeUpdate();
//
//			ResultSet rs = insertStatement.getGeneratedKeys();
//			if (rs.next()) {
//				insertedId = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			LOGGER.log(Level.WARNING, "OrderDAO:insert " + e.getMessage());
//		} finally {
//			ConnectionFactory.close(insertStatement);
//			ConnectionFactory.close(dbConnection);
//		}
//		return insertedId;
//	}
}
