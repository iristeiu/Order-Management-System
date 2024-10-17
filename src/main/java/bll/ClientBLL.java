package bll;

import java.util.ArrayList;
import java.util.List;

import bll.validators.EmailValidator;
import bll.validators.ClientAgeValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Clients;
import presentation.view.ErrorView;

/**
 * Business Logic Layer class responsible for handling operations related to clients.
 *
 * @author Risteiu Ioana
 * @since May 19, 2024
 */
public class ClientBLL {

    private List<Validator<Clients>> validators;
    private ClientDAO clientDAO;

    /**
     * Constructs a new ClientBLL object, initializing validators and ClientDAO.
     */
    public ClientBLL() {
        validators = new ArrayList<Validator<Clients>>();
        validators.add(new EmailValidator());
        validators.add(new ClientAgeValidator());

        clientDAO = new ClientDAO();
    }

    /**
     * Finds a client by their ID.
     *
     * @param id The ID of the client to find.
     * @return The found client.
     */
    public Clients findClientById(int id) {
        Clients client = clientDAO.findById(id);
        if (client == null) {
            ErrorView.showError("The client with id: " + id + " was not found");
        }
        return client;
    }

    /**
     * Retrieves all clients from the database.
     *
     * @return A list of all clients.
     */
    public List<Clients> getAll() {
        List<Clients> clients = clientDAO.findAll();
        if (clients.isEmpty()) {
            ErrorView.showError("No clients available. Please create a new client!");
        }
        return clients;
    }

    /**
     * Inserts a new client into the database.
     *
     * @param client The client to insert.
     * @return The ID of the newly inserted client, or -1 if insertion fails.
     */
    public int insertClient(Clients client) {
        for (Validator<Clients> v : validators) {
            boolean valid = v.validate(client);
            if (!valid)
                return -1;
        }
        return clientDAO.insert(client);
    }

    /**
     * Updates an existing client in the database.
     *
     * @param client The client to update.
     * @return The number of affected rows in the database, or -1 if update fails.
     */
    public int updateClient(Clients client) {
        for (Validator<Clients> v : validators) {
            boolean valid = v.validate(client);
            if (!valid)
                return -1;
        }
        return clientDAO.update(client);
    }

    /**
     * Deletes a client from the database by their ID.
     *
     * @param id The ID of the client to delete.
     * @return The number of affected rows in the database.
     */
    public int deleteClient(int id) {
        return clientDAO.delete(id);
    }
}
