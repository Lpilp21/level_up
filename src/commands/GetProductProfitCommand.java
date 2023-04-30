package commands;

import cache.StoreCache;
import models.Transaction;
import utils.AverageCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetProductProfitCommand implements Command{
    Map<String, ArrayList<Transaction>> purchases;
    Map<String, ArrayList<Transaction>> orders;

    @Override
    public void execute(String[] args, StoreCache cache) {
        if (args.length != 1) {
            System.out.println("Invalid number of arguments. Usage: get_product_profit {product_id} ");
            return;
        }
        purchases = cache.getPurchases();
        orders = cache.getOrders();
        String productId = args[0];

        System.out.println(calculateProfit(productId));
    }
    private double calculateProfit(String productId){

        ArrayList<Transaction> productOrders = orders.get(productId);
        ArrayList<Transaction> productPurchases = purchases.get(productId);

        double avgPurchasePrice = AverageCalculator.calcAverage(productPurchases);
        System.out.println(avgPurchasePrice);
        double avgOrderPrice = AverageCalculator.calcAverage(productOrders);
        System.out.println(avgOrderPrice);

        return avgOrderPrice - avgPurchasePrice;

    }
}
