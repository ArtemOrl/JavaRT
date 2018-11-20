package com.javarush.task.task10.task1015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {



    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);

    }

    public static ArrayList<String>[] createList() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String>[] arrayOfStringList = new ArrayList[3];

        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2= new ArrayList<String>();
        ArrayList<String> list3 = new ArrayList<String>();

        for (int i = 1; i < 10; i++) {
            list1.add("asfadd");
            list2.add("akllkjvzxcv");
            list3.add("alhj;;j;;ok;ojlhuh");
        }
        arrayOfStringList[0] = list1;
        arrayOfStringList[1] = list2;
        arrayOfStringList[2] = list3;

        return arrayOfStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}