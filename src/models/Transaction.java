package models;

public class Transaction {
    private double productPrice;
    private String productId;
    private int orderQty;
    private double total;


    public Transaction(String productId, int orderQty, double productPrice) {
        this.productId = productId;
        this.orderQty = orderQty;
        this.productPrice = productPrice;
    }
    public double getProductPrice(){
        return productPrice;
    }

    public String getProductId() {
        return productId;
    }
    public int getOrderQty() {
        return orderQty;
    }
    public double getTotal(){
        return total;
    }
    public void setTotal(double amount){
        total = amount;
    }


}
