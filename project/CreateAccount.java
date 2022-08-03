package project;

import project.model.SecurityAnswer;
import project.model.SecurityQuestion;
import project.service.UserService;
import java.util.Scanner;
import javax.swing.JOptionpane;

public class CreateAccount {
    private static UserService userService;
    private static Database db;

    public static void main(String[] args)
    {
        userService = new UserService();
        db = new Database();
        int id;
        String password;
        String name;
        String address;
        String creditCard;
        int questionNumber;
        String answer;

        String t = JOptionpane.ShowInputDialog("Enter you new id");
        id = t;
        if(!userService.idExist(id)){
            s = JOptionpane.ShowInputDialog("Enter password")
            password = t;
            if(userService.passwordValid(password)){
                t = JOptionpane.ShowInputDialog("Enter name");
                name = t ;
                JOptionpane.ShowInputDialog("Enter address")
                address = t;
                t = JOptionpane.ShowInputDialog("Enter creditcardnumber")
                creditCard = t;
                if(userService.creditCardValid(creditCard)){
                    System.out.println("Enter your security question number: ");
                    for(SecurityQuestion question: db.questions){
                        System.out.println(question.getId()+": "+question.getQuestion());
                    }
                    s = new Scanner(System.in);
                    System.out.println("number: ");
                    questionNumber = s.nextInt();
                    if(userService.getSecurityQuestion(questionNumber)!=null){
                        System.out.print("Enter answer: ");
                        s = new Scanner(System.in);
                        answer = s.nextLine();
                        if(userService.createCustomerAccount(id, name, password, address, creditCard, new SecurityAnswer(questionNumber, answer))){
                            System.out.println("Creating account successful!");
                        }
                        else{
                            System.out.println("Something went wrong");
                        }
                    }
                    else{
                        System.out.print("Invalid number!");
                    }
                }
                else {
                    System.out.print("Invalid credit card!");
                }
            }
            else {
                System.out.println("Invalid password!!");
            }
        }
        else{
            System.out.println("Id already exist!");
        }
    }
}
