package TOMATO.models;

import java.util.ArrayList;
import java.util.List;

public class Resturant {
    private static int nextResturantId = 0;
    private int id;
    private String name;
    private String location;
    private List<MenuItem> menu = new ArrayList<>(); 
    
    public Resturant(String name, String location){
        this.id=++nextResturantId;
        this.name=name;
        this.location=location;
    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        name = n;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String loc){
        location = loc;
    }

    public List<MenuItem> getMenu(){
        return menu;
    }

    public void addMenu(MenuItem item){
        menu.add(item);
    }

}
