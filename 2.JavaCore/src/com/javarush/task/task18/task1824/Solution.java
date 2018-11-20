package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        while (true) {
            try
            {
//                String fileName;
                fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
                FileReader fileReader = new FileReader(fileName);
                while(fileReader.ready())
                {
                    fileReader.read();
                }
                fileReader.close();
            }
            catch (FileNotFoundException e)
            {
                System.out.println(fileName);
                break;

            }
            catch (IOException e)
            {
                e.printStackTrace();
                break;
            }

        }
    }
}
