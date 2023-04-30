package commands;

import cache.StoreCache;
import models.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetMostPopularProductCommand implements Command{
    Map<String, ArrayList<Transaction>> orders;

    @Override
    public void execute(String[] args, StoreCache cache) {
        if (args.length != 0) {
            System.out.println("Invalid number of arguments. Usage: get_most_popular_product ");
            return;
        }
        orders = cache.getOrders();
        if(orders.isEmpty()){
            System.out.println("There are no orders in order book yet");
            return;
        }
        System.out.println(getMostPopular());
    }
    private String getMostPopular(){
        int maxCount = 0;
        String mostPopular = "";
        for(String product : orders.keySet()){
            ArrayList<Transaction> productOrders = orders.get(product);
            int orderCount = 0;
            for (int i = 0; i < productOrders.size(); i++) {
                orderCount+=productOrders.get(i).getOrderQty();
            }
            if(orderCount>=maxCount){
                maxCount = orderCount;
                mostPopular = product;
            }
        }
        return mostPopular;
    }
}
