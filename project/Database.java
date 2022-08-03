package project;

import project.model.*;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public final List<User> users;
    public final List<BankAccount> accounts;
    public final List<SecurityQuestion> questions;
    public final List<Product> products;
    public final List<OrderInfo> orderInfos;

    public Database(){
        users = new ArrayList<>();
        accounts = new ArrayList<>();
        questions = new ArrayList<>();
        products = new ArrayList<>();
        orderInfos = new ArrayList<>();

        users.add(new Supplier(69, "Supplier", "123Supplier@", "69th Avenue", new SecurityAnswer(4, "Man City")));

        users.add(new Customer(1, "yellow", "123Yellow@", "5th Avenue", new BankAccount("1111111111111111"), new SecurityAnswer(4, "Man City")));
        users.add(new Customer(2, "blue", "123Blue@", "5th Avenue", new BankAccount("2111111111111111"), new SecurityAnswer(4, "Man City")));
        users.add(new Customer(3, "purple", "123Purple@", "5th Avenue", new BankAccount("3111111111111111"), new SecurityAnswer(4, "Man City")));
        users.add(new Customer(4, "black", "123Black@", "5th Avenue", new BankAccount("4111111111111111"), new SecurityAnswer(4, "Man City")));
        users.add(new Customer(5, "white", "123White@", "5th Avenue", new BankAccount("5111111111111111"), new SecurityAnswer(4, "Man City")));
        users.add(new Customer(6, "green", "123Green@", "5th Avenue", new BankAccount("6111111111111111"), new SecurityAnswer(4, "Man City")));
        users.add(new Customer(7, "indigo", "123Indigo@", "5th Avenue", new BankAccount("7111111111111111"), new SecurityAnswer(4, "Man City")));
        users.add(new Customer(8, "pink", "123Pink@", "5th Avenue", new BankAccount("8111111111111111"), new SecurityAnswer(4, "Man City")));
        users.add(new Customer(9, "orange", "123Orange@", "5th Avenue", new BankAccount("9111111111111111"), new SecurityAnswer(4, "Man City")));
        users.add(new Customer(10, "brown", "123Brown@", "5th Avenue", new BankAccount("1211111111111111"), new SecurityAnswer(4, "Man City")));

        accounts.add(new BankAccount("1111111111111111"));
        accounts.add(new BankAccount("2111111111111111"));
        accounts.add(new BankAccount("3111111111111111"));
        accounts.add(new BankAccount("4111111111111111"));
        accounts.add(new BankAccount("5111111111111111"));
        accounts.add(new BankAccount("6111111111111111"));
        accounts.add(new BankAccount("7111111111111111"));
        accounts.add(new BankAccount("8111111111111111"));
        accounts.add(new BankAccount("9111111111111111"));
        accounts.add(new BankAccount("1211111111111111"));

        questions.add(new SecurityQuestion(1,"What is your favourite book?"));
        questions.add(new SecurityQuestion(2, "What is your mother's maiden name??"));
        questions.add(new SecurityQuestion(3, "What was your first pet name?"));
        questions.add(new SecurityQuestion(4, "Which Manchester is better in Premier League?"));
        questions.add(new SecurityQuestion(5, "What is your favourite hobby?"));

        products.add(new Product(1, "Phone-holder", 25.5));
        products.add(new Product(2, "Football", 10.5));
        products.add(new Product(3, "Headphones", 30));
        products.add(new Product(4, "Joystick", 30.5));
        products.add(new Product(5, "Laptop", 400));
        products.add(new Product(6, "Power bank", 250));
        products.add(new Product(7, "Mobile", 25.5));
        products.add(new Product(8, "Mouse", 10));
        products.add(new Product(9, "Keyboard", 12.3));
        products.add(new Product(10, "Speaker", 70));
    }
}
