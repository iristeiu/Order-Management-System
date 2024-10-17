package presentation.view;

import model.Clients;
import model.Products;
import presentation.Controller;

import javax.swing.*;

/**
 * View class responsible for updating product information.
 */
public class UpdateProductView {
    JFrame frame = new JFrame("Update Product!");
    private JPanel addClientPanel;
    private JTextField nameTextField;
    private JTextField detailsTextField;
    private JTextField quantityTextField;
    private JTextField priceTextField;
    private JLabel priceLabel;
    private JButton submitButton;
    private JButton backButton;

    /**
     * Constructs an UpdateProductView object with the specified controller and product.
     *
     * @param controller The controller responsible for handling user actions.
     * @param product    The product to be updated.
     */
    public UpdateProductView(Controller controller, Products product) {
        nameTextField.setText(product.getProduct_name());
        detailsTextField.setText(product.getDetails());
        quantityTextField.setText(Integer.toString(product.getQuantity_available()));
        priceTextField.setText(Float.toString(product.getPrice()));

        submitButton.addActionListener(e -> controller.updateProduct(getNewProduct(product), frame));
        backButton.addActionListener(e -> controller.backButtonPressed(frame));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 500);
        frame.getContentPane().add(addClientPanel);
        frame.setVisible(true);
    }

    /**
     * Creates a new Products object with updated information based on user input.
     *
     * @param product The original product object.
     * @return The updated product object.
     */
    private Products getNewProduct(Products product) {
        product.setProduct_name(nameTextField.getText());
        product.setDetails(detailsTextField.getText());
        product.setPrice(Float.parseFloat(priceTextField.getText()));
        product.setQuantity_available(Integer.parseInt(quantityTextField.getText()));

        return product;
    }
}
