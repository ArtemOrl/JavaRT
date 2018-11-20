package com.javarush.task.task08.task0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }
//        Помощник
//        String[] array = {"q", "a", "x", "s", "w", "b", "c", "d", "o", "p"};
        sort(array);

        //System.out.println(isGreaterThan("A", "B"));
        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {


         /*Внешний цикл каждый раз сокращает фрагмент массива,
      так как внутренний цикл каждый раз ставит в конец
      фрагмента максимальный элемент*/
        for(int i = array.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
            /*Сравниваем элементы попарно,
              если они имеют неправильный порядок,
              то меняем местами*/
            String a = array[j];
            String b = array[j+1];
//            if( array[j] > array[j+1] ){
                if (isGreaterThan(a, b)){
                String tmp = array[j];
                array[j] = array[j+1];
                array[j+1] = tmp;
            }
        }
    }




//        String[] arr1 = new String[array.length];
//        ArrayList<String> arr = new ArrayList<>();
//        for (int i = 0; i < array.length; i++) {
//            arr.add(array[i]);
//
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            String a = array[i];
//            String x = null;
////            System.out.println("a = "+ a + " eto perviy element ishodnogo massiva");
////            System.out.println();
//            for (int j = 0; j < arr.size(); j++) {
//                String b = arr.get(j);
//
//                boolean changed = false;
//
////                System.out.println("b = " + b + "  pervoe prisvoenie ");
////                System.out.println();
//                System.out.println(!isGreaterThan(a, b) + "    proverka1");
////                System.out.println("b = "+ b + "  before");
//                if (a!=b){
//                    if (!isGreaterThan(a, b)==false){
////                        System.out.println(b + " posle");
//                        a = b;
//                        array[i] = a;
////                        System.out.println("a = " + a + " here");
////                        System.out.println("array[i] = " + array[i]);
////                        System.out.println();
//
//                    }
//                }
//
//
////                System.out.println(x);
////                System.out.println();
//            }
//            System.out.println("ak = " + a + " konec");
//            System.out.println("array[i] = " + array[i]);
//            for (int k = 0; k < arr.size(); k++) {
//                if (arr.get(k)==a) arr.remove(k);
//
//            }
//            for (int k = 0; k < arr.size(); k++) {
//                System.out.print(k + " ");
//
//            }
            //System.out.println(array[i]);
//            for (int j = 0; j < arr.size(); j++){
//                if (arr1[i]==arr.get(j)) arr.remove(j);
//            }


        }
        //Arrays.sort(array);
//        for (int i = 0; i < arr1.length; i++) {
//            array[i] = arr1[i];
//
//        }



    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}
