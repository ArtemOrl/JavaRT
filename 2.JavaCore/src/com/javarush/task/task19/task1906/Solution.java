package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        FileReader reader = new FileReader(bufferedReader.readLine());
//        FileWriter writer = new FileWriter(bufferedReader.readLine());
//
//        bufferedReader.close();
//        ArrayList<Integer> list = new ArrayList<>();
//        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
//        {
//            int data = reader.read(); //читаем один символ (char будет расширен до int)
//             //пишем один символ (int будет обрезан/сужен до char)
//            list.add(data);
//        }
//
//        //закрываем потоки после использования
//        reader.close();
//        for (int i = 0; i < list.size(); i+=2) {
//            int data = list.get(i);
//            writer.write(data);
//        }
//
//        writer.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(reader.readLine());
        FileWriter fw = new FileWriter(reader.readLine());
        reader.close();
        int i = 0;
        while(fr.ready()){
            i++;
            int data = fr.read();
            if(i%2 == 0)
                fw.write(data);
        }
        fr.close();
        fw.close();

    }
}
