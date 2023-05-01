package commands;

import cache.StoreCache;
import models.Order;
import models.Product;
import models.Transaction;

import java.util.ArrayList;
import java.util.Map;

public class GetOrdersReportCommand implements Command {
    Map<String, ArrayList<Transaction>> orders;
    Map<String, Product> productCatalog;
    @Override
    public void execute(String[] args, StoreCache cache) {
        orders = cache.getOrders();
        productCatalog = cache.getProductCatalog();
        System.out.println("Orders Report:");
        System.out.println("------------------------------------------------------");
        System.out.printf("%-15s%-20s%-10s%-10s%-10s%-10s\n", "Product ID", "Product Name", "Quantity", "Price", "COGS", "Selling Price");
        for (ArrayList<Transaction> productOrders : orders.values()) {
            for (int i = 0; i < productOrders.size(); i++) {
                Transaction order = productOrders.get(i);
                String productId = order.getProductId();
                System.out.printf("%-15s%-20s%-10d%-10.2f%-10.2f%-10.2f\n", productId, productCatalog.get(productId).getName(),
                        order.getOrderQty(), order.getProductPrice(), 100.0, productCatalog.get(productId).getPrice());

            }

        }
        System.out.println("------------------------------------------------------");
    }
}
