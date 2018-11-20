package com.javarush.task.task09.task0905;

/* 
Там, в синих глубинах стек-трейса…
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int deep = getStackTraceDeep();
    }

    public static int getStackTraceDeep() {
        //напишите тут ваш код
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[2]);
        System.out.println(stackTraceElements.length);
        return  stackTraceElements.length;
// or
//        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
//        int count =0;
//        for (StackTraceElement element: stackTraceElement){
//            count++;
//        }
//        return count;
    }
}

