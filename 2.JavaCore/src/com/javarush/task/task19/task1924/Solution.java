package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }
    public static void main(String[] args) throws IOException {

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file = rd.readLine();
        rd.close();

        ArrayList<String> list = new ArrayList<>();
        String lineR = "";

        BufferedReader  fileReader = new BufferedReader(new FileReader(file));
        while (fileReader.ready()){
            String s = fileReader.readLine();
            String[] line = s.split(" ");
            lineR = "";
            for (Map.Entry<Integer, String> pair : map.entrySet()){
                int cifer = pair.getKey();
                for (int i = 0; i < line.length; i++) {
                    String s1 = line[i];
                    try{
                        int s2 = Integer.parseInt(s1);
                        if (cifer==s2) line[i] = pair.getValue();
                    } catch (Exception e){}
                }
            }
            for (int i = 0; i < line.length; i++) {
                lineR += line[i];
                if (i!=line.length-1) lineR += " ";
            }
            list.add(lineR);
        }
        fileReader.close();
        for (String s : list) {
            System.out.println(s);
        }
    }
}
