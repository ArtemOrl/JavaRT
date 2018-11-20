package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;
        //ArrayList<String> list = new ArrayList<String>();
        //ArrayList<String> list = new ArrayList();


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //ArrayList<String> list = new ArrayList<String>();
        //List<String> list = new ArrayList<>();
        strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String text = reader.readLine();
            strings.add(i, text);

        }
        //находим самый длинный элемент
        String samiyDlinniy = strings.get(0);
        for (int i = 0; i < strings.size(); i++) {
            String el = strings.get(i);
            if (el.length()>samiyDlinniy.length()) samiyDlinniy=el;

        }
        //если сымых длинных несколько, добавляем их в новый ArrayList
        //System.out.println(samiyDlinniy);
        ArrayList<String> list = new ArrayList();
        for (int i = 0; i < strings.size(); i++) {
            String el = strings.get(i);
            if (el.length()==samiyDlinniy.length()) list.add(el);
            //System.out.println(list.get(i));
        }
        //печатем новый ArrayList, в нем будет или один, или несколько элементов
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
