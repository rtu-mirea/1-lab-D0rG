package com.company;
import java.util.*;
import java.util.ArrayList;

public class Main { //GroupMeetSystem
    ArrayList<User> Users = new ArrayList<>();
    ArrayList<String> places = new ArrayList<>();
    //ArrayList, а не линкед, т.к. при добавлении быстрее
    User currentUser;

    public static void main(String[] args) {

    }

    private void addUser(String name, String login, String password, String repeation, int type){
        for(User user : Users){
            if((user.getLogin()).compareTo(login) == 0){
                System.out.println("Логин занят другим пользователем");
                return;
            }
        }

        User us;

        switch (type) { //не люблю данную конструкцию, но тут она номрас
            default:
                us = new Member(name, login, password);
                break;
            case (0):
                us = new Admin(name, login, password);
                break;
        }

        Users.add(us);
        currentUser = us;
    }

    private User findUser(String login, String password){
        for(User user : Users){
            if(user.getLogin().compareTo(login) == 0 && user.getPassword().compareTo(password) == 0){
              return user;
            }
        }
       //return new Member(null, null, null);
        return null;
    }

    private void save(){

    }

    private void load(){

    }

    private ArrayList<Request> processRequests(){
        ArrayList<Request> CommonRequests = null;

        for (User us : Users) {
            if (us instanceof Member) {
                Member mmbr = (Member)us;

                if (CommonRequests == null) {
                    CommonRequests = mmbr.requests;
                }
                else {
                    ArrayList<Request> SavedCommon = new ArrayList<>();

                    for (Request BufRequest : CommonRequests) {
                        for (Request request : mmbr.requests) {

                            if (request.getPlace().compareTo(BufRequest.getPlace()) == 0 && !SavedCommon.contains(BufRequest)) {

                                if (request.getDay() == BufRequest.getDay()) {

                                    if (request.getStartHour() > BufRequest.getStartHour()) {
                                        BufRequest = new Request(BufRequest.getPlace(), BufRequest.getDay(), request.getStartHour(), BufRequest.getEndHour());
                                    }
                                    if (request.getEndHour() < BufRequest.getEndHour()) {
                                        BufRequest = new Request(BufRequest.getPlace(), BufRequest.getDay(), BufRequest.getStartHour(), request.getEndHour());
                                    }

                                    if (BufRequest.getStartHour() <= BufRequest.getEndHour()) {
                                        SavedCommon.add(BufRequest);
                                    }
                                }
                            }
                        }
                    }

                    CommonRequests = new ArrayList<>();

                    for (Request BufRequest : SavedCommon) {
                        CommonRequests.add(BufRequest);
                    }

                }
                 mmbr.requests = new ArrayList<>();
            }
        }

        return CommonRequests;
    }
}
