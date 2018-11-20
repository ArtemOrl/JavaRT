package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

//        String number1 = bufferedReader.readLine(); //читаем строку с клавиатуры
//        String number2 = bufferedReader.readLine(); //читаем строку с клавиатуры
//        String number3 = bufferedReader.readLine(); //читаем строку с клавиатуры
//
//        int intNumber1 = Integer.parseInt(number1);
//        int intNumber2 = Integer.parseInt(number2);
//        int intNumber3 = Integer.parseInt(number3);


        int sum = 0;
        while (true){
            String s = bufferedReader.readLine();

            int num = Integer.parseInt(s);
            sum = sum + num;
            if (s.equals("-1")){

                //sum = sum + num;
                break;
            }
        }
        System.out.println(sum);
    }
}
