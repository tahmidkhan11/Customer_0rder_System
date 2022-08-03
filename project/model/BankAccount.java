package project.model;

public class BankAccount {
    private int id;
    private static int counter=1;
    private String creditNumber;
    private double money;

    public String getCreditNumber(){
        return creditNumber;
    }
    public double getMoney(){
        return money;
    }
    public void setMoney(double amount){
        money = amount;
    }
    public BankAccount(String creditNumber){
        id = counter;
        counter++;

        this.creditNumber = creditNumber;
        money = 2000;
    }
}
