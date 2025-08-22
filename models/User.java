package TOMATO.models;

public class User {
    private int id;
    private String name;
    private String address;
    private Cart cart;

    public User(int id, String name, String address){
        this.id = id;
        this.name=name;
        this.address=address;
        cart = new Cart();
    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        name = n;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String n){
        address = n;
    }

    public Cart getCart() {
        return cart;
    }


}
