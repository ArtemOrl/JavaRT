package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        while (file.available()>0)
        {
            int data = file.read();
            list.add(data);

        }
        file.close();
        int zapiatii = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)==44) zapiatii++;//код зяпятой 44
        }
        System.out.println(zapiatii);
    }
}
