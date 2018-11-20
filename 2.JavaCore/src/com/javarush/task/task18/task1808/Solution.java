package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{

        ///Users/a1/Desktop/file.txt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());

        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        FileOutputStream outputStream1 = new FileOutputStream(reader.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        while (file.available()>0)
        {
            int data = file.read();
            list.add(data);

        }
        file.close();
        int razmerOfFile2 = list.size()/2;
        int razmerOfFile3 = list.size()%2 + razmerOfFile2;
        for (int i = 0; i < razmerOfFile3; i++) {
            outputStream.write(list.get(i));
        }
        for (int j = razmerOfFile3; j < list.size(); j++) {
            outputStream1.write(list.get(j));
        }

        outputStream.close();
        outputStream1.close();
    }
}
