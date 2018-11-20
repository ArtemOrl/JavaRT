package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {

    static char currentChar = ' ';
    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        FileReader reader = new FileReader(br.readLine());
//        FileWriter writer = new FileWriter(br.readLine());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();


        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        br.close();

        while (reader.ready()){
            String text = reader.readLine();
            String[] textArray = text.split(" ");
            for (String s : textArray) {
                try{
                    int sym = Integer.parseInt(s);
                    writer.write(Integer.toString(sym));
                    writer.write(" ");
                }
                catch (Exception e){continue;}
            }

        }
//        String text = "";
//        while (reader.ready())
//        {
//            String text = reader.readLine();
//
//        }
////        System.out.println(text);
//        ArrayList<Integer> list = new ArrayList<>();
//        String[] symbols = text.split(" ");
//        for (int j = 0; j < symbols.length; j++) {
////            System.out.println(symbols[j]);
//            String symbol = symbols[j];
//            try{
//                int sym = Integer.parseInt(symbol);
//                list.add(sym);
//            }
//            catch (Exception e){continue;}
//        }
//        byte[] buff = new byte[list.size()];
//        for (int j = 0; j < list.size(); j++) {
//
//            String x = list.get(j).toString();
//
//
//            writer.write(x);
//            writer.write(" ");
//        }

        reader.close();
        writer.close();
    }
}
