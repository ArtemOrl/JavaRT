package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());




        int[] bytes = new int[255];

        byte b;
        while (file.available()>0) {
            b = (byte)file.read();
            bytes[b]++;
        }


        file.close();
        ArrayList<Byte> maxCounts = new ArrayList<>();
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] > 0) maxCounts.add((byte)bytes[i]);
        }
        Collections.sort(maxCounts);
        for (int i = 0; i < 1/*maxCounts.size()*/; i++) {
            int arg = maxCounts.get(i);
            for (int j = 0; j < bytes.length; j++) {
                int aByte = bytes[j];
                if (arg==aByte) System.out.print(j + " ");
            }

        }
    }
}
