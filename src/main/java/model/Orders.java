package model;

/**
 * The Orders class represents an order made by a client for a specific product.
 */
public class Orders {
    private int order_id;
    private int product_id;
    private int client_id;
    private int quantity;

    /**
     * Default constructor.
     */
    public Orders() {
    }

    /**
     * Gets the order ID.
     *
     * @return the order ID
     */
    public int getOrder_id() {
        return order_id;
    }

    /**
     * Sets the order ID.
     *
     * @param order_id the order ID to set
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    /**
     * Gets the product ID.
     *
     * @return the product ID
     */
    public int getProduct_id() {
        return product_id;
    }

    /**
     * Sets the product ID.
     *
     * @param product_id the product ID to set
     */
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    /**
     * Gets the client ID.
     *
     * @return the client ID
     */
    public int getClient_id() {
        return client_id;
    }

    /**
     * Sets the client ID.
     *
     * @param client_id the client ID to set
     */
    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    /**
     * Gets the quantity of the ordered product.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the ordered product.
     *
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
