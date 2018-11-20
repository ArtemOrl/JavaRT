package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        try{
            while (true){
                Integer n = Integer.parseInt(reader.readLine());
                arrayList.add(n);

            }
        }catch ( NumberFormatException e )
        {
            for ( int n : arrayList )
            {
                System.out.println( n );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
