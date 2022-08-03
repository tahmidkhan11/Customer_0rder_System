package project.model;

public class SecurityAnswer {
    private int questionNumber;
    private String answer;

    public int getQuestionNumber(){
        return questionNumber;
    }
    public String getAnswer(){
        return answer;
    }
    public SecurityAnswer(int questionNumber, String answer){
        this.questionNumber = questionNumber;
        this.answer = answer;
    }
}
