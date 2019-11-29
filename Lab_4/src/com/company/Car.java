package com.company;

public class Car {
    private String Model, Number, Color, Name, ScndName, Address, Date;

    public Car(String Model, String Number, String Color, String Name, String ScndName, String Address, String Date){
        SetNum(Number);
        SetDate(Date);
    }

    public void SetModel(String Model){ this.Model = Model; }

    public void SetNum(String Number){
        Number = Number.trim();
        String NumberPater = "[а-я]{1}\\d{3}[а-я]{2}\\d{2,3}";
        String Numbers[] = Number.split("\\."); //Only dot

        if(Number.matches(NumberPater)){
            System.out.println("Номер правильный");
            this.Number = Number;
        }
        else{
            throw new RuntimeException("Number err" + " " + Number);
        }
        this.Number = Number;
    }

    public void SetColor(String Color){ this.Color = Color; }
    public void SetName(String Name){ this.Name = Name; }
    public void SetScndName(String Model){ this.ScndName = ScndName; }

    public void SetDate(String Date){
        Date = Date.trim();
        String DatePater = "\\d{2}.\\d{2}.\\d{4}";
        String Numbers[] = Date.split("\\."); //Только точка между числами даты

        if(Date.matches(DatePater) && Numbers.length == 3 && Integer.parseInt(Numbers[0]) < 32 && Integer.parseInt(Numbers[1]) < 13){
            System.out.println("дата правильная");
            this.Date = Date;
        }
        else{
            throw new RuntimeException("Date err" + " " + Date);
        }
    }

    public void SetAddress(String Address) throws RuntimeException{ this.Address = Address;  }
}
