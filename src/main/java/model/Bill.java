package model;

/**
 * The Bill record represents a bill entity with attributes such as bill
 * @param bill_id
 * @param product_id
 * @param client_id
 * @param product_price
 * @param quantity
 * @param total
 */
public record Bill(int bill_id, int client_id, int product_id, float product_price, int quantity, float total) {
}
