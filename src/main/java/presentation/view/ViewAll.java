package presentation.view;

import presentation.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * View class for displaying a table of data.
 */
public class ViewAll {
    JFrame frame = new JFrame("Table Example");
    private JTable table1;
    private JPanel tablePanel;
    private JScrollPane tableScrollPane;
    private JButton backButton;
    private JLabel titleLabel;

    /**
     * Constructs a ViewAll object with the specified parameters.
     *
     * @param controller  The controller responsible for handling user actions.
     * @param object      Indicates whether the displayed data represents clients or products.
     * @param data        The data to be displayed in the table.
     * @param columnNames The column names for the table.
     */
    public ViewAll(Controller controller, String object, String[][] data, String[] columnNames) {

        table1.setModel(new DefaultTableModel(data, columnNames));
        table1.setRowHeight(table1.getRowHeight() + 20);

        titleLabel.setText(titleLabel.getText() + object);

        table1.getColumnModel().getColumn(1).setPreferredWidth(300);
        table1.getColumnModel().getColumn(2).setPreferredWidth(300);
        table1.getColumnModel().getColumn(3).setPreferredWidth(500);
        table1.getColumnModel().getColumn(4).setPreferredWidth(300);
        // Create a JScrollPane to add the table to
        backButton.addActionListener(e -> controller.backButtonPressed(frame));

        frame.setSize(1100, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(tablePanel);
        frame.pack();
        frame.setVisible(true);
    }


}
