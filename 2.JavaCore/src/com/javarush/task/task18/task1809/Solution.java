package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());

        FileOutputStream outputStream = new FileOutputStream(reader.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        while (file.available()>0)
        {
            int data = file.read();
            list.add(data);

        }
        file.close();

        //сделаем ещ] массив и перезапишем в него содержимое файла в обратном порядке
        ArrayList<Integer> list1 = new ArrayList<>();

        int index=0;
        for (int i = list.size()-1; i >= 0; i--) {
            list1.add(index, list.get(i));

            index++;
        }

        //Теперь запишем содержимое нового массива во второй файл
        for (int i = 0; i < list1.size(); i++) {
            outputStream.write(list1.get(i));
        }
        outputStream.close();
    }
}
