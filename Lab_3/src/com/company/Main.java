package com.company;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main { //GroupMeetSystem
    ArrayList<User> Users = new ArrayList<>();
    ArrayList<String> places = new ArrayList<>();
    //ArrayList, а не линкед, т.к. при добавлении быстрее
    User currentUser = null;
    Scanner in = new Scanner(System.in);

    public void main(String[] args) throws RuntimeException {
        int buf = -1;

        if(currentUser == null){
            System.out.println("Вход в систему/регестрация : 0/1");
        }
        else if(currentUser instanceof Admin){
            System.out.println("Вы вошли в стистему, как Администратор");
            System.out.println("Выход из системы: 2");
            System.out.println("Получить результаты: 1");
            System.out.println("Добавить место: 0");
        }
        else if(currentUser instanceof Member){
            System.out.println("Вы вошли в стистему, как " + currentUser.getLogin());
            System.out.println("Голосование: 1");
            System.out.println("Выход из системы: 2");
        }

        System.out.print("Ваш выбор: ");
        try {
            buf = in.nextInt();
        }
        catch (RuntimeException e){
            throw new RuntimeException(e);
        }

        String Place;
        int Time;
        if(currentUser == null){
            String UserLogin;
            String UserPass;


            switch (buf){
                case 1:
                    //регестрация
                    System.out.print("Введите имя пользователя: ");
                    String name = in.nextLine();
                    System.out.print("Введите логин: ");
                    UserLogin = in.nextLine();
                    System.out.print("Введите пароль: ");
                    Place = in.nextLine();
                    addUser(name, UserLogin, Place, Users.size());
                    System.out.println("Позьзователь был создан");
                    break;
                case 0:
                    //вход в систему
                    System.out.print("Введите логин: ");
                    UserLogin = in.nextLine();
                    System.out.print("Введите пароль: ");
                    UserPass = in.nextLine();
                    currentUser = findUser(UserLogin, UserPass);
                    if(currentUser == null) { System.out.println("\nПользователь не найден"); }
                    break;
                default:
                    buf = 0;
                    break;
            }
        }
        else if(currentUser instanceof Admin){
            switch (buf){
                case 1:
                    //получить результат
                    ArrayList<Request> res = processRequests();
                    System.out.println(res.toString());
                    break;
                case 2:
                    //выход из системы
                    currentUser = null;
                    System.out.println("Выход выполнен");
                    buf = -1;
                    break;
                case 0:
                    //добавить место
                    System.out.print("Назваите новое место: ");
                    places.add(in.nextLine());
                    System.out.println("Место добавлено");
                    break;
            }
        }
        else if(currentUser instanceof Member){
            if(buf == 2){
                currentUser = null;
                System.out.println("Выход выполнен");
                buf = -1;
            }
            else if(buf == 1){
                int placeIndex;
                for(placeIndex = 0; placeIndex < places.size(); ++placeIndex) {
                    System.out.println("[" + placeIndex + "] " + (String)places.get(placeIndex));
                }

                do {
                    do {
                        System.out.print("Выберите место: ");
                        placeIndex = in.nextInt();
                    } while(placeIndex < 0);
                } while(placeIndex >= places.size());

                Place = (String)places.get(placeIndex);
                System.out.println("[0] пн [1] вт [2] ср [3] чт [4] пт [5] сб [6] вс");

                int day;
                do {
                    do {
                        System.out.print("Выберите день недели: ");
                        day = in.nextInt();
                    } while(day < 0);
                } while(day > 6);

                System.out.println("[0-23]");

                do {
                    do {
                        System.out.print("Удобно с часа: ");
                         Time = in.nextInt();
                    } while(Time < 0);
                } while(Time > 23);

                int endTime;
                do {
                    do {
                        System.out.print("До часа (включительно): ");
                        endTime = in.nextInt();
                    } while(endTime < 0);
                } while(endTime > 23 || endTime < Time);

                Member currentMember = (Member)currentUser;
                currentMember.addRequest(Place, day, Time, endTime);
                System.out.println("Ваше мнение по данному месту учтено");
            }
        }
    }

    private void addUser(String name, String login, String password, int type){
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
