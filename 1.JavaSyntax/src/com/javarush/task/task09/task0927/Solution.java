package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String, Cat> map = new HashMap<>();
        map.put("Barsik1", new Cat("Barsik1"));
        map.put("Barsik2", new Cat("Barsik2"));
        map.put("Barsik3", new Cat("Barsik3"));
        map.put("Barsik4", new Cat("Barsik4"));
        map.put("Barsik5", new Cat("Barsik5"));
        map.put("Barsik6", new Cat("Barsik6"));
        map.put("Barsik7", new Cat("Barsik7"));
        map.put("Barsik8", new Cat("Barsik8"));
        map.put("Barsik9", new Cat("Barsik9"));
        map.put("Barsik10", new Cat("Barsik10"));
        return map;

    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> set = new HashSet<>();
        for (Map.Entry<String, Cat> pair : map.entrySet())
        {

            Cat value = pair.getValue();                  //значение
//            System.out.println(key + ":" + value);
            set.add(value);
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
