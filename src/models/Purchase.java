package models;

public class Purchase extends Order {
    double productPrice;
    public Purchase(String productId, int orderQty, double productPrice) {
        super(productId, orderQty);
        this.productPrice = productPrice;



    }
    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }


}
