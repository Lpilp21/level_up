package commands;

import cache.StoreCache;

import java.util.Map;

public class GetQuantityOfProductCommand implements Command{
    Map<String, Integer> storage;
    @Override
    public void execute(String[] args, StoreCache cache) {
        if (args.length != 1) {
            System.out.println("Invalid number of arguments. Usage: get_quantity_of_product {product_id} ");
            return;
        }
        storage = cache.getStorage();
        String productId = args[0];
        if(!storage.containsKey(productId)){
            System.out.println("There is no such product with that ID");
            return;
        }
        System.out.println(storage.get(productId));
    }
}
