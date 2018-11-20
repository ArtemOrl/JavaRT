package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {

            initExceptions();
//            FilenotFound_Demo();
//            Unchecked_Demo();
//            ArrayStoreException_Demo();
//            ClassCastException_Demo();
//            NullPointerException_Demo();
//            NegativeArraySizeException_Demo();
//            NumberFormatException_Demo();
//            StringIndexOutOfBoundsException_Demo();
//            IndexOutOfBoundsException_Demo();
            for (Exception exception : exceptions) {
                System.out.println(exception);
            }
        }

        private static void initExceptions() {   //it's first exception
            try {
                float i = 1 / 0;

            } catch (Exception e) {
                exceptions.add(e);
            }



            try
            {
                FileInputStream file = new FileInputStream("d:\\zxcvv.txt");
            } catch (FileNotFoundException e)
            {
                exceptions.add(e);
            }
//            try {
//                File file = new File("/Users/a1/Desktop/file3.txt");
//                FileReader fr = new FileReader(file);
//            } catch (FileNotFoundException e2) {
//                exceptions.add(e2);
//            }



            try {
                int num[] = {1, 2, 3, 4};
                System.out.println(num[5]);
            } catch (ArrayIndexOutOfBoundsException e3) {
                exceptions.add(e3);
            }



            try {
                Object x[] = new String[3];
                x[0] = new Integer(0);
            } catch (ArrayStoreException e4) {
                exceptions.add(e4);
            }




            String s = null;
            try {
                Object x = new Integer(0);
                s = (String) x;
            } catch (ClassCastException e5) {
                exceptions.add(e5);
            }



            try {
                String str = null;
                System.out.println(str.length());
            } catch (NullPointerException e6) {
                exceptions.add(e6);
            }



            int a = -10;
            int b = -1000;
            try {
                int[] asd = new int[a + b];

            } catch (NegativeArraySizeException e7) {
                exceptions.add(e7);
            }




            try {
                int num = Integer.parseInt("XYZ");
                System.out.println(num);
            } catch (NumberFormatException e8) {
                exceptions.add(e8);
            }




            try {
                String str = "easysteps2buildwebsite";
//                System.out.println(str.length());
                char c = str.charAt(0);
                c = str.charAt(40);
                System.out.println(c);
            } catch (StringIndexOutOfBoundsException e9) {
                exceptions.add(e9);
            }

            try
            {
                throw new InterruptedException();
            }catch (InterruptedException e10)
            {
                exceptions.add(e10);
            }


//            int[] bb = new int[1];
//            try {
//                int z = bb[10];
//            } catch (RuntimeException e10) {
//                exceptions.add(e10);
//            }
        }

    }

