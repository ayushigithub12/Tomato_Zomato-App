package TOMATO.models;

import java.util.List;

import TOMATO.strategy.PaymentStrategy;

public abstract class Order {
    private static int nextOrderd = 0;
    private int id;
    private Resturant resturant;
    private List<MenuItem> items;
    private PaymentStrategy paymentStrategy;
    private User user;
    private double total;
    private String schedule;

    public Order(){
        this.id = ++nextOrderd;
        this.user = null;
        this.paymentStrategy = null;
        this.resturant = null;
        this.total = 0.0;
        this.schedule = "";
    }

    public boolean processPayment(){
        if(paymentStrategy!=null){
            paymentStrategy.pay(total);
            return true;
        }
        else{
            System.out.println("Choose a payment option");
            return false;
        }
    }

    // abstract class for getType
    public abstract String getType();

    // getters and setters

    public void setSchedule(String s){
        schedule = s;
    }

    public String getSchedule(){
        return schedule;
    }

    public void setTotal(double d){
        total = d;
    }

    public double getTotal(){
        return total;
    }

    public void setUser(User u){
        user = u;
    }

    public User getUser(){
        return user;
    }

    public void setPaymentStrategy(PaymentStrategy p) {
        paymentStrategy = p;
    }

    public List<MenuItem> getItems(){
        return items;
    }

    public void setItems(List<MenuItem> its){
        items = its;
        total = 0;
        for(MenuItem it:items){
            total+=it.getPrice();
        }
    }

    public void setResturant(Resturant r){
        resturant = r;
    }

    public Resturant getResturant(){
        return resturant;
    }

    public int getId(){
        return id;
    }




}
