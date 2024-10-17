package bll;

import bll.validators.ProductAmountValidator;
import bll.validators.Validator;
import dao.ProductDAO;
import model.Products;
import presentation.view.ErrorView;

import java.util.ArrayList;
import java.util.List;

/**
 * Business Logic Layer class responsible for handling operations related to products.
 */
public class ProductBLL {

    private List<Validator<Products>> validators;
    private ProductDAO productDAO;

    /**
     * Constructs a new ProductBLL object, initializing validators and ProductDAO.
     */
    public ProductBLL() {
        validators = new ArrayList<Validator<Products>>();
        validators.add(new ProductAmountValidator());
        productDAO = new ProductDAO();
    }

    /**
     * Finds a product by its ID.
     *
     * @param id The ID of the product to find.
     * @return The found product.
     */
    public Products findProductById(int id) {
        Products product = productDAO.findById(id);
        if (product == null) {
            ErrorView.showError("The product with id: " + id + " was not found");
        }
        return product;
    }

    /**
     * Retrieves all products from the database.
     *
     * @return A list of all products.
     */
    public List<Products> getAll() {
        List<Products> products = productDAO.findAll();
        if (products.isEmpty()) {
            ErrorView.showError("No products available. Please create a new product!");
        }
        return products;
    }

    /**
     * Inserts a new product into the database.
     *
     * @param product The product to insert.
     * @return The ID of the newly inserted product, or -1 if insertion fails.
     */
    public int insertProduct(Products product) {
        for (Validator<Products> v : validators) {
            boolean valid = v.validate(product);
            if (!valid)
                return -1;
        }
        return productDAO.insert(product);
    }

    /**
     * Updates an existing product in the database.
     *
     * @param product The product to update.
     * @return The number of affected rows in the database, or -1 if update fails.
     */
    public int updateProduct(Products product) {
        for (Validator<Products> v : validators) {
            boolean valid = v.validate(product);
            if (!valid)
                return -1;
        }
        return productDAO.update(product);
    }

    /**
     * Deletes a product from the database by its ID.
     *
     * @param id The ID of the product to delete.
     * @return The number of affected rows in the database.
     */
    public int deleteProduct(int id) {
        return productDAO.delete(id);
    }
}
