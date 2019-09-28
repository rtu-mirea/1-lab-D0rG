package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Array {
    int N;
    short Arr[];
    Scanner in = new Scanner(System.in);

    public void Menu(){
        System.out.println("Какова длиннамассива?");
        N = in.nextInt();
        Arr = new short[N];
        System.out.println("Заполнить массив рандомно 1/0");
        int buf = in.nextInt();
        if(buf == 1) SetRandom();
        else if (buf == 0) SetByHand();
        System.out.println("Вывод массива:\n0-Слева направо\n1-Справа налево");
        buf = in.nextInt();
        if(buf == 1) OutRL();
        else if (buf == 0) OutLR();

        System.out.println();
        DelSeven();
    }

    public Array(int N){
     this.N = N;
     Arr = new short[N];
    }

    public void SetRandom(){
        for(int i = 0; i < N; ++i)
            Arr[i] = (short)(Math.random() * 32767);
    }

    public void SetByHand(){
        for(int i = 0; i < N; ++i){
            System.out.println("Введите эллемент № " + i);
            Arr[i] = in.nextShort();
        }
    }

    public void OutLR(){
        for(int i : Arr)
            System.out.println(i);

    }

    public void OutRL(){
        for(int i = N - 1; i >= 0; --i)
            System.out.println(Arr[i]);
    }

    public void MaxMinSwap(){
        short max = Arr[0], min = Arr[0];
        int maxI = 0, minI = 0;

        for(int i = 1; i < N; ++i){
            if(max < Arr[i]){
                max = Arr[i];
                maxI = i;
            }
        }

        for(int i = 1; i < N; ++i){
            if(min < Arr[i]){
                min = Arr[i];
                minI = i;
            }
        }

        Arr[maxI] = min;
        Arr[minI] = max;
    }

    public void DelSeven(){
        int CountArr = 0;
        short[] array;
        array = new short[CountArr];
        short[] BuffArr;

        for(int i = 0; i < N; ++i){
            short buffNum = Arr[i];
            if(buffNum < 0) buffNum *=(-1);
            while (buffNum > 0){
                if(buffNum % 10 == 7) {
                    BuffArr = new short[CountArr];

                    for(int z = 0; z < CountArr; ++z){
                        BuffArr[z] = array[z];
                    }

                    ++CountArr;
                    array = new short[CountArr];

                    for(int z = 0; z < CountArr - 1; ++z){
                        array[z] = BuffArr[z];
                    }

                    array[CountArr - 1] = buffNum;
                    break;
                }
                 else buffNum /= 10;
            }

        }
        short[] NewArr = new short[N - CountArr];
        int pos = 0;

        for(int i = 0; i < N; ++i){
            boolean BadNum = false;

            for(int z = 0; z < CountArr - 1; ++z){
                if(Arr[i] == array[z]) BadNum = true;
            }

            if(!BadNum && pos < N - CountArr){
                NewArr[pos] = Arr[i];
                ++pos;
            }
        }

        for(int i = 0; i < N - CountArr; ++i)
            System.out.println(NewArr[i]);
    }
}
