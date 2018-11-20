package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader  fileReader1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        ArrayList<String> list = new ArrayList<>();

        while (fileReader1.ready()) {
            String s = fileReader1.readLine();
            String[] line = s.split(" ");

            Pattern pattern= Pattern.compile("(\\d+)");

            for (int j = 0; j < line.length; j++) {
                Matcher m=pattern.matcher(line[j]);
                if(m.find()){
                    System.out.println(line[j]);
                    writer.write(line[j]);
                    writer.write(" ");
                }
            }
        }
        fileReader1.close();
        writer.close();
    }
}
