package utils;

import models.Transaction;

import java.util.ArrayList;

public class AverageCalculator {
    public static double calcAverage(ArrayList<Transaction> transactions){
        double total = 0;
        int count = 0;
        for (int i = 0; i < transactions.size(); i++) {
            total+= transactions.get(i).getTotal();
            count+= transactions.get(i).getOrderQty();
        }
        if(count == 0){
            return 0;
        }
        return total/count;
    }
}
