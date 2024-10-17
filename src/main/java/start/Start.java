package start;

import java.sql.SQLException;
import java.util.logging.Logger;

import model.Clients;
import presentation.Controller;
import presentation.view.OptionView;
import presentation.view.ViewAll;

/**
 * The Start class initializes and launches the application.
 * It contains the main method to start the program execution.
 *
 * @author Risteiu Ioana-Stefania
 * @since May 19, 2024
 */
public class Start {
    /**
     * Default constructor for the Start class.
     * This constructor is empty as there are no instance variables to initialize.
     */
    public Start() {
        // Empty constructor
    }

    /**
     * The entry point of the application.
     *
     * @param args Command line arguments (not used in this application).
     * @throws SQLException if a database access error occurs.
     */
    public static void main(String[] args) throws SQLException {
        // Create a new instance of the Controller
        Controller controller = new Controller();

        // Initialize the OptionView with the controller
        OptionView view = new OptionView(controller);
    }
}
