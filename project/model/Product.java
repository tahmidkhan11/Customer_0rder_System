package project.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private int availableAmount;
    private int reservedAmount;

    public double getPrice(){
        return price;
    }
    public int getAvailableAmount(){ return availableAmount; }

    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
        this.availableAmount = 100;
    }

    public void readyProduct(int quantity){
        reservedAmount += quantity;
        availableAmount -= quantity;
    }
    public void shipProduct(int quantity){
        reservedAmount -= quantity;
    }

    @Override
    public String toString(){
        return "Name: "+name+" Price: "+price+"\n Available amount: "+availableAmount+" Reserved amount: "+reservedAmount;
    }
}
