package bll.validators;

import model.Products;
import presentation.view.ErrorView;

/**
 * Validator class to validate the amount of products available.
 *
 * @author Risteiu Ioana
 * @since May 19, 2024
 */
public class ProductAmountValidator implements Validator<Products> {
    /**
     * Validates the amount of products available.
     *
     * @param t The product object to be validated.
     * @return {@code true} if the amount available is non-negative, {@code false} otherwise.
     */
    public boolean validate(Products t) {
        if (t.getQuantity_available() < 0) {
            ErrorView.showError("The quantity available is negative!");
            return false;
        }
        return true;
    }
}
