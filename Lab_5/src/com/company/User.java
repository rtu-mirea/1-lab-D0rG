package com.company;

public class User {
    private String Name;
    private String Login;
    private String Password;

    public User(String Name, String Login, String Password){
        this.Name = Name;
        this.Login = Login;
        this.Password = Password;
    }

    public boolean enter(String Login, String Pass){
        return true;
    }

    public String getName(){ return Name; }
    public String getLogin(){ return Login; }
    public String getPassword(){ return Password; }
}
