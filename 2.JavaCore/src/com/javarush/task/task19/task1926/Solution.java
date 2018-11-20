package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IndexOutOfBoundsException, IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file = rd.readLine();
        rd.close();

        BufferedReader  fileReader = new BufferedReader(new FileReader(file));
        while (fileReader.ready()){
            String s = fileReader.readLine();
//            String[] tags = s.split("(?=\\D)|(?=\\d)");
            s = new StringBuffer(s).reverse().toString();
            System.out.println(s);
        }
        fileReader.close();
    }
}
