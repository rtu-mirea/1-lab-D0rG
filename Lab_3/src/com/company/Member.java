package com.company;
import java.util.ArrayList;

public class Member extends User {
    private ArrayList<String> requests = new ArrayList<>();

    public Member(String Name, String Login, String Password) {
        super(Name, Login, Password);
    }

    public void addRequest(String place, int day, int from, int to){

    }

    public ArrayList getRequests(){
        return requests;
    }
}
