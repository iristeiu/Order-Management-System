package presentation.view;

import bll.ClientBLL;
import bll.ProductBLL;
import model.Clients;
import model.Products;
import presentation.Controller;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * View class for selecting an ID from a JComboBox.
 */
public class EnterId {
    private JFrame frame = new JFrame("Choose ID");
    private JPanel chooseIdPanel;
    private JComboBox comboBox1;
    private JLabel titleLabel;
    private JButton submitButton;
    private JPanel enterIdPanel;
    private JButton backButton;
    private List<String> objectsComboBox;

    /**
     * Constructs an EnterId object with the specified controller, object type, and cases.
     *
     * @param controller The controller responsible for handling user actions.
     * @param object     The type of object (client or product).
     * @param cases      The cases indicating the action to be performed.
     */
    public EnterId(Controller controller, String object, int cases) {
        String title = titleLabel.getText();
        titleLabel.setText(title + object);

        if (object.contains("client")) {
            ClientBLL clientBll = new ClientBLL();
            List<Clients> clients = clientBll.getAll();
            if (clients != null) {
                objectsComboBox = transformInString(clients);
            }
        } else {
            ProductBLL productBLL = new ProductBLL();
            List<Products> products = productBLL.getAll();
            if (products != null) {
                objectsComboBox = transformInString(products);
            }
        }
        submitButton.addActionListener(e -> {
            switch (cases) {
                case 1:
                    controller.submitButtonClient(frame, getId());
                    break;
                case 2:
                    controller.deleteButtonPressed(frame, new ClientBLL(), getId(), getName());
                    break;
                case 3:
                    controller.deleteButtonPressed(frame, new ProductBLL(), getId(), getName());
                    break;
                case 4:
                    controller.submitButtonProduct(frame, getId());
                    break;
                case 5:
                    controller.saveClient(getId());
                    controller.enterID(frame, " product", 6);
                    break;
                case 6:
                    controller.saveProduct(getId());
                    controller.enterQuantity(frame);
                default:
                    break;

            }

        });

        if (objectsComboBox != null) {
            comboBox1.setModel(new DefaultComboBoxModel<>(objectsComboBox.toArray(new String[0])));
        }
        backButton.addActionListener(e -> controller.backButtonPressed(frame));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.getContentPane().add(chooseIdPanel);
        frame.setVisible(true);
    }

    /**
     * Transforms a list of objects into a list of strings.
     *
     * @param objects The list of objects to transform.
     * @return The list of strings representing the objects.
     */
    public List<String> transformInString(List<?> objects) {
        List<String> comboBoxList = new ArrayList<>();
        for (Object object : objects) {
            comboBoxList.add(retrieveProperties(object));
        }
        return comboBoxList;
    }

    /**
     * Retrieves properties of an object and constructs a string representation.
     *
     * @param object The object to retrieve properties from.
     * @return The string representation of the object's properties.
     */
    public String retrieveProperties(Object object) {
        int i = 0;
        String details = "";
        for (Field field : object.getClass().getDeclaredFields()) {
            if (i >= 2) {
                break; // Break out of the loop after two iterations
            }
            field.setAccessible(true); // set modifier to public
            Object value;
            try {
                value = field.get(object);
                details += " ";
                details += value.toString();

                i++;

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return details;
    }

    /**
     * Gets the selected ID from the JComboBox.
     *
     * @return The selected ID.
     */
    public int getId() {
        String client = comboBox1.getSelectedItem().toString();
        String[] parts = client.split(" "); // Split the string based on space
        String id = parts[1];
        return Integer.parseInt(id);
    }

    /**
     * Gets the name associated with the selected ID from the JComboBox.
     *
     * @return The name associated with the selected ID.
     */
    public String getName() {
        String client = comboBox1.getSelectedItem().toString();
        String[] parts = client.split(" "); // Split the string based on space
        StringBuilder name = new StringBuilder();
        for (int i = 2; i < parts.length; i++) {
            name.append(parts[i]);
            name.append(" ");
        }
        name.deleteCharAt(name.length() - 1);
        return name.toString();
    }

    /**
     * Sets the text of the submit button.
     *
     * @param string The text to set for the submit button.
     */
    public void setButtonMsg(String string) {
        submitButton.setText(string);
    }
}
