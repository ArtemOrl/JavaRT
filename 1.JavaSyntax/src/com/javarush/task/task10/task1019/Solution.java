package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



//        System.out.println("Id=" + id + " Name=" + name);
        HashMap<String, Integer> map = new HashMap<>();
        while (true){
            String zz = reader.readLine();
            if (zz.equals("")) break;
            int id = Integer.parseInt(zz);
            String name = reader.readLine();
            map.put(name, id);

        }
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            String index = pair.getKey();
            Integer name = pair.getValue();

            System.out.println(name + " " + index);
//            System.out.println(index);
        }
    }
}
