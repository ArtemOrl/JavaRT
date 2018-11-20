package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];

        List<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()){
            String line = reader.readLine();
            String[] l = line.split(" ");
            list.add(l[0]);
            list.add(l[1]);
        }
        reader.close();

        double zp;
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i+=2) {
            String arg = list.get(i);
            zp = Double.parseDouble(list.get(i+1));
            for (int j = i+2 ; j < list.size(); j+=2) {
                String arg1 = list.get(j);
                double zp1 = Double.parseDouble(list.get(j+1));
                if (arg.equals(arg1)){
                    zp+=zp1;
                }
            }
            if (!(list1.contains(arg))){
                list1.add(arg);
                list1.add(Double.toString(zp));
            }
        }

        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i+=2) {
            list2.add(list1.get(i) + " " + list1.get(i+1));
        }

        Collections.sort(list2);
//        for (int i = 0; i < list1.size(); i+=2) {
//            System.out.print(list1.get(i) + " " + list1.get(i+1));
//
//            System.out.println();
//        }
        for (String s : list2) {
            System.out.println(s);

        }
    }
}
