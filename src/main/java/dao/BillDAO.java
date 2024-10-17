package dao;

import connection.ConnectionFactory;
import model.Bill;
import model.Orders;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * This class provides data access operations for the Bill table in the database.
 * It extends the AbstractDAO class, which provides generic database operations.
 */
public class BillDAO extends AbstractDAO<Bill> {
//    protected static final Logger LOGGER = Logger.getLogger(BillDAO.class.getName());
//    private static final String insertStatementString = "INSERT INTO bill (client_id, product_id, order_id, product_price, quantity, total)"
//            + " VALUES (?,?,?,?,?,?)";
//
//    public static int insert(Bill bill) {
//        Connection dbConnection = ConnectionFactory.getConnection();
//
//        PreparedStatement insertStatement = null;
//        int insertedId = -1;
//        try {
//            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
//            insertStatement.setInt(1, bill.client_id());
//            insertStatement.setInt(2, bill.product_id());
//            insertStatement.setInt(3, bill.order_id());
//            insertStatement.setFloat(4, bill.product_price());
//            insertStatement.setInt(5, bill.quantity());
//            insertStatement.setFloat(6, bill.total());
//            insertStatement.executeUpdate();
//
//            ResultSet rs = insertStatement.getGeneratedKeys();
//            if (rs.next()) {
//                insertedId = rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            LOGGER.log(Level.WARNING, "BillDAO:insert " + e.getMessage());
//        } finally {
//            ConnectionFactory.close(insertStatement);
//            ConnectionFactory.close(dbConnection);
//        }
//        return insertedId;
//    }
}
