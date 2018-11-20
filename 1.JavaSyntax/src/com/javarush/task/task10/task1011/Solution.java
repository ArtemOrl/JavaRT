package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        char[] arr = s.toCharArray();
        ArrayList<String> arrayList = new ArrayList<>();
        for (char c : arr) {
            String x = Character.toString(c);
            arrayList.add(x);
        }
        for (int j = 0; j < 40; j++) {
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.print(arrayList.get(i));
            }
            System.out.println();
            arrayList.remove(0);
        }

    }

}

