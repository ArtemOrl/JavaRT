package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int counter = 0;
    static char currentChar = ' ';
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(br.readLine());
        //FileWriter writer = new FileWriter(br.readLine());

        br.close();
        String text = "";
        while (reader.ready())
        {
            currentChar = (char)reader.read();
            //readWorld(reader);
            text = text+currentChar;

        }

        //Что такое text.replaceAll("\\p{P}"," ").toLowerCase();???????


//        String replacedString = text.replaceAll("\\p{P}"," ").toLowerCase();
//        replacedString=replacedString.replaceAll("\\s"," ");
//
//        String splitString[] = replacedString.split(" ");
//        for (String x : splitString) {
//            if (x.equals("world")) {
//                counter++;
//            }
//        }

        String replace = text.replaceAll("\\p{Punct}"," ").toLowerCase();

        String replace2 = replace.replaceAll("\\s"," ");
        String words[] = replace2.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (word.equals("world")) counter++;
        }
        System.out.println(counter);
        reader.close();

    }
}
