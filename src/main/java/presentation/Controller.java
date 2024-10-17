package presentation;

import bll.BillBLL;
import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import model.Bill;
import model.Clients;
import model.Orders;
import model.Products;
import presentation.view.*;
import start.Reflection;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class manages user interactions and coordinates actions between the view and the business logic layers.
 */
public class Controller {
    private Orders order;

    /**
     * Displays client options view.
     *
     * @param frame The frame in which the view should be displayed.
     */
    public void clientOptionsDisplay(JFrame frame) {
        ClientOptionsView clientOptionsView = new ClientOptionsView(this);

        frame.setVisible(false);
    }

    /**
     * Displays add new client view.
     *
     * @param frame The frame in which the view should be displayed.
     */
    public void addNewClient(JFrame frame) {
        AddClientView addClientView = new AddClientView(this);
        frame.setVisible(false);
    }

    /**
     * Displays add new product view.
     *
     * @param frame The frame in which the view should be displayed.
     */
    public void addNewProduct(JFrame frame) {
        AddNewProduct addNewProduct = new AddNewProduct(this);
        frame.setVisible(false);
    }

    /**
     * Handles the submit button pressed event.
     *
     * @param object The object to be submitted.
     * @param frame  The frame associated with the event.
     */
    public void submitButtonPressed(Object object, JFrame frame) {
        if (object instanceof Clients) {
            ClientBLL clientBll = new ClientBLL();
            Clients client = (Clients) object;
            int id = clientBll.insertClient(client);
            if (id > 0) {
                SuccessView view = new SuccessView("Client: " + client.getName_client() + " was added!", this);
                frame.setVisible(false);
            }
        } else if (object instanceof Products) {
            ProductBLL productBLL = new ProductBLL();
            Products product = (Products) object;
            int id = productBLL.insertProduct(product);
            if (id > 0) {
                SuccessView view = new SuccessView("Product: " + product.getProduct_name() + " was added!", this);
                frame.setVisible(false);
            }
        }
    }

    /**
     * Displays the EnterId view based on the message and cases provided.
     *
     * @param frame The frame in which the view should be displayed.
     * @param msg   The message indicating whether the operation is related to a client or a product.
     * @param cases The cases indicating the type of operation.
     */
    public void enterID(JFrame frame, String msg, int cases) {
        if (msg.contains("client")) {
            EnterId view = new EnterId(this, msg, cases);
        } else if (msg.contains("product")) {
            EnterId view = new EnterId(this, msg, cases);
        }
        frame.setVisible(false);
    }

    /**
     * Retrieves a client by ID and displays the UpdateClientView if found.
     *
     * @param frame The frame in which the view should be displayed.
     * @param id    The ID of the client to be retrieved.
     */
    public void submitButtonClient(JFrame frame, int id) {
        ClientBLL clientBLL = new ClientBLL();
        Clients client = clientBLL.findClientById(id);
        if (client != null) {
            UpdateClientView updateClientView = new UpdateClientView(this, client);
            frame.setVisible(false);
        }
    }

    /**
     * Updates a client's information and displays a success message if successful.
     *
     * @param client The client to be updated.
     * @param frame  The frame in which the success view should be displayed.
     */
    public void updateClient(Clients client, JFrame frame) {
        ClientBLL clientBll = new ClientBLL();
        int id = clientBll.updateClient(client);
        if (id > 0) {
            SuccessView view = new SuccessView("Client: " + client.getName_client() + " was edited!", this);
            frame.setVisible(false);
        }
    }

    /**
     * Updates a product's information and displays a success message if successful.
     *
     * @param product The product to be updated.
     * @param frame   The frame in which the success view should be displayed.
     */
    public void updateProduct(Products product, JFrame frame) {
        ProductBLL productBll = new ProductBLL();
        int id = productBll.updateProduct(product);
        if (id > 0) {
            SuccessView view = new SuccessView("Product: " + product.getProduct_name() + " was edited!", this);
            frame.setVisible(false);
        }
    }

    /**
     * Displays the EnterId view for deleting a client or a product.
     *
     * @param frame The frame in which the view should be displayed.
     * @param msg   The message indicating whether the operation is related to a client or a product.
     */
    public void deleteClient(JFrame frame, String msg) {
        EnterId view = new EnterId(this, msg, 2);
        view.setButtonMsg("Delete");
        frame.setVisible(false);
    }

    /**
     * Handles the deletion of a client or a product based on the object type.
     *
     * @param frame  The frame associated with the event.
     * @param object The object to be deleted (ClientBLL or ProductBLL).
     * @param id     The ID of the object to be deleted.
     * @param name   The name of the object to be deleted.
     */
    public void deleteButtonPressed(JFrame frame, Object object, int id, String name) {
        ClientBLL clientBLL;
        ProductBLL productBLL;
        int status;
        String msg;
        if (object instanceof ClientBLL) {
            clientBLL = (ClientBLL) object;
            status = clientBLL.deleteClient(id);
            msg = "Client: " + name + " was deleted!";
        } else {
            productBLL = (ProductBLL) object;
            status = productBLL.deleteProduct(id);
            msg = "Product: " + name + " was deleted!";
        }

        if (status > 0) {
            SuccessView view = new SuccessView(msg, this);
            frame.setVisible(false);
        }
    }

    /**
     * Displays the option view.
     *
     * @param frame The frame in which the view should be displayed.
     */
    public void backButtonPressed(JFrame frame) {
        OptionView optionsView = new OptionView(this);

        frame.setVisible(false);
    }

    /**
     * Displays a view to show all clients or all products.
     *
     * @param frame  The frame in which the view should be displayed.
     * @param object Indicates whether to display clients or products.
     */
    public void viewAll(JFrame frame, String object) {

        String[][] data = new String[0][];
        String[] columnNames = new String[0];
        boolean createView = true;
        if (object.contains("client")) {
            ClientBLL clientBLL = new ClientBLL();
            List<Clients> clients = clientBLL.getAll();
            if (!clients.isEmpty()) {
                List<String> properties = Reflection.retrieveProperties(new Clients());
                columnNames = properties.toArray(new String[0]);
                data = Reflection.getAllDetails(clients);
            } else
                createView = false;
        } else {
            ProductBLL productBLL = new ProductBLL();
            List<Products> products = productBLL.getAll();
            if (!products.isEmpty()) {
                List<String> properties = Reflection.retrieveProperties(new Products());
                columnNames = properties.toArray(new String[0]);
                data = Reflection.getAllDetails(products);
            } else {
                createView = false;
            }
        }

        if (createView) {
            ViewAll viewAll = new ViewAll(this, object, data, columnNames);
            frame.setVisible(false);
        }
    }

    /**
     * Displays the product options view.
     *
     * @param frame The frame in which the view should be displayed.
     */
    public void productOptionsDisply(JFrame frame) {
        ProductOptionsView productOptionsView = new ProductOptionsView(this);

        frame.setVisible(false);
    }

    /**
     * Displays the EnterId view for deleting a product.
     *
     * @param frame The frame in which the view should be displayed.
     * @param msg   The message to be displayed in the view.
     */
    public void deleteProduct(JFrame frame, String msg) {
        EnterId view = new EnterId(this, msg, 3);
        view.setButtonMsg("Delete");
        frame.setVisible(false);
    }


    /**
     * Handles the submission of a product and displays the update product view.
     *
     * @param frame The frame in which the view should be displayed.
     * @param id    The ID of the product to be updated.
     */
    public void submitButtonProduct(JFrame frame, int id) {
        ProductBLL productBLL = new ProductBLL();
        Products product = productBLL.findProductById(id);
        if (product != null) {
            UpdateProductView updateProductView = new UpdateProductView(this, product);
            frame.setVisible(false);
        }
    }

    /**
     * Saves the client ID for the current order being processed.
     *
     * @param id The ID of the client.
     */
    public void saveClient(int id) {
        order = new Orders();
        this.order.setClient_id(id);
    }

    /**
     * Saves the product ID for the current order being processed.
     *
     * @param id The ID of the product.
     */
    public void saveProduct(int id) {
        this.order.setProduct_id(id);
    }

    /**
     * Displays a view to enter the quantity of a product.
     *
     * @param frame The frame in which the view should be displayed.
     */
    public void enterQuantity(JFrame frame) {
        ProductBLL productBLL = new ProductBLL();
        Products product = productBLL.findProductById(order.getProduct_id());
        if (product != null) {
            ChooseQuantity chooseQuantity = new ChooseQuantity(this, getQuantities(product.getQuantity_available()));
            frame.setVisible(false);
        }
    }

    /**
     * Generates a list of quantities based on the maximum quantity available.
     *
     * @param maxQuantity The maximum quantity available for the product.
     * @return A list of quantities.
     */
    public List<String> getQuantities(int maxQuantity) {
        List<String> quantities = new ArrayList<>();
        for (int i = 1; i <= maxQuantity; i++) {
            quantities.add(Integer.toString(i));
        }
        return quantities;
    }

    /**
     * Creates an order for the selected product and displays a success message if successful.
     *
     * @param frame       The frame in which the view should be displayed.
     * @param selectedItem The quantity of the product selected.
     */
    public void createOrder(JFrame frame, int selectedItem) {
        order.setQuantity(selectedItem);
        ProductBLL productBLL = new ProductBLL();
        Products product = productBLL.findProductById(order.getProduct_id());
        if (product != null) {
            OrderBLL orderBLL = new OrderBLL();
            int status = orderBLL.insertOrder(order);
            if (status > 0) {
                BillBLL billBLL = new BillBLL();
                float price = product.getPrice();
                Bill bill = new Bill(0, order.getClient_id(), order.getProduct_id(), price, selectedItem, price * selectedItem);
                status = billBLL.insertBill(bill);
                if (status > 0) {
                    SuccessView view = new SuccessView("Order created!", this);
                    product.setQuantity_available(product.getQuantity_available() - order.getQuantity());
                    productBLL.updateProduct(product);
                    frame.setVisible(false);
                }
            }

        }

    }
}
