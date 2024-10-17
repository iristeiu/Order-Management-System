package presentation.view;

import model.Products;
import presentation.Controller;

import javax.swing.*;

/**
 * The AddNewProduct class represents a GUI view for adding a new product.
 * It allows users to input product details and submit them to the controller.
 */
public class AddNewProduct {
    JFrame frame = new JFrame("Add new product!");
    private JPanel addClientPanel;
    private JTextField nameTextField;
    private JTextField detailsTextField;
    private JTextField quantityTextField;
    private JTextField priceTextField;
    private JButton submitButton;
    private JLabel priceLabel;
    private Products product;

    /**
     * Constructs an AddNewProduct view and sets up the action listener for the submit button.
     *
     * @param controller the controller responsible for handling user actions
     */
    public AddNewProduct(Controller controller) {

        submitButton.addActionListener(e -> {
            product = getDetails();
            controller.submitButtonPressed(product, frame);
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.getContentPane().add(addClientPanel);
        frame.setVisible(true);
    }

    /**
     * Retrieves the product details entered by the user.
     *
     * @return a Products object containing the entered product details
     */
    public Products getDetails() {
        Products products = new Products();

        products.setProduct_name(nameTextField.getText());
        products.setQuantity_available(Integer.valueOf(quantityTextField.getText()));
        products.setPrice(Float.valueOf(priceTextField.getText()));
        products.setDetails(detailsTextField.getText());

        return products;
    }

}
