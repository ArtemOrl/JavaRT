package com.javarush.task.task31.task3101;

public class Test2 {
    public static void main(String[] args) {

        int i1 = 5;

        Integer i2 = new Integer(5);

        if (i1 == i2) {

            System.out.println("i1==i2");

        }



        String s1 = "hello world from " + 2016;

        String s2 = "hello world from 2016";

        if (s1 == s2) {

            System.out.println("s1==s2");

        }

    }
}
