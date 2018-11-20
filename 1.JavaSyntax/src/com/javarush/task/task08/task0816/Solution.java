package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stallone1", new Date("JUNE 2 1980"));
        map.put("Stallone2", new Date("JUNE 3 1980"));
        map.put("Stallone3", new Date("JUNE 4 1980"));
        map.put("Stallone4", new Date("JUNE 5 1980"));
        map.put("Stallone5", new Date("JUNE 6 1980"));
        map.put("Stallone6", new Date("MAY 1 1980"));
        map.put("Stallone7", new Date("JULY 1 1980"));
        map.put("Stallone8", new Date("MAY 1 1980"));
        map.put("Stallone9", new Date("MAY 1 1980"));


        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<HashMap.Entry<String, Date>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()) {
            HashMap.Entry<String, Date> pair = iterator.next();
            Date allDate = pair.getValue();
            int month = allDate.getMonth();
//            System.out.println(month);
            if (month > 4 && month < 8) {
                iterator.remove();
            }
        }
//        Iterator<Date> it1 = map.values().iterator();
//        while (it1.hasNext()){
//            int m = it1.next().getMonth();
//            if(m>4&&m<8)it1.remove();
//        }



    }

    public static void main(String[] args) {
//        HashMap<String, Date> map1 = createMap();
//        System.out.println(map1);
//        removeAllSummerPeople(map1);
//        System.out.println(map1);
    }
}
