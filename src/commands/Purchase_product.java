package commands;
import models.Order;
import models.Product;
import models.Purchase;

import java.util.List;
import java.util.Map;

public class Purchase_product implements Command{
    private Map<String, Purchase> purchases;
    private Purchase purchase;
    public Purchase_product(Map<String, Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public void execute(List<String> args) {
        if (args.size() != 3) {
            System.out.println("Invalid number of arguments. Usage: purchase_product {product_id} {product_quantity} {price}");
            return;
        }

        String productId = args.get(0);
        int productQty = Integer.parseInt(args.get(1));
        double productPrice = Double.parseDouble(args.get(2));
        purchase = new Purchase(productId, productQty, productPrice);
        if(validatePurchase()){
            purchases.put(productId, purchase);
            balance -= purchase.getOrderQty()*purchase.getProductPrice();
        }

    }
    private boolean validatePurchase(){
        if(purchase.getProductPrice()*purchase.getOrderQty() > balance){
            return false;
        }else{
            return true;
        }
    }
}
