package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        int count = 1;
        for (int i = 0; i < 5; i++) {
            String s = Integer.toString(count);
            String l = "Stroka" + s;
            list.add(i, l);// or list.add(i, "Stroka" + s); or list.add(i, "Stroka" + count);
            count++;
        }
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
    }
}
