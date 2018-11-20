package com.javarush.task.task09.task0901;

/* 
Возвращаем StackTrace
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();


    }

    public static StackTraceElement[] method1() {
        method2();

//        String x;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        for (StackTraceElement stackTraceElement : stackTraceElements) {
//            System.out.println(stackTraceElement.getMethodName());
//            x = stackTraceElement.getMethodName();
//        }
        return stackTraceElements;
    }

    public static StackTraceElement[] method2() {
        method3();

//        String x;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        for (StackTraceElement stackTraceElement : stackTraceElements) {
//            System.out.println(stackTraceElement.getMethodName());
//            x = stackTraceElement.getMethodName();
//        }
        return stackTraceElements;
    }

    public static StackTraceElement[] method3() {
        method4();

//        String x;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        for (StackTraceElement stackTraceElement : stackTraceElements) {
//            System.out.println(stackTraceElement.getMethodName());
//            x = stackTraceElement.getMethodName();
//        }
        return stackTraceElements;
    }
    public static StackTraceElement[] method4() {
        method5();

//        String x;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        for (StackTraceElement stackTraceElement : stackTraceElements) {
//            System.out.println(stackTraceElement.getMethodName());
//            x = stackTraceElement.getMethodName();
//        }
        return stackTraceElements;
    }

    public static StackTraceElement[] method5() {
//        String x;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        for (StackTraceElement stackTraceElement : stackTraceElements) {
//            System.out.println(stackTraceElement.getMethodName());
//            x = stackTraceElement.getMethodName();
//        }
        return stackTraceElements;
    }
}
