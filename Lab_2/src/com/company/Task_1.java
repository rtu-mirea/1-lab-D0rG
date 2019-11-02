package com.company;
import javafx.scene.control.ButtonBar;

import javax.print.attribute.standard.NumberOfDocuments;

import java.io.*;
import java.io.FileReader;
import java.io.IOException;



public class Task_1 {

    public String TextOut = "";
    int Obj = 0;
    String ListObj = "";
    int CountConst = 0;
    int KeyAdd = 0;
    String ListKeyAdd = "";

    public void  ReadTxtFile(String fileName) { // статический метод для чтения файла
        // блок try/catch необходим, так как в результате
        // чтения файла могут возникнуть ошибки
        try {
            // создаем экземпляр класса FileReader
            FileReader tfr = new FileReader(fileName);
            // создаем в памяти буфер для чтения 8Кб символов за раз
            char[] buffer = new char[8096];

            int chars = tfr.read(buffer);

            // до тех пор пока есть символы в файле, читаем данные
            // и выводим в консоль
            while (chars != -1) {
                //System.out.println(String.valueOf(buffer, 0, chars));
                TextOut += String.valueOf(buffer, 0, chars);
                chars = tfr.read(buffer);
            }
            // закрываем файл
            tfr.close();
            // отлавливаем исключение
        } catch (IOException e) {
            e.printStackTrace();
        }
        NumObj(TextOut);
    }

    public Task_1(){
       ReadTxtFile("Text.txt");
    }

    public void NumObj(String TEXT){
        //Trim убирает табуляцию. обтект всё где "= new"
        String[] lines = TEXT.split("\\n");

        for(int i = 0; i < lines.length; i++){
            lines[i] = lines[i].trim();

            //System.out.println(lines[i]);
            String[] Buff = lines[i].split(" "); // int X = new int();
            if(Buff.length >= 4 && Buff[2].compareTo("=") == 0 && Buff[3].compareTo("new") == 0){
                Obj++;
                ListObj += "(" + Buff[0] + ") " + Buff[1] + "; ";
            }
            if(Buff[0].compareTo("final") == 0) CountConst++;

            if(Buff.length >= 0){
                int index = lines[i].lastIndexOf("in.next");
                if(index != -1){
                    for(int z = Buff.length - 1; z > 0; --z) {
                        if(Buff[z].compareTo("=") == 0)  ListKeyAdd += Buff[z - 1] + "; ";
                    }
                }
            }
        }
    }
}

