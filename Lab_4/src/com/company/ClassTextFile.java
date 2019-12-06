package com.company;
import java.io.File;
import java.io.Serializable;
import java.util.Scanner;

public class ClassTextFile implements Serializable{
    String file = "";

    ClassTextFile(String f){
        if (new File(f).exists()){
            file = f;
        }else{
            System.out.println("File doesn't exist");
        }
    }

    public void fill(Car car) throws Exception{
        Scanner scanner = new Scanner(new File(file));

        while (scanner.hasNextLine()){
            car.SetColor(scanner.next());
            car.SetName(scanner.next());
            car.SetScndName(scanner.next());
            car.SetAddress(scanner.next());
            car.SetModel(scanner.next());
            car.SetDate(scanner.next());
            car.SetNum(scanner.next());
        }
        scanner.close();
    }

}