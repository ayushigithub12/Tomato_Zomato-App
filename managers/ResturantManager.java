package TOMATO.managers;

import java.util.ArrayList;
import java.util.List;

import TOMATO.models.Resturant;

public class ResturantManager {
    
    private List<Resturant> resturants = new ArrayList<>();
    private static ResturantManager instance = null;
    
    private ResturantManager(){
        //private constructor
    }

    public static ResturantManager getInstance(){
        if(instance==null){
            instance = new ResturantManager();
        }
        return instance;
    }

    public void addResturant(Resturant r){
        resturants.add(r);
    }

    public List<Resturant> searchByLocation(String loc){
        List<Resturant> resturant = new ArrayList<>();
        loc = loc.toLowerCase();
        for(Resturant r: resturants){
            String r1 = r.getLocation().toLowerCase();
            if(r1.equals(loc)){
                resturant.add(r);
            }
        }
        return resturant;
    }

}
