package com.javarush.task.task03.task0308;

/* 
Произведение 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        int j = 1;
        for (int i = 1; i <= 10; i++){
            j = j*i;
        }
        System.out.println(j);
    }
}
