package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream file1 = new FileOutputStream(reader.readLine());
        FileInputStream file2 = new FileInputStream(reader.readLine());

        FileInputStream file3 = new FileInputStream(reader.readLine());


        ArrayList<Integer> list2 = new ArrayList<>();

        //запишем содержимое файла2 в массив
        while (file2.available()>0)
        {
            int data = file2.read();
            list2.add(data);

        }
        file2.close();
        //запишем в файл1 содержимое файла2
        for (int i = 0; i < list2.size(); i++) {
            file1.write(list2.get(i));
        }

        ArrayList<Integer> list3 = new ArrayList<>();

        //запишем содержимое файла3 в массив
        while (file3.available()>0)
        {
            int data = file3.read();
            list3.add(data);

        }
        file3.close();
        //дозапишем в файл1 содержимое файла3
        for (int i = 0; i < list3.size(); i++) {
            file1.write(list3.get(i));
        }
        file1.close();
    }
}
