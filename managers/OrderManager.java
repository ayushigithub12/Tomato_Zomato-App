package TOMATO.managers;

//OrderManager work is to add the order
import java.util.ArrayList;
import java.util.List;

import TOMATO.models.Order;

public class OrderManager {
    
    private List<Order> orderItems = new ArrayList<>();
    private static OrderManager instance=null;
    
    private OrderManager(){
        //Singleton class
    }

    public static OrderManager isInstance(){
        if(instance==null){
            instance = new OrderManager();
        }
        return instance;
    }

    public void addOrder(Order order){
        orderItems.add(order);
    }

    public void listOrder(){
        System.out.println("---Listing out all the order---");

        for(Order item: orderItems){
            System.out.println(item.getType() + " order for " + item.getUser().getName());
            System.out.println("Total Order: " + item.getTotal() + "\n" + 
                                "At: " + item.getSchedule());
        }
    }
}
