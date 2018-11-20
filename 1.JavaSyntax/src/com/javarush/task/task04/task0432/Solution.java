package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String text = bufferedReader.readLine(); //читаем строку с клавиатуры
        String number = bufferedReader.readLine(); //читаем строку с клавиатуры


        int N = Integer.parseInt(number);
        int i = 0;
        while (i!=N){
            System.out.println(text);
            i++;
        }

    }
}
