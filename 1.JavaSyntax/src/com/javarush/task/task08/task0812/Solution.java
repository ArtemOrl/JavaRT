package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Integer arg = Integer.parseInt(reader.readLine());
            list.add(arg);
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int z = i+1;
            if(z==list.size()){
                count+=1;
                list1.add(count);
                break;
            }
            if (list.get(i)==list.get(z)){
                count+=1;
            } else {
                count+=1;
                list1.add(count);
                count = 0;
            }
        }
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println(list1.get(i));
//
//        }
        int max = 0;
        for (int i = 0; i < list1.size(); i++) {
            int arg = list1.get(i);
            if (max<arg) max = arg;
        }
        System.out.println(max);
    }
}