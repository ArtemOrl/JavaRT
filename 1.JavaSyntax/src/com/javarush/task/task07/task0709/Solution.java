package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<String>();
        //List<String> list = new ArrayList<>();
        //strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String text = reader.readLine();
            strings.add(i, text);

        }
        //находим самый korotkiy элемент
        String samiyKorotkiy = strings.get(0);
        for (int i = 0; i < strings.size(); i++) {
            String el = strings.get(i);
            if (el.length()<samiyKorotkiy.length()) samiyKorotkiy=el;

        }
        //если сымых korotkih несколько, добавляем их в новый ArrayList
        //System.out.println(samiyKorotkiy);
        ArrayList<String> list = new ArrayList();
        for (int i = 0; i < strings.size(); i++) {
            String el = strings.get(i);
            if (el.length()==samiyKorotkiy.length()) list.add(el);
            //System.out.println(list.get(i));
        }
        //печатем новый ArrayList, в нем будет или один, или несколько элементов
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
