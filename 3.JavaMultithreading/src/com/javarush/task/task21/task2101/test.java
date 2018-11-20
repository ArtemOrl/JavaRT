package com.javarush.task.task21.task2101;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
//    public static String intToBinary(int n)
//    {
//        String s = "";
//        while (n > 0)
//        {
//            s =  ( (n % 2 ) == 0 ? "0" : "1") +s;
//            n = n / 2;
//        }
//        return s;
//    }
//    public static void main(String[] args) {
//        System.out.println(intToBinary(1));
//    }


    public static void main(String[] args) {

        ArrayList<Integer> powers = new ArrayList<Integer>();
        ArrayList<Integer> binaryStore = new ArrayList<Integer>();

        powers.add(128);
        powers.add(64);
        powers.add(32);
        powers.add(16);
        powers.add(8);
        powers.add(4);
        powers.add(2);
        powers.add(1);

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Paden9000 binary converter. Please enter an integer you wish to convert: ");
        int input = sc.nextInt();
        int printableInput = input;

        for (int i : powers) {
            if (input < i) {
                binaryStore.add(0);
            } else {
                input = input - i;
                binaryStore.add(1);
            }
        }

        String newString= binaryStore.toString();
        String finalOutput = newString.replace("[", "")
                .replace(" ", "")
                .replace("]", "")
                .replace(",", "");

        System.out.println("Integer value: " + printableInput + "\nBinary value: " + finalOutput);
        sc.close();
    }
}
