package com.company;

public class Task_3 {

    String pattrenNumInt = "(\\D*)(\\d*)";
    String pattrenNumDobule = "(\\D*)(\\d*).(\\d*)";

    public Task_3(){

    }

    public String NumInt(String Number){

        if(Number.matches(pattrenNumInt)){
            return "Число целое";
        }
        else if (Number.matches(pattrenNumDobule)){
            return "Дробное число";
        }
        else return "troble";
    }

    public byte NumIntOrNo(String Number){ //Более правильный вариант функции
        if(Number.matches(pattrenNumInt)) return 1;
        else if(Number.matches(pattrenNumDobule)) return 0;
        else return -1;
    }

    public String NewString(String Nums){
        String NewNums = "";
        String[] ArrNums = Nums.split(" ");

        for(int i = 0; i < ArrNums.length; ++i){
            if(NumIntOrNo(ArrNums[i]) == 1){
                try {
                    int buff = Integer.parseInt(ArrNums[i]);
                    NewNums += buff * buff + " ";
                }
                catch (Exception e){
                    return "Хьюстон, у нас проблемы";
                }
            }
            else if(NumIntOrNo(ArrNums[i]) == 0){
                try{
                double buff = Double.parseDouble(ArrNums[i]);
                NewNums += (int)(buff) + " ";
                }
                catch (Exception e){
                    return "У нас проблемы, капитан";
                }
            }
            else if(NumIntOrNo(ArrNums[i]) == -1) return "troble";
        }
        return NewNums;
    }
}
