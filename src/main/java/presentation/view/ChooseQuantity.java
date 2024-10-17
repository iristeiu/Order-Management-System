package presentation.view;

import presentation.Controller;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

/**
 * The ChooseQuantity class represents a GUI view for selecting a quantity.
 * It allows users to choose a quantity from a combo box and submit the selection.
 */
public class ChooseQuantity {
    private JFrame frame = new JFrame("Choose Quantity!");
    private JPanel chooseIdPanel;
    private JComboBox comboBox1;
    private JLabel titleLabel;
    private JButton submitButton;

    /**
     * Constructs a ChooseQuantity view and sets up the action listeners for the buttons.
     *
     * @param controller      the controller responsible for handling user actions
     * @param objectsComboBox a list of string items to populate the combo box
     */
    public ChooseQuantity(Controller controller, List<String> objectsComboBox) {
        if (objectsComboBox != null) {
            comboBox1.setModel(new DefaultComboBoxModel<>(objectsComboBox.toArray(new String[0])));
        }

        submitButton.addActionListener(e -> {
            int selectedItem = Integer.parseInt(Objects.requireNonNull(comboBox1.getSelectedItem()).toString());
            controller.createOrder(frame, selectedItem);
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.getContentPane().add(chooseIdPanel);
        frame.setVisible(true);
    }
}
