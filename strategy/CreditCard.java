package TOMATO.strategy;

public class CreditCard implements PaymentStrategy{

    private String cardNumber;

    public CreditCard(String card) {
        this.cardNumber = card;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card (" + cardNumber + ")");
    }
    
}
