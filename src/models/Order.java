package models;

public class Order{
    private double productPrice;

    public Order(String productId, int orderQty) {
        this.productId = productId;
        this.orderQty = orderQty;
    }
    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    private int orderQty;

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

}
