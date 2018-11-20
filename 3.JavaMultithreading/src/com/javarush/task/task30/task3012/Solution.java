package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        String s = number + " =";
        StringBuilder sb = new StringBuilder();

        for (int i = 6561; i >= 1; i/=3) {
            if (number>0 && number>i) {
                if (number > i*3/2) {sb.insert(0, " + " + i * 3); number -= i * 3;}
                else {sb.insert(0, " + " + i); number -= i;}
                continue;
            }
            if (number<0 && number<-i) {
                if (number < -i*3/2) {sb.insert(0, " - " + i * 3); number += i * 3;}
                else {sb.insert(0, " - " + i); number += i;}
                continue;
            }
            if(number == 0) break;
        }

        if (number == 1) sb.insert(0, " + 1");
        else if (number == -1) sb.insert(0, " - 1");

        System.out.println(s+sb);
    }
}