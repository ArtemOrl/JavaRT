package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        //создали массив в обертке Integer
        Integer[] j = new Integer[20];
        //вставили в него данные исходного массива
        for (int i = 0; i < array.length; i++) {
            j[i] = array[i];

        }
        //создали ArrayList и вставили в него данные из промежуточного массива и отсортировали
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(j));
        Collections.sort(arr, Collections.reverseOrder());

        //передали данные промежуточному массиву
        arr.toArray(j);
        //изменили данные в основном массиве
        for (int i = 0; i < array.length; i++) {
            array[i] = j[i];

        }
    }
}
