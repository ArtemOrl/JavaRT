package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        Iterator<Cat> iterator = cats.iterator();
//        while (iterator.hasNext())
//        {
//            Cat text = iterator.next();
//                if (text.name.equals("Pizdec")) iterator.remove();
//        }
        int c = 0;
        while (iterator.hasNext())
        {
            Cat text = iterator.next();
            if (c==2) iterator.remove();
            c++;
        }
        //напишите тут ваш код. step 3 - пункт 3

        printCats(cats);
    }

    public static Set<Cat> createCats() {

        Set<Cat> cats = new HashSet<>();
//        Cat z1 = new Cat("Jopa");
//        Cat z2 = new Cat("Suka");
//        Cat z3 = new Cat("Pizdec");
        Cat z1 = new Cat();
        Cat z2 = new Cat();
        Cat z3 = new Cat();

        cats.add(z1);
        cats.add(z2);
        cats.add(z3);
        //напишите тут ваш код. step 2 - пункт 2
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        for (Cat cat : cats) {
            System.out.println(cat);
        }
    }

    public static class Cat{
        public Cat() {
        }
        //        String name;
//
//        public Cat(String name) {
//            this.name = name;
//        }
    }
    // step 1 - пункт 1
}
