package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(r.readLine());
        }
        Arrays.sort(arr);//сортирует данные в массиве по возрастанию если они int
        for (int i = 2; i >= 0 ; i--) {
            System.out.print(arr[i]+" ");
        }
    }
}
