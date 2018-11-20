package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("/Users/a1/Desktop/2022.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter stringWriter = new StringWriter();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        FileInputStream file = new FileInputStream(reader.readLine());
        try {
            while (is.available() > 0) {
                int data = is.read();
                stringWriter.write(data);

            }
            is.close();
            return stringWriter;
        } catch (Exception e){
            return new StringWriter();
        }
//        reader.close();


    }
}