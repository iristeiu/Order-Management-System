package presentation.view;

import presentation.Controller;

import javax.swing.*;
/**
 * View class for displaying product options.
 */

public class ProductOptionsView {
    JFrame frame = new JFrame("Product Options");
    private JButton editProductButton;
    private JButton addNewProductButton;
    private JButton deleteProductButton;
    private JButton viewAllProductsButton;
    private JPanel productOptionsPanel;
    private Controller controller;

    /**
     * Constructs a ProductOptionsView object with all the options.
     *
     * @param controller The controller responsible for handling user actions.
     */
    public ProductOptionsView(Controller controller) {
        this.controller = controller;
        addNewProductButton.addActionListener(e -> controller.addNewProduct(frame));
        editProductButton.addActionListener(e -> controller.enterID(frame, " product!", 4));
        viewAllProductsButton.addActionListener(e -> controller.viewAll(frame, " products!"));
        deleteProductButton.addActionListener(e -> controller.deleteProduct(frame, "product to delete!"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.getContentPane().add(productOptionsPanel);
        frame.setVisible(true);
    }
}
