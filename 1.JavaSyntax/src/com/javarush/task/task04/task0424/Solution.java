package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();

        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);

        if ((a==b)||(a==c)||(b==c)){
            if (a==b){
                System.out.println(3);
            }else if (a==c){
                System.out.println(2);
            }else if (b==c){
                System.out.println(1);
            }
        }
    }
}
