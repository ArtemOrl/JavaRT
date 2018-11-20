package com.javarush.task.task03.task0304;

/* 
Задача на проценты
*/

public class Solution {
    public static double addTenPercent(int i) {
        double z = i *1.10;
        return z;
    }

    public static void main(String[] args) {
        System.out.println(addTenPercent(9));
    }
}
