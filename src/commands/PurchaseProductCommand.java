package commands;
import cache.StoreCache;
import models.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PurchaseProductCommand implements Command{
    private Map<String, ArrayList<Transaction>> purchases;
    Map<String, Integer> storage;
    @Override
    public void execute(String[] args, StoreCache cache) {
        if (args.length != 3) {
            System.out.println("Invalid number of arguments. Usage: purchase_product {product_id} {product_quantity} {price}");
            return;
        }
        purchases = cache.getPurchases();
        storage = cache.getStorage();
        String productId = args[0];
        int productQty = Integer.parseInt(args[1]);
        double productPrice = Double.parseDouble(args[2]);

        Transaction purchase = new Transaction(productId, productQty, productPrice);
        purchase.setTotal(productPrice*productQty);
        if(!purchases.containsKey(productId)){
            ArrayList<Transaction> productPurchases = new ArrayList<>();
            productPurchases.add(purchase);
            purchases.put(productId,productPurchases);
        }else {
            purchases.get(productId).add(purchase);
        }
        int newQty;
        if(!storage.containsKey(productId)){
            newQty= productQty;
        }else{
            newQty = storage.get(productId) + productQty;
        }
        storage.put(productId, newQty);

    }
}
