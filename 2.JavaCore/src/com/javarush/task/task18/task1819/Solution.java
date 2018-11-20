package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String forFile1 = reader.readLine();
        String forFile2 = reader.readLine();
        reader.close();
        FileInputStream file1inStream = new FileInputStream(forFile1);
//        FileOutputStream file1outStream = new FileOutputStream(forFile1);
        FileInputStream file2inStream = new FileInputStream(forFile2);

        //запишем содержимое файла1 в массив
        ArrayList<Integer> list1 = new ArrayList<>();


        while (file1inStream.available()>0)
        {
            int data = file1inStream.read();
            list1.add(data);

        }
        file1inStream.close();

        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }
        FileOutputStream file1outStream = new FileOutputStream(forFile1);

        //запишем в файл1 null не будем, просто перезапишем

//        for (int i = 0; i < list1.size(); i++) {
//            file1outStream.write(Integer.parseInt(""));
//        }
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.print(list1.get(i) + " ");
//        }


        //запишем содержимое файла2 в массив
        ArrayList<Integer> list2 = new ArrayList<>();


        while (file2inStream.available()>0)
        {
            int data = file2inStream.read();
            list2.add(data);

        }
        file2inStream.close();

        //запишем в файл1 содержимое файла2
        for (int i = 0; i < list2.size(); i++) {
            file1outStream.write(list2.get(i));
        }
        //запишем в файл1 содержимое файла1
        for (int i = 0; i < list1.size(); i++) {
            file1outStream.write(list1.get(i));
        }
        file1outStream.close();
    }


    //Это решение изящнее моего

//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    String f1 = br.readLine();
//    String f2 = br.readLine();
//        br.close();
//    FileInputStream fis2 = new FileInputStream(f2);
//    FileInputStream fis1 = new FileInputStream(f1);
//    ArrayList<Integer> list = new ArrayList<>();
//
//        while (fis2.available() > 0)
//    {
//        list.add(fis2.read());
//    }
//
//        while (fis1.available() > 0)
//    {
//        list.add(fis1.read());
//    }
//
//    FileOutputStream fos = new FileOutputStream(f1);
//
//        for (int x : list)
//    {
//        fos.write(x);
//    }
//
//        fis1.close();
//        fis2.close();
//        fos.close();
//}
}
