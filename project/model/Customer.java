package project.model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private BankAccount bankAccount;

    private Cart cart;
    private List<OrderInfo> orderInfos;

    public BankAccount getBankAccount(){
        return bankAccount;
    }
    public Cart getCart(){
        return cart;
    }
    public List<OrderInfo> getOrderInfos(){
        return orderInfos;
    }

    public Customer(int id, String name, String password, String address, BankAccount bankAccount, SecurityAnswer securityAnswer){
        super(id,name,password,address,securityAnswer);

        this.bankAccount = bankAccount;

        cart = new Cart();
        orderInfos = new ArrayList<>();
    }
}
