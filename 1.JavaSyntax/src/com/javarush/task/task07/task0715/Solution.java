package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, "мама", "мыла", "раму");

        //System.out.println(strings);
        for (int i = 0; i < strings.size(); ) {
            String arg = "именно";
            int j = i + 1;
            strings.add(j, arg);
            i+=2;
        }
        //System.out.println(strings);

        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }

    }
}
