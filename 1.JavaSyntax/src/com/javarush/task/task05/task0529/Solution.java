package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


        int sum = 0;

        while (true){
            String num = bufferedReader.readLine();
            try{
                int intNum = Integer.parseInt(num);
                sum += intNum;
            }catch(Exception e ){
                System.out.println(sum);
                break;
            }

        }
    }
}
