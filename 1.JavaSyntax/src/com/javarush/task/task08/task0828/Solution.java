package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String s = reader.readLine();
//
//        Date d=new Date(s + " 1 1999");
//        System.out.println(s +" is " + (d.getMonth()+1) + " month");
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String s=reader.readLine();
        //Date date=new Date(s+" 1 1999");
        //int month = date.getMonth();
        //System.out.println(s +" is " + month + " month");

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("January", 1);
        map.put("February",2);
        map.put("March", 3);
        map.put("April",4);
        map.put("May", 5);
        map.put("June",6);
        map.put("July",7);
        map.put("August", 8);
        map.put("September", 9);
        map.put("October", 10);
        map.put("November", 11);
        map.put("December", 12);

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            //получение «пары» элементов
            Map.Entry<String, Integer> pair = iterator.next();
            String key = pair.getKey();            //ключ
            int value = pair.getValue();        //значение
            if(key.equals(s)) {System.out.println(key+" is " + value + " month");}
            //System.out.println(key + ":" + value);
        }

        //System.out.println("====="+s+"====");


    }
}
