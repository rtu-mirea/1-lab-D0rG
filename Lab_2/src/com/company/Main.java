package com.company;
import com.company.Task_1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("выберите задание 1/2/3");
        int Buf = in.nextInt();

        if(Buf == 1){
            Task_1 T1 = new Task_1();
            System.out.println("Создание обтектов: " + T1.Obj);
            System.out.println("Список: " + T1.ListObj);
            System.out.println("Кол-во констант: " + T1.CountConst);
            System.out.println("Ввод с клавы тут: \n" + T1.ListKeyAdd);
        }
    }
}
