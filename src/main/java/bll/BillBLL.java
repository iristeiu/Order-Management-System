package bll;

import dao.BillDAO;
import model.Bill;
import model.Products;
import presentation.view.ErrorView;

import java.util.List;

/**
 * Business Logic Layer class responsible for handling operations related to bills.
 */
public class BillBLL {
    private BillDAO billDAO;

    /**
     * Constructs a new BillBLL object, initializing the BillDAO.
     */
    public BillBLL() {
        this.billDAO = new BillDAO();
    }

    /**
     * Inserts a new bill into the database.
     *
     * @param bill The bill to insert.
     * @return The ID of the newly inserted bill, or -1 if insertion fails.
     */
    public int insertBill(Bill bill) {
        return billDAO.insert(bill);
    }
    public List<Bill> getAll() {
        List<Bill> bills = billDAO.findAll();
        if (bills.isEmpty()) {
            ErrorView.showError("No bills available. Please create a new order!");
        }
        return bills;
    }
}
