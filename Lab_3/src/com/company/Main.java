package com.company;

import java.util.ArrayList;

public class Main { //GroupMeetSystem

    public static void main(String[] args) {
        ArrayList<User> Users = new ArrayList<>();
        ArrayList<String> places = new ArrayList<>();
        User currentUser = new User("", "", "");


    }

    private void addUser(String name, String login, String password, String repeation, int type){

    }

    private User findUser(String login, String password){
        User user = new User("", login, password);
        return user;
    }

    private void save(){

    }

    private void load(){

    }

    /*private ArrayList processRequests(){
        return current
    }*/
}
