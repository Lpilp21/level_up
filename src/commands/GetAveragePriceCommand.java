package commands;

import cache.StoreCache;
import models.Transaction;
import utils.AverageCalculator;

import java.util.ArrayList;
import java.util.Map;

public class GetAveragePriceCommand implements Command{
    Map<String, ArrayList<Transaction>> purchases;
    @Override
    public void execute(String[] args, StoreCache cache) {
        if (args.length != 1) {
            System.out.println("Invalid number of arguments. Usage: get_average_price {product_id} ");
            return;
        }
        purchases = cache.getPurchases();

        String productId = args[0];
        if(!purchases.containsKey(productId)){
            System.out.println("There is no such product with that ID");
            return;
        }
        System.out.println(AverageCalculator.calcAverage(purchases.get(productId)));
    }
}
