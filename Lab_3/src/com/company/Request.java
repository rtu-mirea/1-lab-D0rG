package com.company;

public class Request {
    private String place;
    private int dayOfWeek;
    private int startHour;
    private int endHour;

    public Request(String place, int day, int from, int to){

    }

    public String getPlace(){ return place; }
    public int getDay(){ return dayOfWeek; }
    public int getStartHour(){ return startHour; }
    public int getEndHour(){ return endHour; }
}
