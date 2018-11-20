package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String text = reader.readLine();
            strings.add(text);
        }



        //находим самый korotkiy элемент
        String samiyKorotkiy = strings.get(0);
        for (int i = 0; i < strings.size(); i++) {
            String el = strings.get(i);
            if (el.length()<samiyKorotkiy.length()) samiyKorotkiy=el;

        }
        //System.out.println("samiyKorotkiy "+samiyKorotkiy);
        //находим индекс самого короткого элемента
        int indexSamiyKorotkiy = strings.indexOf(samiyKorotkiy);
        //System.out.println("index SK "+indexSamiyKorotkiy);
//        for (int i = 0; i < strings.size(); i++) {
//            String el = strings.get(i);
//            if (el.length()==samiyKorotkiy.length()) {
//                indexSamiyKorotkiy = strings.indexOf(el);
//                System.out.println("index SK "+indexSamiyKorotkiy);
//                break;
//            }
//        }

        //находим самый длинный элемент
        String samiyDlinniy = strings.get(0);
        for (int i = 0; i < strings.size(); i++) {
            String el = strings.get(i);
            if (el.length()>samiyDlinniy.length()) samiyDlinniy=el;

        }
        //System.out.println("samiy Dlinniy" + samiyDlinniy);
        //находим индекс самого длинного элемента
        int indexSamiyDlinniy = strings.indexOf(samiyDlinniy);
        //System.out.println("index SD "+indexSamiyDlinniy);
//        for (int i = 0; i < strings.size(); i++) {
//            String el = strings.get(i);
//            if (el.length()==samiyDlinniy.length()) {
//                indexSamiyDlinniy = strings.indexOf(el);
//                System.out.println("index SD "+indexSamiyDlinniy);
//                break;
//            }
//        }
        if(indexSamiyDlinniy<indexSamiyKorotkiy) System.out.println(samiyDlinniy);
        else System.out.println(samiyKorotkiy);
    }
}
