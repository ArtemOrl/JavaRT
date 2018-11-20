package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String arg = reader.readLine();
            list.add(arg);
        }

        for (int i = 0; i < list.size(); i++) {
            String arg = list.get(i);
            int j = i + 1;
            String arg1 = list.get(j);
            if (arg.length()>arg1.length()){
                System.out.println(j);
                break;
            }
        }
    }
}

