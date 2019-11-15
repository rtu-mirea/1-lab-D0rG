package com.company;
import java.util.ArrayList;

public class Member extends User {
    private ArrayList<Request> requests = new ArrayList<>();

    public Member(String Name, String Login, String Password) {
        super(Name, Login, Password);
    }

    public void addRequest(String place, int day, int from, int to){
        requests.add(new Request(place, day, from, to));
    }

    public ArrayList getRequests(){
        return requests;
    } //На до ли писать что именно в листе
}
