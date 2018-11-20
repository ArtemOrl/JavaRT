package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


        String sAge = bufferedReader.readLine(); //читаем строку с клавиатуры
        int nAge = Integer.parseInt(sAge); //преобразовываем строку в число.

        if ((nAge%4==0)&&(nAge%100==0)){

            if(nAge%400==0){
                System.out.println("количество дней в году: " + 366);
            }else {
                System.out.println("количество дней в году: " + 365);
            }
        }else if((nAge%4==0)&&(nAge%100!=0)){
            System.out.println("количество дней в году: " + 366);
        }else{
            System.out.println("количество дней в году: " + 365);
        }
    }
}