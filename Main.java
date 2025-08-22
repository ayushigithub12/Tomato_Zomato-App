package TOMATO;

import java.util.List;

import TOMATO.models.Order;
import TOMATO.models.Resturant;
import TOMATO.models.User;
import TOMATO.strategy.UPIPayment;

public class Main {

    public static void main(String[] args){

    TomatoApp tomato = new TomatoApp();

    // User comes 
    User user = new User(101, "Ayushi Sharma", "Pune");
    System.out.println("User: " + user.getName() + " is active.");

    // User search for an location
    List<Resturant> resturantList = tomato.searchByLocation("Pune");

    if(resturantList.isEmpty()){
        System.out.println("No resturants found");
        return;
    }

    // Get the list of resturants
    System.out.println("Getting the list of resturants.");
    for(Resturant resturant: resturantList){
        System.out.println(" - " + resturant.getName());
    }

    // User add item in the cart
    tomato.selectResturant(user, resturantList.get(0));
    System.out.println("Selected resturant is: " + resturantList.get(0).getName());
    tomato.addToCart(user, "P1");
    tomato.addToCart(user, "P2");

    tomato.printUserCart(user);

    // User checkout the cart
    Order order = tomato.checkoutN(user, "Delivery", new UPIPayment("e78383"));

    // User pay for the resturants, if payment successfull. user will get notification
    tomato.payForOrder(user, order);
    }
}
