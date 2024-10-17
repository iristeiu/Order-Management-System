package presentation.view;

import javax.swing.*;

/**
 * The ErrorView class provides a method to display error messages in a dialog box.
 */
public class ErrorView {
    /**
     * Displays an error message in a dialog box.
     *
     * @param errorMessage the error message to be displayed
     */
    public static void showError(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

}
