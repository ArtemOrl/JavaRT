package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            FileInputStream file = new FileInputStream(reader.readLine());

//            ArrayList<Integer> list = new ArrayList<>();
//
//            while (file.available() > 0) {
//                int data = file.read();
//                list.add(data);
//
//            }
            if (file.available()<1000){
                file.close();
                throw new DownloadException();
            }
            if (file.available()<1000) break;
        }



    }

    public static class DownloadException extends Exception {

    }
}
