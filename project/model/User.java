package project.model;

public abstract class User {
    private int id;
    private String name;
    private String password;
    private String address;
    private SecurityAnswer securityAnswer;

    public int getId(){
        return id;
    }
    public String getPassword(){
        return password;
    }
    public SecurityAnswer getSecurityAnswer(){
        return securityAnswer;
    }

    public User(int id, String name, String password, String address, SecurityAnswer securityAnswer){
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
        this.securityAnswer = securityAnswer;
    }
}
