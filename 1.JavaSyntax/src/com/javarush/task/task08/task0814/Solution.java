package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        int a = 0;
        int b = 100;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; ) {
            Integer random_number = a + (int) (Math.random() * b);
            if (!(set.contains(random_number))) {
                set.add(random_number);
                i++;
            }
        }

        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        Iterator<Integer> iterator = set.iterator();

        while(iterator.hasNext())
        {

            int num = iterator.next();
            if(num > 10)
            {
                iterator.remove();
            }



        }

        return set;
    }

    public static void main(String[] args) {
//        HashSet<Integer> set1 = new HashSet<>();
//        set1 = createSet();
//        System.out.println(set1);
//        System.out.println(removeAllNumbersMoreThan10(set1));
    }
}
