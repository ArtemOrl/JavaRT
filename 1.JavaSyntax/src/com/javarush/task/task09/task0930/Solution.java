package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Задача по алгоритмам
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        /*--- from keyboard --- */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }
        /*--- /from keyboard --- */

        /*--- from file (just for debug) ---*/
//        Scanner sc = new Scanner(new File("YOUR-FILE-PATH"));
//        List<String> list = new ArrayList<>();
//        while (sc.hasNextLine()) {
//            list.add(sc.nextLine());
//        }
        /*--- /from file (just for debug) ---*/

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // go through the array
        int length = array.length;
        int maxPos, minPos, comparableFirst, comparableSecond;
        String buffer;

        int counter = 0;
        for (int i = 0; i < length; i++, counter++) {
            if (isNumber(array[i])) { // if string is number
                // find greatest number and put on current position
                maxPos = i;

                for (int j = i + 1; j < length; j++) {
                    // compare each next number in array with current one
                    if (isNumber(array[j])) {
                        comparableFirst = Integer.parseInt(array[j]);
                        comparableSecond = Integer.parseInt(array[maxPos]);

                        if (comparableFirst > comparableSecond) {
                            // remember max position
                            maxPos = j;
                        }
                    }
                }

                // exchange current item with item on max position
                if (maxPos != i) {
                    buffer = array[i];
                    array[i] = array[maxPos];
                    array[maxPos] = buffer;
                }
            } else { // if string is string
                // find smallest string and put on current position
                minPos = i;

                for (int j = i + 1; j < length; j++) {
                    // compare each next string in array with current one
                    if (!isNumber(array[j]) && !isGreaterThan(array[j], array[minPos])) {
                        // remember min position
                        minPos = j;
                    }
                }

                // exchange current item with item on min position
                if (minPos != i) {
                    buffer = array[i];
                    array[i] = array[minPos];
                    array[minPos] = buffer;
                }
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }

    //строка - это на самом деле число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (
                    (i != 0 && c == '-') || //есть '-' внутри строки
                            (!Character.isDigit(c) && c != '-') // не цифра и не начинается с '-'
                    ) {
                return false;
            }
        }

        return true;
    }
}
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        ArrayList<String> list = new ArrayList<String>();
//        while (true) {
//            String s = reader.readLine();
//            if (s.isEmpty()) break;
//            list.add(s);
//        }
//
//        String[] array = list.toArray(new String[list.size()]);
//        sort(array);
//
//        for (String x : array) {
//            System.out.println(x);
//        }
//    }
//
//    public static void sort(String[] array) {
//        ArrayList<String> listString = new ArrayList<>();
//        ArrayList<Integer> listInt = new ArrayList<>();
//        for (int i = 0; i < array.length; i++) {
//            if (isNumber(array[i])){
//                listInt.add(Integer.parseInt(array[i]));
//            }else listString.add(array[i]);
//        }
//
//        //Создали два массива и разобрали основной массив на массив с цифрами и массив с буквами
//
//        String [] stringArr = (String[]) listString.toArray(new String[0]);
//        Integer[] intArr = (Integer[]) listInt.toArray(new Integer[0]);
////        String [] intArr = (String[]) listString.toArray(new String[0]);
//
//        // Массив с буквами рассортировали в прямом порядке
//        for (int i = stringArr.length-1; i > 0; i--) {
//            for (int j = 0; j < i; j++) {
//                String a = stringArr[j];
//                String b = stringArr[j+1];
//                if (isGreaterThan(a, b)){
//                    String tmp = stringArr[j];
//                    stringArr[j] = stringArr[j+1];
//                    stringArr[j+1] = tmp;
//                }
//            }
//        }
//
//        //Массив с цифрами рассортировали в обратном порядке
//        int last = intArr.length;
//
//        for ( boolean sorted = last == 0; !sorted; --last )
//        {
//            sorted = true;
//            for ( int i = 1; i < last; ++i )
//            {
//                if ( intArr[i-1] < intArr[i] )
//                {
//                    sorted = false;
//
//                    int tmp = intArr[i-1];
//                    intArr[i-1] = intArr[i];
//                    intArr[i] = tmp;
//                }
//            }
//        }
//
////        or
////        for (int j = 0; j < intArray.Length - 1; j++)
////        {
////            for (int k = j + 1; k < intArray.Length; k++)
////            {
////                if (intArray[j] < intArray[k])
////                {
////                    int temp = intArray[k];
////                    intArray[k] = intArray[j];
////                    intArray[j] = temp;
////                }
////            }
////        }
//
//        //собрали обратно массив слив два отсортированных массива в него
//        int j = 0;
//        for (int i = 0; i < array.length; i+=2) {
//
//            array[i] = stringArr[j];
//            String b = Integer.toString(intArr[j]);
//            array[i+1] = b;
//            j++;
//        }
//
////        System.out.println();
////        for (String ar : array) {
////            System.out.println(ar);
////        }
////        System.out.println();
////        for (Integer integer : intArr) {
////            System.out.println(integer);
////        }
////        for (String string : stringArr) {
////            System.out.println(string);
////        }
//    }
//
//    // Метод для сравнения строк: 'а' больше чем 'b'
//    public static boolean isGreaterThan(String a, String b) {
//        return a.compareTo(b) > 0;
//    }
//
//
//    // Переданная строка - это число?
//    public static boolean isNumber(String s) {
//        if (s.length() == 0) return false;
//
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            char c = chars[i];
//            if ((i != 0 && c == '-') // есть '-' внутри строки
//                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
//            {
//                return false;
//            }
//        }
//        return true;
//    }
//}
