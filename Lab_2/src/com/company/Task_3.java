package com.company;

public class Task_3 {

    String pattrenNumInt = "-?\\d+";
    String pattrenNumDobule = "-?\\d+.\\d+";

    public byte NumIntOrNo(String Number){ //Более правильный вариант функции
        if(Number.matches(pattrenNumInt)) return 1;
        else if(Number.matches(pattrenNumDobule)) return 0;
        else return -1;
    }

    public String NewString(String Nums) throws RuntimeException{
        String[] ArrNums = Nums.split(" ");

        for (String arrNum : ArrNums) {
            if (NumIntOrNo(arrNum) == 1) {
                try {
                    int buff = Integer.parseInt(arrNum);
                    buff *= buff;
                    Nums = Nums.replace(arrNum, Integer.toString(buff));
                } catch (Exception e) {
                    throw new RuntimeException("Ошибка перевода числа");
                }
            } else if (NumIntOrNo(arrNum) == 0) {
                try {
                    double buff = Double.parseDouble(arrNum);
                    Nums = Nums.replace(arrNum, Integer.toString((int) (buff)));
                } catch (Exception e) {
                    throw new RuntimeException("Ошибка перевода числа");
                }
            } else if (NumIntOrNo(arrNum) == -1) {
                throw new RuntimeException("Ошибка ввода");
            }
            ;
        }
        return Nums;
    }
}

