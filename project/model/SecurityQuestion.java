package project.model;

public class SecurityQuestion {
    private int id;
    private String question;

    public int getId(){
        return id;
    }
    public String getQuestion() { return question; }

    public SecurityQuestion(int id, String question){
        this.id = id;
        this.question = question;
    }
}
