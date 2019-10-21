package com.company;
import javafx.scene.control.ButtonBar;

import javax.print.attribute.standard.NumberOfDocuments;
import java.io.*;

import java.io.FileReader;
import java.io.IOException;



public class Task_1 {

    static public String TextOut = "";
    static int Obj = 0;
    static String ListObj = "";
    static int CountConst = 0;
    static int KeyAdd = 0;
    static String ListKeyAdd = "";

    public static void  ReadTxtFile(String fileName) { // статический метод для чтения файла
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

    static public void NumObj(String TEXT){
        //String pattern = "(\\s*)(\\w*)\\s(\\w*)\\s=\\snew\\s(\\w*)\\W{3}"; //патерн для поиска создания обьекта "int ff = new int();"
        //String patternArr = "(\\s*)(\\w*)\\[]\\s(\\w*)\\s=\\snew\\s(\\w*)\\[(\\d*)];"; //патерн для поиска "int[] ff = new int[4];"
        String patternDefArr = "(\\s*)(\\w*)(\\s*)(\\w*)\\[]\\s(\\w*)(.*);\r"; //патерн для поиска "int[] ff"
        String patternDef = "(\\s*)(\\w*)(\\s*)(\\w{1,50})\\s(\\w{1,50});\r"; //патерн для поиска "int ff;"
        String patternDefPlush = "(\\s*)(\\w*)(\\s*)(\\w{1,50})\\s(\\w*)\\s=\\s(.*);\r"; //патерн для поиска "int ff = ;"
        String patternKeyAdd = "(\\s*)(\\w*)(\\s*)(\\w*)\\s=\\sin.next(\\w*)\\(\\);\r";
        String[] lines = TEXT.split("\\n");

        for(int i = 0; i < lines.length; i++){
            String Buf = "";

            if(lines[i].matches(patternDefPlush) || lines[i].matches(patternDefArr) || lines[i].matches(patternDef)){
                Obj++;
                String[] Objs = lines[i].split(" "); //делю строку что бы достать навзвание класса
                 for(int x = 0; x < Objs.length; x++){
                     if(Objs[x].compareTo("const") == 0) CountConst++;
                     if(!(Objs[x].compareTo("") == 0)){ //Вот здесь видно что джава - говно (имхо)
                         ListObj += Objs[x] + " ";
                         break;
                     }
                 }
            }
            if(lines[i].matches(patternKeyAdd)){
                String[] OBJ = lines[i].split(" ");
                    for(int x = 0; x < OBJ.length; x++){
                        if(!(OBJ[x].compareTo("") == 0 || OBJ[x].compareTo(" ") == 0)){
                           // ListKeyAdd += OBJ[x] + "+";
                            //System.out.println(OBJ[x]);
                           // Buf += OBJ[x] + " "; //<комент из 69-ой> (тут у меня сгорела жопа, как и в 69-ой)
                              Buf += OBJ[x];
                        }
                    }
                ListKeyAdd += Buf + "\n";
                KeyAdd++;
            }
        }
    }
}

