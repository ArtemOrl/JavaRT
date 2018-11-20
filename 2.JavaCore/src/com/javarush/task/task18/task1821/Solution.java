package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        FileInputStream file = new FileInputStream(reader.readLine());

//        FileInputStream file = new FileInputStream(args[0]);
//
//
//        int[] bytes = new int[255];
//
//        byte b;
//        while (file.available()>0) {
//            b = (byte)file.read();
//            bytes[b]++;//индекс не может быть минусовым
//        }
//
//        file.close();
//
//        byte[] byt = new byte[1];
//        for (int i = 0; i < bytes.length; i++) {
//            byt[0] = (byte) i;
////            System.out.println(byt[0]);
//            String elem = new String(byt);
//            if (bytes[i]!=0){
//                System.out.println(elem + " " + bytes[i]);
//            }
//        }
        //что делать с русскими буквами не выяснил, т.к. пребразует в String только byte, а он до 128,
        //а русские буквы от 129 до 256!!!(((


        //это русские буквы выводит по китайски сука
        FileInputStream inputStream = new FileInputStream(new File(args[0]));
//        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
//        FileInputStream inputStream = new FileInputStream(new File(rd.readLine()));

        byte[] symbols = new byte[inputStream.available()];
        inputStream.read(symbols);
        Arrays.sort(symbols);

        for (int i = 0; i < symbols.length; i++) {
            System.out.println(symbols[i]);

        }

        HashMap<Byte, Integer> map = new HashMap<Byte, Integer>();

        int count;


        for (byte x : symbols) {
            count = 0;

            for (byte x1 : symbols) {
                if (x == x1) {
                    count++;
                }
            }

            if (!map.containsKey(x)) {
                map.put(x, count);
                System.out.println((char) x + " " + count);
            }


        }


        inputStream.close();
    }
}
