package com.javarush.task.task04.task0409;

/* 
Ближайшее к 10
*/

public class Solution {
    public static void main(String[] args) {
        closeToTen(8, 11);
        closeToTen(14, 7);
    }

    public static void closeToTen(int a, int b) {
        //напишите тут ваш код
//        int c = abs(10-a);
//        int d = abs(10-b);
//        if((c<d)||(c==d)){
//            System.out.println("Ближайшее к 10 " + c);
//        }else{
//            System.out.println("Ближайшее к 10 " + d);
//        }
        int c;
        c = abs(10 - a) < abs(10 - b) ? a : b;
        System.out.println(c);
    }

    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}