package com.company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //region Task2
        String StringBuf = "";
        System.out.print("Введите название файла: ");
        StringBuf = in.nextLine();
        StringBuf.trim();

        System.out.print("Введите кол-во автомобилей которые хотите занести в базу: ");
        int IntBuf = in.nextInt();

        //FileManager F = new FileManager("Test.txt");
        FileManager F = new FileManager(StringBuf);

        if(F.FileExist()){
            System.out.println("Файл существует");
        }else{
            System.out.println("Файл не существует и будет создан.");
            try {
            F.CreateFile();
            }
            catch (Exception e){
                System.err.println(e);
            }

        }

        for(int i = 0; i < IntBuf; ++i){
            System.out.println("Вы вводите автомобиль №" + (i + 1));
            System.out.print("Введите модель автомобиля: ");
            String StringBuf1 = in.nextLine();
            System.out.print("Введите номер автомобиля: ");
            String StringBuf2 = in.nextLine();
            System.out.print("Введите цвет автомобиля: ");
            String StringBuf3 = in.nextLine();
            System.out.print("Введите Имя владельца: ");
            String StringBuf4 = in.nextLine();
            System.out.print("Введите Фамилию владельца: ");
            String StringBuf5 = in.nextLine();
            System.out.print("Введите аддрес: ");
            String StringBuf6 = in.nextLine();
            System.out.print("Введите дату пследнего тех.осмотра (xx.xx.xxxx): ");
            String StringBuf7 = in.nextLine();

            Car car = new Car(StringBuf1,StringBuf2,StringBuf3,StringBuf4,StringBuf5,StringBuf6,StringBuf7);
            try {
                //F.CreateFile();
                F.WriteInFile(car);
                ArrayList<Car> Cars = F.GetCars();
            }
            catch (IOException e){
                System.err.println("Ошибка: " + e);
            }
        }

        //Car car = new Car("Tesla cybertrack", "е404рр777", "Белоснежно-чёрный", "Илон", "Маск", "Калифорния", "23.04.2018");
        //System.out.println(F.FindOwner("e404pp777"));

        try {
            System.out.println("Введите номер автомобиля что бы найти владельца: ");
            StringBuf = in.nextLine();
            System.out.println(F.FindOwner(StringBuf));
            ArrayList<Car> Cars = F.GetCars();

        }
        catch (IOException e){
            System.err.println("Ошибка: " + e);
        }
        //endregion
    }
}
