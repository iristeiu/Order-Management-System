package presentation.view;

import presentation.Controller;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The OptionView class represents a GUI view with options for clients, product operations, and order creation.
 * It interacts with a Controller to handle user actions.
 */
public class OptionView {
    private JFrame frame = new JFrame("Options View");
    private JButton clientButton;
    private JButton productOperationButton;
    private JButton createOrderButton;
    private JPanel optionsPanel;
    private Controller controller;

    /**
     * Constructs an OptionView and sets up the action listeners for the buttons.
     *
     * @param controller the controller responsible for handling user actions
     */
    public OptionView(Controller controller) {
        this.controller = controller;

        clientButton.addActionListener(e -> controller.clientOptionsDisplay(frame));
        productOperationButton.addActionListener(e -> controller.productOptionsDisply(frame));
        createOrderButton.addActionListener(e -> controller.enterID(frame, "client", 5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.getContentPane().add(optionsPanel);
        frame.setVisible(true);
    }
}
