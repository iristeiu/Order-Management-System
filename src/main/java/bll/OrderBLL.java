package bll;

import dao.OrderDAO;
import model.Orders;

/**
 * Business Logic Layer class responsible for handling operations related to orders.
 */
public class OrderBLL {
    private OrderDAO orderDAO;

    /**
     * Constructs a new OrderBLL object, initializing the OrderDAO.
     */
    public OrderBLL() {
        this.orderDAO = new OrderDAO();
    }

    /**
     * Inserts a new order into the database.
     *
     * @param order The order to insert.
     * @return The ID of the newly inserted order, or -1 if insertion fails.
     */
    public int insertOrder(Orders order) {
        return orderDAO.insert(order);
    }
}
