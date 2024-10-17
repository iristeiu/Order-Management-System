package model;
/**
 * The Products class represents a product with its details.
 */
public class Products {
    private int id;
    private String product_name;
    private String details;
    private int quantity_available;
    private float price;

    /**
     * Default constructor.
     */
    public Products() {

    }

    /**
     * Constructs a new product with all fields.
     *
     * @param id                 the product ID
     * @param product_name       the name of the product
     * @param details            the details of the product
     * @param quantity_available the quantity available
     * @param price              the price of the product
     */
    public Products(int id, String product_name, String details, int quantity_available, float price) {
        super();
        this.id = id;
        this.details = details;
        this.price = price;
        this.product_name = product_name;
        this.quantity_available = quantity_available;
    }

    /**
     * Constructs a new product without an ID.
     *
     * @param product_name       the name of the product
     * @param details            the details of the product
     * @param quantity_available the quantity available
     * @param price              the price of the product
     */
    public Products(String product_name, String details, int quantity_available, float price) {
        super();
        this.details = details;
        this.price = price;
        this.product_name = product_name;
        this.quantity_available = quantity_available;
    }

    /**
     * Gets the product ID.
     *
     * @return the product ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the product ID.
     *
     * @param id the product ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the product.
     *
     * @return the name of the product
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * Sets the name of the product.
     *
     * @param product_name the name of the product to set
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     * Gets the details of the product.
     *
     * @return the details of the product
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets the details of the product.
     *
     * @param details the details of the product to set
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Gets the quantity available.
     *
     * @return the quantity available
     */
    public int getQuantity_available() {
        return quantity_available;
    }

    /**
     * Sets the quantity available.
     *
     * @param quantity_available the quantity available to set
     */
    public void setQuantity_available(int quantity_available) {
        this.quantity_available = quantity_available;
    }

    /**
     * Gets the price of the product.
     *
     * @return the price of the product
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price the price of the product to set
     */
    public void setPrice(float price) {
        this.price = price;
    }
}