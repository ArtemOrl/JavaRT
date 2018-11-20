package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(convertEurToUsd(1000, 1.01));
        System.out.println(convertEurToUsd(1001, 1.02));
    }

    public static double convertEurToUsd(int eur, double course) {
        //напишите тут ваш код
        double usd = eur * course;

        return usd;
    }
}
