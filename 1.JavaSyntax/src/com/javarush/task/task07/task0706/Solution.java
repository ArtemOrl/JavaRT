package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[15];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

//        int sumChet = 0;
//        for (int i = 0; i < arr.length; i+=2) {
//            sumChet += arr[i];
//        }
//
//        int sumNechet = 0;
//        for (int i = 1; i < arr.length; i+=2) {
//            sumNechet = arr[i];
//        }
//
//        if (sumChet>sumNechet) System.out.println("В домах с четными номерами проживает больше жителей.");
//        else System.out.println("В домах с нечетными номерами проживает больше жителей.");

        int chet=0;
        int nechet=0;
        for (int i=0; i<arr.length; i++)
        {
            if (i%2 == 0) chet = chet + arr[i];
            else nechet = nechet + arr[i];
        }
        if (chet>nechet) System.out.println("В домах с четными номерами проживает больше жителей.");
        else if (nechet>chet) System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
