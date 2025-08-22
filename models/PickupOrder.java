package TOMATO.models;

public class PickupOrder extends Order {

    private String resturantAddress;
    
    public PickupOrder(){
        this.resturantAddress = "";
    }

    @Override
    public String getType() {
        return "Pickup";
    }

    public String getResturantAddress(){
        return resturantAddress;
    }

    public void setResturantAddress(String address){
        resturantAddress = address;
    }
    
}
