package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String number1 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String number2 = bufferedReader.readLine(); //читаем строку с клавиатуры
        String number3 = bufferedReader.readLine(); //читаем строку с клавиатуры

        int intNumber1 = Integer.parseInt(number1);
        int intNumber2 = Integer.parseInt(number2);
        int intNumber3 = Integer.parseInt(number3);

        int s[]= {intNumber1, intNumber2, intNumber3};
        Arrays.sort(s);
        if ((s[0]==s[1])||(s[1]==s[2])||(((s[0]==s[1])&&(s[1]==s[2])))){
            System.out.println(s[0]);
        }else {
            System.out.println(s[1]);
        }
    }
}
