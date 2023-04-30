package cache;

import models.Transaction;
import models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StoreCache {
    public StoreCache() {
        productCatalog = new HashMap<>();
        purchases = new HashMap<>();
        orders = new HashMap<>();
        storage = new HashMap<>();
    }

    public Map<String, ArrayList<Transaction>> getPurchases() {
        return purchases;
    }

    public Map<String, ArrayList<Transaction>> getOrders() {
        return orders;
    }


    public Map<String, Product> getProductCatalog() {
        return productCatalog;
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }

    private Map<String, ArrayList<Transaction>> orders;
    private Map<String, Product> productCatalog;
    private Map<String, ArrayList<Transaction>> purchases;
    private Map<String, Integer> storage;

}
