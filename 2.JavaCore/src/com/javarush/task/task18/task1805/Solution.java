package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        while (file.available()>0)
        {
            int data = file.read();
            list.add(data);

        }
        file.close();

        //В set невозможны повторы элементов
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            Integer arg = list.get(i);
            set.add(arg);
        }

        list.clear();
        for (Integer integer : set) {
            list.add(integer);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");

        }

    }
}
