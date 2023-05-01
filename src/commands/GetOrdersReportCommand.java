package commands;

import cache.StoreCache;
import models.Product;
import models.Transaction;
import utils.COGSCalculator;

import java.util.ArrayList;
import java.util.Map;

public class GetOrdersReportCommand implements Command {
    Map<String, ArrayList<Transaction>> orders;
    Map<String, ArrayList<Transaction>> purchases;
    Map<String, Product> productCatalog;
    @Override
    public void execute(String[] args, StoreCache cache) {
        orders = cache.getOrders();
        productCatalog = cache.getProductCatalog();
        purchases = cache.getPurchases();
        System.out.println("Orders Report:");
        System.out.println("------------------------------------------------------");
        System.out.printf("%-15s%-20s%-10s%-10s%-10s%-10s\n", "Product ID", "Product Name", "Quantity", "Price", "COGS", "Selling Price");
        for (String product : orders.keySet()) {
            ArrayList<Transaction> productOrders = orders.get(product);
            for (int i = 0; i < productOrders.size(); i++) {
                Transaction order = productOrders.get(i);
                String productId = order.getProductId();
                double COGS = COGSCalculator.calculateCOGS(orders.get(product), purchases.get(product));
                System.out.printf("%-15s%-20s%-10d%-10.2f%-10.2f%-10.2f\n", productId, productCatalog.get(productId).getName(),
                        order.getOrderQty(), order.getProductPrice(), COGS, productCatalog.get(productId).getPrice());

            }

        }
        System.out.println("------------------------------------------------------");
    }

}
