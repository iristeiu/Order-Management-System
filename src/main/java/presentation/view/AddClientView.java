package presentation.view;

import model.Clients;
import presentation.Controller;

import javax.swing.*;
/**
 * The AddClientView class represents a GUI view for adding a new client.
 * It allows users to input client details and submit them to the controller.
 */
public class AddClientView {
    private JFrame frame = new JFrame("Add A New Client");
    private JPanel addClientPanel;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField addressTextField;
    private JButton submitButton;
    private JTextField ageTextField;
    Clients client;

    /**
     * Constructs an AddClientView and sets up the action listener for the submit button.
     *
     * @param controller the controller responsible for handling user actions
     */
    public AddClientView(Controller controller) {

        submitButton.addActionListener(e -> {
            client = getDetails();
            controller.submitButtonPressed(client, frame);
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.getContentPane().add(addClientPanel);
        frame.setVisible(true);
    }

    /**
     * Retrieves the client details entered by the user.
     *
     * @return a Clients object containing the entered client details
     */
    public Clients getDetails() {
        Clients client = new Clients();

        client.setName_client(nameTextField.getText());
        client.setAddress(addressTextField.getText());
        client.setAge(Integer.valueOf(ageTextField.getText()));
        client.setEmail(emailTextField.getText());

        return client;
    }
}
