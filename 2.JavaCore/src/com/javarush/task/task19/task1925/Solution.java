package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));


        ArrayList<String> list = new ArrayList<>();

        while (fileReader1.ready()) {
            String s = fileReader1.readLine();
            String[] line = s.split(" ");

            for (int i = 0; i < line.length; i++) {
                if (line[i].length()>6){
                    System.out.println(line[i]);
                    list.add(line[i]);
                }
            }
        }
        fileReader1.close();
        for (int i = 0; i < list.size(); i++) {
            writer.write(list.get(i));
            if (i!=list.size()-1) writer.write(",");
        }
        writer.close();
    }
}
