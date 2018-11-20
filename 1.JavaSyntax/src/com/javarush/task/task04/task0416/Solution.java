package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sMinute = reader.readLine();
        Double minute  = Double.parseDouble(sMinute);


        if ( minute % 5 < 3 ){
            System.out.println("зелёный");
        } else if(minute % 5 >= 3 &&  minute % 5 < 4) {
            System.out.println("жёлтый");
        } else {
            System.out.println("красный");
        }
    }
}