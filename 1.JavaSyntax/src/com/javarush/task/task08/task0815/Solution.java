package com.javarush.task.task08.task0815;

import java.util.*;
import java.util.HashMap;
import java.util.Iterator;
/* 
Перепись населения
*/

public class Solution {
//    public static HashMap<String, String> createMap() {
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("Сидоров", "Сидор");
//        map.put("Федоров", "Сидор");
//        map.put("Николаев", "Коляба");
//        map.put("Егоров", "Баха");
//        map.put("Светка", "Чветка");
//        map.put("Костин", "Костямба");
//        map.put("Киров", "Петруччо");
//        map.put("Стоянова", "Сидор");
//        map.put("Петров", "Петруччо");
//        map.put("Оля", "Коля");
//        return map;
//    }
//
//    public static int getCountTheSameFirstName(HashMap<String, String> map, String[] name) {
//        HashMap<String, String> map1 = createMap();
//        ArrayList<String> listOfValues = new ArrayList<>();
//        for (int i = 0; i < name.length; i++) {
//            String s = name[i];
//            listOfValues.add(s);
//
//        }
//        for (int i = 0; i < listOfValues.size(); i++) {
//            System.out.println(listOfValues.get(i));
//
//        }
//        ArrayList<Integer> listOfEqualities = new ArrayList<>();
//
//        for (int i = 0; i < listOfValues.size(); i++) {
//             String s = listOfValues.get(i);
////             int j = i + 1;
////
////             if (j==listOfValues.size()){
////                 break;
////             }
////             String z = listOfValues.get(j);
//            int ksum = 0;
//            for (int j = i+1; j < listOfValues.size(); j++) {
//                String z = listOfValues.get(j);
//
//                if (s.equals(z)){
//                    ksum += 1;
//                    int x = 1;
//                    listOfEqualities.add(x);
//                    listOfValues.remove(j);
////                    if ((j==listOfValues.size())&&(ksum==1)) listOfEqualities.add(x);
//                }
//            }
//            if (ksum==1) listOfEqualities.add(1);
//        }
//        for (int i = 0; i < listOfEqualities.size(); i++) {
//            System.out.println(listOfEqualities.get(i));
//
//        }
//        int sum = 0;
//        for (int i = 0; i < listOfEqualities.size(); i++) {
//             int x = listOfEqualities.get(i);
//             sum+=x;
//
//        }
//        return sum;
//
//
//    }
//
//    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
//        HashMap<String, String> mapzzzz = new HashMap<String, String>(map);
//        ArrayList<String> listOfKeys = new ArrayList<>();
//        for (String key : mapzzzz.keySet()){
//            listOfKeys.add(key);
//        }
//        ArrayList<Integer> listOfEqualities = new ArrayList<>();
//
//        for (int i = 0; i < listOfKeys.size(); i++) {
//            String s = listOfKeys.get(i);
//            int j = i + 1;
//
//            if (j==listOfKeys.size()){
//                break;
//            }
//            String z = listOfKeys.get(j);
//            if (s==z){
//                listOfEqualities.add(1);
//            }
//        }
//        int sum = 0;
//        for (int i = 0; i < listOfEqualities.size(); i++) {
//            int x = listOfEqualities.get(i);
//            sum+=x;
//
//        }
//        return sum;
//
//    }
//
//    public static void main(String[] args) {
//        HashMap<String, String> map = createMap();
//        System.out.println(map);
//        String[] names = new String[10];
//        int i = 0;
//        for (Map.Entry<String, String> s : map.entrySet()){
//            String value = s.getValue();
//            names[i] = value;
//            i++;
//        }
//
//
////        for (String name : names) {
////            System.out.println(name);
////        }
//
//
//
//        System.out.println(getCountTheSameFirstName(map, names));
//    }


/* Одинаковые имя и фамилия
  Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
  Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/


        public static void main(String[] args)
        {
//            Iterator<HashMap.Entry<String, String>> iterator = createMap().entrySet().iterator();
//            while(iterator.hasNext()){
//                HashMap.Entry<String, String> pair = iterator.next();
//                String value = pair.getValue();
//                String key = pair.getKey();
//                System.out.println(key + ":" +value);
//            }
//            int resultName = getCountTheSameFirstName(createMap(), "Alexov");
//            System.out.println(resultName+ " - resultName");
//
//            int resultLastName = getCountTheSameLastName(createMap(), "f3");
//            System.out.println(resultLastName+ " - resultLastName");
        }
        public static HashMap<String, String> createMap()
        {
            //напишите тут ваш код
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("f1", "Pupkin");
            map.put("f2", "Vasilov");
            map.put("f3", "Smith");
            map.put("f4", "Ericman");
            map.put("f5", "Stellov");
            map.put("f6", "Testerov");
            map.put("f7", "Pushkin");
            map.put("f8", "Alexov");
            map.put("f9", "Alexov");
            map.put("f10", "Alexov");
            return map;
        }

        public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
        {
            //напишите тут ваш код
            Iterator<HashMap.Entry<String, String>> iterator = map.entrySet().iterator();
            int count=0;
            while(iterator.hasNext()){
                HashMap.Entry<String, String> pair= iterator.next();
                String itName = pair.getValue();
                if (itName.equals(name)){
                    count++;
                }
            }
            return count;

        }

        public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
        {
            //напишите тут ваш код
            int count = 0;
            Iterator<HashMap.Entry<String, String>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                HashMap.Entry<String, String> pair = iterator.next();
                String key = pair.getKey();
                if(key.equals(familiya)){
                    count++;
                }
            }
            return  count;

        }
    }


