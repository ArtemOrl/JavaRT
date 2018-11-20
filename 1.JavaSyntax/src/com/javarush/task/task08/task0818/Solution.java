package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;
import  java.util.Iterator;
/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("fa", 300);
        map.put("fb", 400);
        map.put("fc", 500);
        map.put("ff", 600);
        map.put("fd", 200);
        map.put("fe", 120);
        map.put("fs", 800);
        map.put("fg", 2400);
        map.put("fh", 2300);
        map.put("fi", 7200);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код

//        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
//
//        while (iterator.hasNext())
//        {
//            //получение «пары» элементов
//            Map.Entry<String, Integer> pair = iterator.next();
//            String key = pair.getKey();            //ключ
//            int value = pair.getValue();        //значение
//            System.out.println(key + ":" + value);
//            if (value<500) map.remove(pair.getKey());
//        }
        Map<String, Integer> copy = new HashMap<>(map);
        for (Map.Entry<String, Integer> z : copy.entrySet()) {
            Integer s = z.getValue();
            System.out.println(s);
            if (z.getValue()<500) map.remove(z.getKey());

        }
    }

    public static void main(String[] args) {
//        HashMap<String, Integer> z = createMap();
//        System.out.println(z);
//        removeItemFromMap(z);
//        System.out.println(z);

    }
}