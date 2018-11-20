package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String a = bufferedReader.readLine();
        String b = bufferedReader.readLine();
        String c = bufferedReader.readLine();

        if (a==b){
            System.out.println(a + " " + b);
        }else if (a==c){
            System.out.println(a + " " + c);
        }else if (b==c){
            System.out.println(b + " " + c);
        }else if ((a==b)&&(a==c)){
            System.out.println(a + " " + b + " " + c);
        }

    }
}