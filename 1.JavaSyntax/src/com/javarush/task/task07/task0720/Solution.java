package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String arg = reader.readLine();
            list.add(arg);
        }

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (count!=M){
                String s = list.get(0);
                list.remove(0);
                list.add(s);
                count++;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
