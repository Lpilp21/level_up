package models;

public class Order extends Transaction{
    private String productName;
    private double cogs;
    private double sellingPrice;

    public Order(String productId, int orderQty, double productPrice) {
        super(productId, orderQty, productPrice);
    }
}
