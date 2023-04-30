package commands;

import cache.StoreCache;
import models.Product;
import java.util.Map;

public class SaveProductCommand implements Command {
    private Map<String, Product> productCatalog;

    @Override
    public void execute(String[] args, StoreCache cache) {
        if (args.length != 3) {
            System.out.println("Invalid number of arguments. Usage: save_product {product_id} {product_name} {price}");
            return;
        }
        productCatalog = cache.getProductCatalog();
        String productId = args[0];
        String productName = args[1];
        double price = Double.parseDouble(args[2]);

        Product product;
        if (!productCatalog.containsKey(productId)) {
            product = new Product(productId, productName, price);
            productCatalog.put(productId, product);
        } else {
            product = productCatalog.get(productId);
            product.setName(productName);
            product.setPrice(price);
        }

        System.out.println("Product saved: " + product.getName());
    }

}
