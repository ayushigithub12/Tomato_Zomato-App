package TOMATO.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Resturant resturant;
    private List<MenuItem> menu = new ArrayList<>(); 

    public Cart(){
        resturant = null;
    }

    public void addToCart(MenuItem item){
        if(resturant==null){
            System.out.println("Set a resturnat before adding an item");
        }
        menu.add(item);
    }

    public double getTotalCost(){
        double sum = 0;
        for(MenuItem it: menu){
            sum+=it.getPrice();
        }
        return sum;
    }

    public boolean isEmpty(){
        return resturant == null || menu.isEmpty();
    }

    public void clear(){
        menu.clear();
        resturant = null;
    }

    public Resturant getResturant(){
        return resturant;
    }

    public void setResturant(Resturant r){
        resturant = r;
    }

    public List<MenuItem> getItems(){
        return menu;
    }

}
