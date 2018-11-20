package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        String writeFile = args[1];

        FileInputStream fis =  new FileInputStream(fileName);
        BufferedReader input = new BufferedReader(new InputStreamReader(fis, "Windows-1251"));

        FileOutputStream outputStream = new FileOutputStream(writeFile);

        String s;
        while ((s=input.readLine())!=null){

            byte[] buffer = s.getBytes("UTF-8");
//            String s1 = new String(buffer, "Windows-1251");
//            buffer = s1.getBytes("UTF-8");
            outputStream.write(buffer);
        }

        fis.close();
        input.close();
        outputStream.close();
    }
}
