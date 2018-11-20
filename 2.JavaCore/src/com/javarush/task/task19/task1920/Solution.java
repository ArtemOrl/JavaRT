package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        String fileName = args[0];
//
//        List<String> list = new ArrayList<>();
//        BufferedReader reader = new BufferedReader(new FileReader(fileName));
//        while (reader.ready()){
//            String line = reader.readLine();
//            String[] l = line.split(" ");
//            list.add(l[0]);
//            list.add(l[1]);
//        }
//        reader.close();
//
//        double zp;
//        List<String> list1 = new ArrayList<>();
//        List<Double> list2 = new ArrayList<>();
//        for (int i = 0; i < list.size(); i+=2) {
//            String arg = list.get(i);
//            zp = Double.parseDouble(list.get(i+1));
//            for (int j = i+2 ; j < list.size(); j+=2) {
//                String arg1 = list.get(j);
//                double zp1 = Double.parseDouble(list.get(j+1));
//                if (arg.equals(arg1)){
//                    zp+=zp1;
//                }
//            }
//            if (!(list1.contains(arg))){
//                list1.add(arg);
//                list1.add(Double.toString(zp));
//                list2.add(zp);
//            }
//        }
//
//        List<String> list3 = new ArrayList<>();
////        Collections.sort(list2, Collections.reverseOrder());
//        for (int i = 1; i < list1.size(); i+=2) {
//
//            if (Double.parseDouble(list1.get(i))==list2.get(0)){
////                System.out.println(list1.get(i-1));
//                list3.add(list1.get(i-1));
//            }
//
//        }
//        for (int i = 1; i < list1.size(); i+=2) {
//
//            if (Double.parseDouble(list1.get(i))==list2.get(1)){
//                list3.add(list1.get(i-1));
//            }
//
//        }
//
//        Collections.sort(list3);
//        for (String s : list3) {
//            System.out.println(s);
//        }

        TreeMap<String, Double> map = new TreeMap<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        double max = Double.MIN_VALUE;
        while (fileReader.ready()) {
            String s = fileReader.readLine();
            String[] strs = s.split("[\\s\\t\\n\\x0B\\f\\r]");
            String key = strs[0];
            double value = Double.parseDouble(strs[1]);
            if (map.containsKey(key)) {
                map.put(key, map.get(strs[0]) + value);
            } else
                map.put(key, value);
        }
        fileReader.close();

        //Max
        for (Double a : map.values())
            if (max < a)
                max = a;

        //show
        for (Map.Entry<String, Double> pair : map.entrySet())
            if (pair.getValue().equals(max))
                System.out.println(pair.getKey());

    }
}
