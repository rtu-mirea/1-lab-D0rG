package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
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

        //region Task1
        String Task1_1 = "MyFile1.txt";
        String Task1_2 = "MyFile2.txt";
        String Task1_3 = "MyFile3.txt";
        String Disc = "D:\\";
        String FolderOld = "OldFolder";
        String FolderNew = "NewFolder";

        try {
            File file1 = new File(Task1_1);
            file1.createNewFile();
            if (file1.exists()) {
                System.out.println("Файл с именем " + Task1_1 + " cуществует");
            }


            File file2 = new File(Disc + Task1_2);
            file2.createNewFile();
            if (file2.exists()) {
                System.out.println("Файл с именем " + Task1_2 + " cуществует");
            }


            File file3 = new File(Disc + FolderOld + Task1_3);
            file3.createNewFile();
            if (file3.exists()) {
                System.out.println("Файл с именем " + Task1_3 + " cуществует");
            }

            File folder1 = new File(FolderNew);
            folder1.mkdir();
            if (folder1.exists()) {
                System.out.println(FolderNew + " теперь существует");
            }
//----------------------------------------------------------------------------------------
            if (file1.isFile()) {
                System.out.println(Task1_1 + " являеться файлом");
            }

            if (folder1.isDirectory()) {
                System.out.println(FolderOld + " являеться папкой");
            }

//            if (f1.exists()) {
//                System.out.println("Файл с именем " + Task1_1 + " cуществует");
//            }

            if (Files.exists(file1.toPath())) {
                System.out.println(Task1_1 + " находиться в дириктории");
            }

            System.out.println(file1.getPath());

            System.out.println("Size of the first file: " + file1.length() + " byte(s);");
            if(file1.isFile()){
                System.out.println("Это файл");
            }
            else {
                System.out.println("Это папка");
            }
//-----------------------------------------------------------------------------------------------
            File folder = new File(FolderNew);
            folder.mkdir();
            if (folder.exists()) {
                System.out.println("Папка с именем " + FolderNew + " существует");
            }
            String currPath = System.getProperty("user.dir");
            File currentDir = new File(currPath);

            for (String Namefile : currentDir.list()) {
                System.out.println(Namefile);
            }

            for (File file : currentDir.listFiles()) {
                System.out.println(file.getPath());
            }

            file1.delete();
            file2.delete();
            file3.delete();
            folder1.delete();
            folder.delete();
        }
        catch (FileNotFoundException e){
            System.err.println(e);
        }
        catch (IOException e){
            System.err.println(e);
        }
        catch (Exception e){
            System.err.println(e);
        }
        //endregion

        //region Task3
        
        //endregion
    }
}
