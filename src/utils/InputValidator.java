package utils;

public class InputValidator {
    public static boolean valid(double input){
        if(input<= 0){
            System.out.println("Enter valid value, qty and price should have positive value");
            return false;
        }
        return true;

    }
}
