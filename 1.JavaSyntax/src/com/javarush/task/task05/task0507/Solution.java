package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        float sum = 0;
        float count = 0;
        float ar = 0;
        while (true){
            String stringNum = bufferedReader.readLine();
            float floatNum = Float.parseFloat(stringNum);
            sum += floatNum;
            count += 1;
            if (stringNum.equals("-1")){
                sum+=1;
                ar = sum/(count-1);
                System.out.println(ar);
                break;
            }
        }
    }
}

