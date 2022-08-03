package project.service;

import project.Database;
import project.model.*;

public class UserService {
    private final Database db;
    public UserService(){
        db = new Database();
    }

    //LOG ON-------------------------------------------------------------------------------------------------
    public boolean logon(int id, String password){
        if (getUser(id, password)!=null){
            return true;
        }
        return false;
    }
    //Logon: Check id and password
    public User getUser(int id, String password){
        for (User user: db.users){
            if(user.getId()==id && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
    //Logon: Get security question
    public SecurityQuestion getSecurityQuestion(int id){
        for (SecurityQuestion question: db.questions){
            if(question.getId() == id){
                return question;
            }
        }
        return null;
    }
    public boolean correctAnswer(User user, String answer){
        if(user.getSecurityAnswer().getAnswer().equals(answer)){
            return true;
        }
        return false;
    }

    //CREATE ACCOUNT-----------------------------------------------------------------------------------------
    public boolean createCustomerAccount(int id, String name, String password, String address, String creditCard, SecurityAnswer securityAnswer){
        BankAccount account;
        if(creditCartExist(creditCard)){
            account = getAccount(creditCard);
        } else {
            account = new BankAccount(creditCard);
        }

        if(!idExist(id) && passwordValid(password) && creditCardValid(creditCard)){
            User customer = new Customer(id, name, password, address, account, securityAnswer);
            db.users.add(customer);
            return true;
        }
        return false;
    }
    public boolean createSupplierAccount(int id, String name, String password, String address, SecurityAnswer securityAnswer){
        if(!idExist(id) && passwordValid(password)){
            User supplier = new Supplier(id, name, password, address, securityAnswer);
            db.users.add(supplier);
            return true;
        }
        return false;
    }
    //Create Account: Check id
    public boolean idExist(int id){
        for(User user: db.users){
            if(user.getId() == id){
                return true;
            }
        }
        return false;
    }
    //Create Account: Check validity of password
    public boolean passwordValid(String password){
        if(password.length()>=6 && containsUpperCaseCharacter(password) && containsLowerCaseCharacter(password) && containsNumberCharacter(password)){
            return true;
        }
        return false;
    }
    //Create Account: Check uppercase
    private boolean containsUpperCaseCharacter(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    //Create Account: Check lowercase
    private boolean containsLowerCaseCharacter(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLowerCase(string.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    //Create Account: Check number
    private boolean containsNumberCharacter(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    //Create Account: Check valid credit card number
    public boolean creditCardValid(String number){
        if(number.length()==16 && creditCardAllNumber(number)){
            return true;
        }
        return false;
    }
    private boolean creditCardAllNumber(String string){
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    //Create Account: Get already-existed bank account
    private BankAccount getAccount(String number){
        for(BankAccount account: db.accounts){
            if(account.getCreditNumber()==number){
                return account;
            }
        }
        return null;
    }
    //Create Account: Check if credit card number already exist
    private boolean creditCartExist(String number){
        if(getAccount(number)!=null){
            return true;
        }
        return false;
    }
}
