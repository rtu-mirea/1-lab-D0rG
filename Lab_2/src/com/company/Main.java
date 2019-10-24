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
        else if(Buf == 2)
        {

        System.out.println("Введите текст соответствующий заданию");
        String S = "";

        while(S.compareTo("") == 0){ //не занл как точно сделать чтение, но этот вариант сработал
        S = in.nextLine();
        }
        StringBuffer NewS = new StringBuffer(S);
        S = "";
        Task_2 T2 = new Task_2(NewS);
        System.out.println();
        //aaaa aaaa aaaa aaaa. aaaa aaaa aaaa aaaa. aaaa aaaa aaaa aaaa. aaaa aaaa aaaa aaaa. aaaa aaaa aaaa aaaa.

            System.out.println("Текст после удаления последнего слова из первого и третьего предложения: ");
            System.out.println(T2.Del());

            System.out.println("Введите предложение: ");
            while(S.compareTo("") == 0){
                S = in.nextLine();
            }
            System.out.println(T2.AddText(S));
            S = "";

            System.out.println("Введите слово: ");
            while(S.compareTo("") == 0){
                S = in.nextLine();
            }
            System.out.println(T2.AddWord(S));
        }
    }
}
