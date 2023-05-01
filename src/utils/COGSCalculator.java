package utils;

import models.Transaction;

import java.util.ArrayList;

public class COGSCalculator {
    public static double calculateCOGS(Transaction productOrder, ArrayList<Transaction> productPurchases){
        double averagePurchasePrice = AverageCalculator.calcAverage(productPurchases);
        return productOrder.getOrderQty()*averagePurchasePrice;
    }
}
