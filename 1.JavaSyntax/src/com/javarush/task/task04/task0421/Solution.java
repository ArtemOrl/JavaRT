package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();

        char[] strToArray1 = name1.toCharArray();
        char[] strToArray2 = name2.toCharArray();
        int a = 0;
        if (strToArray1.length==strToArray2.length){
            for (int i = 0; i < strToArray1.length; i++) {
                if (strToArray1[i]==strToArray2[i]) {
                    a+=1;
                }

                }
//string1.compareTo(String2)
//            if(name1==name2){
//                System.out.println("Имена идентичны");
//            }else {
//                System.out.println("Длины имен равны");
//            }
            if (strToArray1.length==a){
                System.out.println("Имена идентичны");
            }else if (strToArray1.length!=a){
                System.out.println("Длины имен равны");
            }
            }


        }

    }

