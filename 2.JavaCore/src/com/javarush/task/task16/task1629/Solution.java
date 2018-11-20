package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        t1.start();
        Read3Strings t2 = new Read3Strings();

        t2.start();
        //add your code here - добавьте код тут
        t1.join();
        t2.join();
        t1.printResult();

        t2.printResult();
    }

    //add your code here - добавьте код тут

    public static class Read3Strings extends Thread{
        private String result = "";

        @Override
        public void run() {
            try{
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            String line3 = reader.readLine();
            result = line1 + " " + line2 + " " + line3;}
            catch (IOException e){}
        }

        public void printResult(){
            System.out.println(result);
        }
    }
}
