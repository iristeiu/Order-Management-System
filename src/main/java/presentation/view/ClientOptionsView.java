package presentation.view;

import presentation.Controller;

import javax.swing.*;
/**
 * The ClientOptionsView class represents a GUI view with options for managing clients.
 * It allows users to add, edit, delete, and view all clients.
 */
public class ClientOptionsView {
    JFrame frame = new JFrame("Client Options");
    private JButton editClientButton;
    private JButton addNewClientButton;
    private JButton deleteClientButton;
    private JButton viewAllClientsButton;
    private JPanel clientsOptionsPanel;
    private Controller controller;

    /**
     * Constructs a ClientOptionsView and sets up the action listeners for the buttons.
     *
     * @param controller the controller responsible for handling user actions
     */
    public ClientOptionsView(Controller controller) {
        this.controller = controller;

        addNewClientButton.addActionListener(e -> controller.addNewClient(frame));
        editClientButton.addActionListener(e -> controller.enterID(frame, "client!", 1));
        deleteClientButton.addActionListener(e -> controller.deleteClient(frame, "client to delete!"));
        viewAllClientsButton.addActionListener(e -> controller.viewAll(frame, " clients"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.getContentPane().add(clientsOptionsPanel);
        frame.setVisible(true);
    }
}
