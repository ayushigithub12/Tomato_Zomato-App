package TOMATO.models;

public class DeliveryOrder extends Order {

    private String userAddress;

    public DeliveryOrder(){
        this.userAddress = "";
    }

    @Override
    public String getType() {
        System.out.println("Delivery");
        return "Delivery";
    }

    public String getUserAddress(){
        return userAddress;
    }

    public void setUserAddress(String address){
        userAddress = address;
    }
    
}
