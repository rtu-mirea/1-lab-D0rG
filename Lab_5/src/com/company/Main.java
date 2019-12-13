package com.company;
import java.util.ArrayList;

public class Main {

    public static ArrayList<User> Users = new ArrayList<>();
    public static ArrayList<String> places = new ArrayList<>();
    public static User currentUser = null;

    public static void main(String[] args) {
        Users.add(new Admin("admin", "admin", "admin"));
        Users.add(new Member("1", "1", "1"));
        places.add("Бауманка");
	    LoginWindow window = new LoginWindow();
	    window.setVisible(true);
    }
}
