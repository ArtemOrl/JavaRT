package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
//        StringBuilder result = new StringBuilder();
//        int temp = a;
//        if (a==b) return result.append(a).toString();
//        else {
//            if (a > b){
//                for (int i = temp; i >= b; i--) {
//                    result.append(" " + i);
//                }
//            }
//            if (a < b) {
//                for (int i = temp; i <= b; i++) {
//                    result.append(" " + i);
//                }
//
//            }
//        }
//        return result.toString();

        StringBuilder result = new StringBuilder();
        result.append(a);
        int temp = a;
        if (a == b) {
            return Integer.toString(a);
        } else {
            if (a > b) {
                while (temp > b) {
                    result.append(" ").append(--temp);
                }
            } else {

                while (temp < b) {
                    result.append(" ").append(++temp);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}