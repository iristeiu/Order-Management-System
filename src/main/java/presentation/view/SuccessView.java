package presentation.view;

import presentation.Controller;

import javax.swing.*;
/**
 * View class for displaying a success message.
 */
public class SuccessView {
    private JFrame frame = new JFrame();
    private JPanel successPanel;
    private JLabel messageLabel;
    private JButton OKButton;

    /**
     * Constructs a SuccessView object with the specified success message and controller.
     *
     * @param message    The success message to display.
     * @param controller The controller responsible for handling user actions.
     */
    public SuccessView(String message, Controller controller) {
        messageLabel.setText(message);

        OKButton.addActionListener(e -> {
            OptionView view = new OptionView(controller);
            frame.setVisible(false);
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 250);
        frame.getContentPane().add(successPanel);
        frame.setVisible(true);
    }
}
