package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String filename = reader.readLine();
        FileInputStream file = new FileInputStream(args[0]);

        String[] arr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String s = "";
//        Map<String, Integer> map = new HashMap<>();

        while (file.available() > 0)
        {
            char elem = ((char)file.read());
            s += elem;
        }

        int count = 0;
        char[] vFile = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
//            count=0;
            String letter = arr[i];
            for (int j = 0; j < vFile.length; j++) {
                String c = Character.toString(vFile[j]);
                if (letter.equals(c)) count++;
            }
//            map.put(letter, count);
        }

//        char[] elements = args[0].toCharArray();
//        System.out.println(elements.length);
        System.out.println(count);
        file.close();
    }
}
