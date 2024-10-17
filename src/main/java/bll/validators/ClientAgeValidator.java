package bll.validators;

import model.Clients;
import presentation.view.ErrorView;

/**
 * Validator class to validate the age of a client.
 *
 * @author Risteiu Ioana
 * @since May 19, 2024
 */
public class ClientAgeValidator implements Validator<Clients> {
    private static final int MIN_AGE = 7;
    private static final int MAX_AGE = 60;
    /**
     * Validates the age of a client.
     *
     * @param t The client to validate.
     * @return true if the client's age is within the valid range, false otherwise.
     */
    public boolean validate(Clients t) {

        if (t.getAge() < MIN_AGE || t.getAge() > MAX_AGE) {
            ErrorView.showError("The Student Age limit is not respected!");
            return false;
        }
        return true;
    }

}
