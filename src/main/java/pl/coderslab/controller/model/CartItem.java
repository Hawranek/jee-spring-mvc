package pl.coderslab.controller.model;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(int quantity, Product product) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
