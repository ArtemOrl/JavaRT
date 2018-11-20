package com.javarush.task.task15.task1518;

/* 
Статики и котики
*/

//public class Solution {
//    public static class Cat{public String name = "Пушок";}
//
//    static {
//        Cat cat = new Cat();
//        System.out.println(cat.name);
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
public class Solution {
    public static Cat cat;
    public static class Cat{
        public String name;

    }
    static {
        Solution.cat = new Cat();
        cat.name = "Max";
        System.out.println(cat.name);
    }
    public static void main(String[] args) {
    }
}