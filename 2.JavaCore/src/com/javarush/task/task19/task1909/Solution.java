package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    static char currentChar = ' ';
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();


        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        br.close();
        String text = "";
        while (reader.ready())
        {
            currentChar = (char)reader.read();
            text = text+currentChar;
        }
        char[] symbols = text.toCharArray();
        String[] sym = new String[symbols.length];
        for (int i = 0; i < symbols.length; i++) {
            String s = Character.toString(symbols[i]);
            if (s.equals(".")) sym[i] = "!";
            else sym[i] = s;
        }
        for (int i = 0; i < sym.length; i++) {
            writer.write(sym[i]);

        }
        reader.close();
        writer.close();
    }
}
