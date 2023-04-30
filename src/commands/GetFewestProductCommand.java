package commands;

import cache.StoreCache;

import java.util.List;
import java.util.Map;

public class GetFewestProductCommand implements Command{
    Map<String, Integer> storage;
    @Override
    public void execute(String[] args, StoreCache cache) {
        if (args.length != 0) {
            System.out.println("Invalid number of arguments. Usage: get_fewest_product ");
            return;
        }
        storage = cache.getStorage();
        if(storage.isEmpty()){
            System.out.println("There are no products in storage yet");
            return;
        }
        System.out.println(getFewestInStorage());
    }
    private String getFewestInStorage(){
        int fewestCount = Integer.MAX_VALUE;
        String fewestProduct = "";
        for (String product : storage.keySet()) {
            if(storage.get(product)<=fewestCount){
                fewestCount = storage.get(product);
                fewestProduct = product;
            }
        }
        return fewestProduct;
    }
}
