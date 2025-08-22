package TOMATO.strategy;

public class UPIPayment implements PaymentStrategy {

    private String mobile;

    public UPIPayment(String mobile){
        this.mobile=mobile;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Payment is done using UPI on: " + mobile + ". Amount: " + amount);
    }
    
}
