package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        int c = Integer.parseInt(a);
        int d = Integer.parseInt(b);
        if (c < d){
            System.out.println(c);
        }else if (d < c){
            System.out.println(d);
        }else{
            System.out.println(c + " "+ d);
        }
    }
}