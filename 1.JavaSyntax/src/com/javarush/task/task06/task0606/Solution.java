package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;


    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String a = buf.readLine();
        char[] mas = a.toCharArray();

        for (int i = 0; i < mas.length; i++)
        {
            int z = mas[i];
            if(z % 2 == 0) even++;
            else odd++;
        }
        System.out.print("Even: " + even + " Odd: " + odd);
    }
}
