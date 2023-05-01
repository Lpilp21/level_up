package commands;

import cache.StoreCache;
import models.Order;
import models.Product;
import models.Transaction;
import utils.COGSCalculator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExportOrdersReportCommand implements Command {
    private static final String CSV_HEADER = "Product ID,Product Name,Quantity,Price,COGS,Selling Price";

    @Override
    public void execute(String[] args, StoreCache cache) throws IOException {
        if (args.length != 1) {
            throw new IllegalArgumentException("Invalid number of arguments. Usage: export_orders_report {filename.csv}.");
        }

        String filePath = args[0];
        Map<String, ArrayList<Transaction>> orders = cache.getOrders();
        Map<String, Product> productCatalog = cache.getProductCatalog();
        Map<String, ArrayList<Transaction>> purchases = cache.getPurchases();

        if (orders.isEmpty()) {
            System.out.println("No orders to export.");
            return;
        }

        File file = new File(filePath);
        FileWriter writer = new FileWriter(file);

        writer.write(CSV_HEADER + "\n");
        for(String product : orders.keySet()){
            ArrayList<Transaction> productOrder = orders.get(product);
            for (int i = 0; i<productOrder.size(); i++) {
                Transaction order = productOrder.get(i);
                double COGS = COGSCalculator.calculateCOGS(order, purchases.get(product));
                String line = order.getProductId() + "," +
                        productCatalog.get(product).getName() + "," +
                        order.getOrderQty() + "," +
                        String.format("%.2f", order.getProductPrice()) + "," +
                        String.format("%.2f", COGS) + "," +
                        String.format("%.2f", productCatalog.get(product).getPrice()) + "\n";
                writer.write(line);
            }

        }
        writer.close();
        System.out.println("Orders report exported to file: " + file.getAbsolutePath());
    }
}
