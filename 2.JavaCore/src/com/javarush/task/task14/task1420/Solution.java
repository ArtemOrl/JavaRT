package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {


    public static class FuckArgumentException extends Exception {
        private int a;
        private int b;

        public FuckArgumentException(int a, int b) {
            this.a = a;
            this.b = b;
            System.out.println("Числа не положительные целые.");
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer a = Integer.parseInt(reader.readLine());
        Integer b = Integer.parseInt(reader.readLine());

        if (a>0&& b>0) nod(a,b);
        else {
            throw new FuckArgumentException(a, b);
        }
    }
    //or a!=0&&b!+0
    public static void nod (Integer a, Integer b){
        while (a>0&&b>0){
            if (a>b){
                a%=b;

            }else {
                b%=a;

            }
        }
        System.out.println(a+b);
    }
}
