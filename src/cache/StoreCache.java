package cache;

import models.Order;
import models.Product;
import models.Purchase;

import java.util.HashMap;
import java.util.Map;

public class StoreCache {
    public StoreCache() {
        productCatalog = new HashMap<>();
        purchases = new HashMap<>();
        orders = new HashMap<>();
    }

    public Map<String, Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Map<String, Purchase> purchases) {
        this.purchases = purchases;
    }

    public Map<String, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<String, Order> orders) {
        this.orders = orders;
    }

    private Map<String, Order> orders;
    //TODO: need to implement setting intial balance


    public Map<String, Product> getProductCatalog() {
        return productCatalog;
    }
    private double balance;
    private Map<String, Product> productCatalog;
    private Map<String, Purchase> purchases;

}
