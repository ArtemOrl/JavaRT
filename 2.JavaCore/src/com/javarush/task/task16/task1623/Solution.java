package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread{
//        Thread thread = new GenerateThread();


        @Override
        public String toString() {
            return this.getName() + " created";
        }
        public GenerateThread() {
            super(String.valueOf(++countCreatedThreads));
            start();
        }
        public void run() {
//            while (countCreatedThreads < count)
            if (countCreatedThreads < count){
                System.out.println(new GenerateThread());
            }
        }

    }
}
