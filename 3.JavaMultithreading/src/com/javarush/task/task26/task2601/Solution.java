package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        Integer[] arr = {13, 8, 15, 5, 17};
//        Integer[] arr = {13, 8, 15, 5};
        Integer[] arr = {25, 8, 15, 5, 17, 13};

//        Integer[] result = sort(arr);
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + " ");
//        }

//        System.out.println(Arrays.toString(sort(arr)));
    }

//    public static Integer[] sort(Integer[] array) {
//        List<Integer> list = new ArrayList<>();
//
//        float median = getMedianOfNumber(array);
////        System.out.println(median);
//        int as = (int) median;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i]==as){
//                int a0 = array[0];
//                array[0] = array[i];
//                array[i] = a0;
//            }
//
//        }
//        list.add(array[0]);
//
//
//
//        for (int i = 1; i < array.length; i++) {
//            int z = list.get(0);
//            int min = Integer.MAX_VALUE;
//            int tmp = 0;
//            for (int j = 1; j < array.length; j++) {
//                if (array[j]!=null && Math.abs(z-array[j])<min){
//                    min = Math.abs(z-array[j]);
//                    tmp = array[j];
//                }
////                System.out.println("min "+ min + " tmp " + tmp + "");
//            }
//            list.add(tmp);
//            for (int j = 1; j < array.length; j++) {
//                if (array[j]!= null && array[j]==tmp) array[j]=null;
//            }
////            System.out.println();
//        }
//        for (int i = 0; i < array.length; i++) {
//            array[i]=list.get(i);
//        }
//        return array;
//    }
//
//    public static float getMedianOfNumber(Integer[] arrayForFindingTheMedianOfNumber)  //метод для нахождения медианы чисел, параметром является массив
//    {
//        Arrays.sort(arrayForFindingTheMedianOfNumber);  //сортируем полученный массив по возрастанию
//        if (arrayForFindingTheMedianOfNumber.length % 2 == 0)  //если количество элементов в массиве чётное
//        {
//            //то возвращаем половину от суммы двух средних элементов массива
//            return ((arrayForFindingTheMedianOfNumber[arrayForFindingTheMedianOfNumber.length / 2] + arrayForFindingTheMedianOfNumber[arrayForFindingTheMedianOfNumber.length / 2 - 1]) / 2f)-1;
//        }
//
//        //если количество элементов нечётное, то возвращаем средний элемент массива
//        return arrayForFindingTheMedianOfNumber[arrayForFindingTheMedianOfNumber.length / 2];
//    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        final double median;
        if (array.length % 2 == 0)
            median = ((double)array[array.length/2-1]+(double)array[array.length/2])/2;
        else
            median = array[array.length/2];
        Comparator<Integer> compareByMedian = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                double value = Math.abs(o1-median) - Math.abs(o2-median);
                if (value == 0)
                    value = o1 - o2;
                return (int)value;
            }
        };
        Arrays.sort(array, compareByMedian);
//        System.out.println(median);
        return array;
    }
}
