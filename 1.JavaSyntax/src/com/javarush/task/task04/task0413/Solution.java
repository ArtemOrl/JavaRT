package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


        String sAge = bufferedReader.readLine(); //читаем строку с клавиатуры
        int nAge = Integer.parseInt(sAge); //преобразовываем строку в число.

        if (nAge==1){
            System.out.println("понедельник");
        }else if (nAge==2){
            System.out.println("вторник");
        }else if (nAge==3){
            System.out.println("среда");
        }else if (nAge==4){
            System.out.println("четверг");
        }else if (nAge==5){
            System.out.println("пятница");
        }else if (nAge==6){
            System.out.println("суббота");
        }else if (nAge==7){
            System.out.println("воскресенье");
        }else {
            System.out.println("такого дня недели не существует");
        }
    }
}