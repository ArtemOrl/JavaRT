package com.javarush.task.task19.task1922;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file = rd.readLine();
        rd.close();

        BufferedReader  fileReader = new BufferedReader(new FileReader(file));
        while (fileReader.ready()) {
            String s = fileReader.readLine();
            String[] line = s.split(" ");

            int counterBig = 0;
            for (int i = 0; i < words.size(); i++) {
                int counter = 0;
                String word = words.get(i);
                for (int j = 0; j < line.length; j++) {
                    String s1 = line[j];
                    if (word.equals(s1)) counter++;
                }
                if (counter==1) {
                    counterBig++;
                }

            }
            if (counterBig==2){
                for (int i = 0; i < line.length; i++) {
                    System.out.print(line[i] + " ");

                }
                System.out.println();
            }
        }
        fileReader.close();
    }
}
