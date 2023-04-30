package commands;

import models.Product;

import java.util.List;
import java.util.Map;

public class Save_product implements Command {
    private Map<String, Product> productCatalog;

    public Save_product(Map<String, Product> productCatalog) {
        this.productCatalog = productCatalog;
    }

    @Override
    public void execute(List<String> args) {
        if (args.size() != 3) {
            System.out.println("Invalid number of arguments. Usage: save_product {product_id} {product_name} {price}");
            return;
        }

        String productId = args.get(0);
        String productName = args.get(1);
        double price = Double.parseDouble(args.get(2));

        Product product = productCatalog.get(productId);
        if (product == null) {
            product = new Product(productId, productName, price);
        } else {
            product.setName(productName);
            product.setPrice(price);
        }
        productCatalog.put(productId, product);

        System.out.println("Product saved: " + product);
    }

}
