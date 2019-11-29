package com.company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String Buf = in.nextLine();
	    //Car car = new Car("", Buf, "", "", "", "", Buf);
        Car car = new Car("Tesla cybertrack", "е404рр777", "Белоснежно-чёрный", "Илон", "Маск", "Калифорния", "23.04.2018");

        FileManager F = new FileManager("Test.txt");
        //System.out.println(F.GetCarString(car));
        try {
            //F.CreateFile();
            F.WriteInFile(car);
            ArrayList<Car> Cars = F.GetCars();
            System.out.println(F.FindOwner("e404pp777"));
            //System.out.println(F.ReadInFile());
        }
        catch (IOException e){
            System.out.println("Ошибка: " + e);
        }
    }
}
