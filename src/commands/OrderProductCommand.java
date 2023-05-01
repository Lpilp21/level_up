package commands;

import cache.StoreCache;
import models.Transaction;
import models.Product;
import utils.InputValidator;

import java.util.ArrayList;
import java.util.Map;

public class OrderProductCommand implements Command{
    private Map<String, ArrayList<Transaction>> orders;
    private Map<String, Product> productCatalog;

    Map<String, Integer> storage;
    @Override
    public void execute(String[] args, StoreCache cache) {
        if (args.length != 2) {
            System.out.println("Invalid number of arguments. Usage: order_product {product_id} {product_quantity}");
            return;
        }
        orders = cache.getOrders();
        storage = cache.getStorage();
        productCatalog = cache.getProductCatalog();
        String productId = args[0];
        int productQty = Integer.parseInt(args[1]);
        if(!InputValidator.valid(productQty))
            return;
        if(!storage.containsKey(productId)){
            System.out.println("There are no more products in storage with this ID");
            return;
        }
        if(productQty > storage.get(productId)){
            System.out.println("Not enough qty of the product in the storage");
            return;
        }
        Transaction order = new Transaction(productId, productQty, productCatalog.get(productId).getPrice());
        order.setTotal(productCatalog.get(productId).getPrice()*productQty);

        int newQty = storage.get(productId) - productQty;
        storage.put(productId, newQty);

        if(newQty == 0){
            storage.remove(productId);
        }else{
            storage.put(productId, newQty);
        }

        if(!orders.containsKey(productId)){
            ArrayList<Transaction> productOrders = new ArrayList<>();
            productOrders.add(order);
            orders.put(productId, productOrders);
        }else {
            orders.get(productId).add(order);
        }
    }
}
