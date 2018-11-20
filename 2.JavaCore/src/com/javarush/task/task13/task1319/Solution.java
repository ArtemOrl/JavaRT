package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(reader.readLine())));

        while(true){
            String s = reader.readLine();

            write.write(s);
            write.newLine();
            if(s.equals("exit")) break;
        }

        reader.close();
        write.close();
    }
}
