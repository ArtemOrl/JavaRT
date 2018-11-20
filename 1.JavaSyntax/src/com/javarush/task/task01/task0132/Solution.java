package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        String s = Integer.toString(number);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res + Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return res;
    }
}