package TOMATO;

import java.util.List;

import javax.management.Notification;

import TOMATO.factory.NowOrderFactory;
import TOMATO.factory.OrderFactory;
import TOMATO.factory.ScheduleOrderFactory;
import TOMATO.managers.OrderManager;
import TOMATO.managers.ResturantManager;
import TOMATO.models.Cart;
import TOMATO.models.MenuItem;
import TOMATO.models.Order;
import TOMATO.models.Resturant;
import TOMATO.models.User;
import TOMATO.service.NotificationService;
import TOMATO.strategy.PaymentStrategy;
import TOMATO.strategy.UPIPayment;

public class TomatoApp {
    public TomatoApp() {
        initializeRestaurants();
    }

    public void initializeRestaurants(){
        Resturant restaurant1 = new Resturant("Bikaner", "Pune");
        restaurant1.addMenu(new MenuItem("P1", "Chole Bhature", 120));
        restaurant1.addMenu(new MenuItem("P2", "Samosa", 15));

        Resturant restaurant2 = new Resturant("Haldiram", "Kolkata");
        restaurant2.addMenu(new MenuItem("P1", "Raj Kachori", 80));
        restaurant2.addMenu(new MenuItem("P2", "Pav Bhaji", 100));
        restaurant2.addMenu(new MenuItem("P3", "Dhokla", 50));

        Resturant restaurant3 = new Resturant("Saravana Bhavan", "Chennai");
        restaurant3.addMenu(new MenuItem("P1", "Masala Dosa", 90));
        restaurant3.addMenu(new MenuItem("P2", "Idli Vada", 60));
        restaurant3.addMenu(new MenuItem("P3", "Filter Coffee", 30));

        ResturantManager restaurantManager = ResturantManager.getInstance();
        restaurantManager.addResturant(restaurant1);
        restaurantManager.addResturant(restaurant2);
        restaurantManager.addResturant(restaurant3);
    }

    // search the location in tomato and list down the resturants
    public List<Resturant> searchByLocation(String location){
        return ResturantManager.getInstance().searchByLocation(location);
    }

    // select a resturant
    public void selectResturant(User user, Resturant resturant){
        Cart cart = user.getCart();
        cart.setResturant(resturant);
    }

    // Add items in the cart
    public void addToCart(User user, String foodItemCode){
        Resturant resturant = user.getCart().getResturant();
        if(resturant == null){
            System.out.println("Select a resturant");
            return;
        }

        for(MenuItem item: resturant.getMenu()){
            if(item.getCode().equals(foodItemCode)){
                user.getCart().addToCart(item);
                break;
            }
        }
    }

    //Order now
    public Order checkoutN(User user, String orderType, PaymentStrategy paymentStrategy){
        return checkout(user, orderType, paymentStrategy, new NowOrderFactory());
    }

    public Order checkoutSchedule(User user, String orderType, PaymentStrategy paymentStrategy, String scheduleTime){
        return checkout(user, orderType, paymentStrategy, new ScheduleOrderFactory(scheduleTime));
    }

    // checkout logic
    public Order checkout(User user, String orderType, PaymentStrategy paymentStrategy, OrderFactory orderFactory){

        //check if the cart is not empty
        if(user.getCart().isEmpty()) return null;

        Cart userCart = user.getCart();
        Resturant resturant = userCart.getResturant();
        List<MenuItem> menuItem = resturant.getMenu();
        double totalCost = user.getCart().getTotalCost();
        
        // create the order and then add the order 
        Order order = orderFactory.createOrder(resturant, user, userCart, paymentStrategy, menuItem, totalCost, orderType);
        OrderManager.isInstance().addOrder(order);
        return order;
    }

    public void payForOrder(User user, Order order){
        boolean ispayment = order.processPayment();

        if(ispayment){
            NotificationService.notify(order);
            user.getCart().clear();
        }
    }

    // print the cart items and the other user requirements
    public void printUserCart(User user){
        System.out.println("Items in cart:");
        System.out.println("------------------------------------");
        for (MenuItem item : user.getCart().getItems()) {
            System.out.println(item.getCode() + " : " + item.getName() + " : ₹" + item.getPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("Grand total : ₹" + user.getCart().getTotalCost());
    }

}
