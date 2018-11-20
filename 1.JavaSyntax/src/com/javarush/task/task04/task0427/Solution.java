package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String number = bufferedReader.readLine(); //читаем строку с клавиатуры

        int intNumber = Integer.parseInt(number);

        char[] strToArray = number.toCharArray();

        if ((number.length()<4)&&(number.length()>0)){
            if ((number.length()==1)&&(intNumber%2==0)&&(intNumber>0)){
                System.out.println("четное однозначное число");
            }else if ((number.length()==1)&&(intNumber%2!=0)&&(intNumber>0)){
                System.out.println("нечетное однозначное число");
            }else if ((number.length()==2)&&(intNumber%2==0)&&(intNumber>0)){
                System.out.println("четное двузначное число");
            }else if ((number.length()==2)&&(intNumber%2!=0)&&(intNumber>0)){
                System.out.println("нечетное двузначное число");
            }else if ((number.length()==3)&&(intNumber%2==0)&&(intNumber>0)){
                System.out.println("четное трехзначное число");
            }else if ((number.length()==3)&&(intNumber%2!=0)&&(intNumber>0)){
                System.out.println("нечетное трехзначное число");
            }
        }

    }
    public static boolean ChotORNot (int x){
        return (x % 2 == 0);
    }
    public static boolean PlusORNot (int x) {
        return (x > 0);
    }
}

