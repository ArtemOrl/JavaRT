package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();


        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        br.close();

        while (reader.ready()){
            String text = reader.readLine();
            String replace = text.replaceAll("\\p{Punct}","");
            String replace2 = replace.replaceAll("\\n","");
            writer.write(replace2);
        }
        reader.close();
        writer.close();

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        FileReader inFile = new FileReader(reader.readLine());
//        FileWriter outFile = new FileWriter(reader.readLine());
//
//        String fileContains = "";
//
//        while (inFile.ready()){
//            fileContains += (char) inFile.read();
//        }
//
//        fileContains = fileContains.replaceAll("\\p{Punct}", "").replaceAll("\n", "");
//        //System.out.println(fileContains);
//
//        outFile.write(fileContains);
//
//        reader.close();
//        inFile.close();
//        outFile.close();
    }
}
