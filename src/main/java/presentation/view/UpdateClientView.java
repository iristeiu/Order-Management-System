package presentation.view;

import model.Clients;
import presentation.Controller;

import javax.swing.*;
/**
 * View class for updating client information.
 */
public class UpdateClientView {
    private JFrame frame = new JFrame("Update Client");
    private JPanel panel1;
    private JPanel addClientPanel;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField addressTextField;
    private JTextField ageTextField;
    private JButton submitButton;
    private JButton backButton;
    /**
     * Constructs an UpdateClientView object with the specified controller and client.
     *
     * @param controller The controller responsible for handling user actions.
     * @param client     The client to be updated.
     */

    public UpdateClientView(Controller controller, Clients client) {
        nameTextField.setText(client.getName_client());
        emailTextField.setText(client.getEmail());
        addressTextField.setText(client.getAddress());
        ageTextField.setText(Integer.toString(client.getAge()));

        submitButton.addActionListener(e -> controller.updateClient(getNewClient(client), frame));
        backButton.addActionListener(e -> controller.backButtonPressed(frame));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 500);
        frame.getContentPane().add(addClientPanel);
        frame.setVisible(true);
    }

    /**
     * Creates a new Clients object with updated information based on user input.
     *
     * @param client The original client object.
     * @return The updated client object.
     */
    private Clients getNewClient(Clients client) {
        client.setName_client(nameTextField.getText());
        client.setEmail(emailTextField.getText());
        client.setAge(Integer.parseInt(ageTextField.getText()));
        client.setAddress(addressTextField.getText());

        return client;
    }
}
