package com.javarush.task.task07.task0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/* 
Вывести числа в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int arg = Integer.parseInt(reader.readLine());
            list.add(arg);
        }
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
    }
}
