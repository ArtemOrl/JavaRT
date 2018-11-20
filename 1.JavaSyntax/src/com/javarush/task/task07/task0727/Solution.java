package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

//        ArrayList<String> listUpperCase = new ArrayList<String>();
//        for (int i = 0; i < list.size(); i++) {
//            String s = list.get(i);
//            listUpperCase.add(s.toUpperCase());
//        }
        ArrayList<String> listX2X3 = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            String arg = list.get(i);
            int x = arg.length();

            if (x%2==0) {
                listX2X3.add(arg);
                listX2X3.add(arg);
            } else {
                listX2X3.add(arg);
                listX2X3.add(arg);
                listX2X3.add(arg);
            }

        }
        listX2X3.add("fuuuu");
        for (int i = 0; i < listX2X3.size()-1; ) {
            if (listX2X3.get(i)==listX2X3.get(i+1)&&(listX2X3.get(i+1)!=listX2X3.get(i+2))) {
                System.out.println(listX2X3.get(i) + " " + listX2X3.get(i+1));
                i+=2;
            }
            else if ((listX2X3.get(i)==listX2X3.get(i+1))&&(listX2X3.get(i+1)==listX2X3.get(i+2))){
                System.out.println(listX2X3.get(i) + " " + listX2X3.get(i+1) + " " + listX2X3.get(i+2));
                i+=3;
            } else break;
        }
    }
}
