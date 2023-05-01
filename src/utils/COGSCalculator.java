package utils;

import models.Transaction;

import java.util.ArrayList;

public class COGSCalculator {
    public static double calculateCOGS(ArrayList<Transaction> productOrder, ArrayList<Transaction> productPurchases){
        double averagePurchasePrice = AverageCalculator.calcAverage(productPurchases);
        int orderQty = 0;
        for (int i = 0; i < productOrder.size(); i++) {
            orderQty+=productOrder.get(i).getOrderQty();
        }
        return orderQty*averagePurchasePrice;
    }
}
