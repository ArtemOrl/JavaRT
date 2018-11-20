package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();




        char[] strChar1;
        strChar1 = s.toCharArray();


        char[] nStrChar = new char[s.length()];

        for (int i = 0; i < strChar1.length; i++) {
            if (i>0) {
                String b = Character.toString(strChar1[i - 1]);
                String g = Character.toString(strChar1[i]);
                char ggg = s.charAt(i);
                char bbb = s.charAt(i-1);
                //System.out.println(b + " " + g);

                if ( Character.isLetter(ggg) && Character.isLetter(bbb)) nStrChar[i] += strChar1[i];
                else if ( Character.isLetter(ggg) && !Character.isLetter(bbb))nStrChar[i] += Character.toUpperCase(strChar1[i]);
                else if ( !Character.isLetter(ggg) && !Character.isLetter(bbb)) nStrChar[i] += strChar1[i];
                else if ( !Character.isLetter(ggg) && Character.isLetter(bbb)) nStrChar[i] += strChar1[i];
            }
            if (i==0){
                String g = Character.toString(strChar1[i]);

                if (g != " ") nStrChar[i] += Character.toUpperCase(strChar1[i]);
                else if (g==" ") nStrChar[i] += strChar1[i];
            }
        }
//        String s1 = new String();
//
//
//        //Напишите тут ваш код
//        if (Character.isAlphabetic(s.charAt(0)))
//            s1 += Character.toUpperCase(s.charAt(0));
//        for (int i = 1; i < s.length(); i++)
//        {
//            char character = s.charAt(i);
//            char beforeChar = s.charAt(i - 1);
//
//            if (Character.isLetter(character) && !Character.isLetter(beforeChar))
//            {
//                character = Character.toUpperCase(character);
//                s1 += character;
//
//            } else
//                s1 += character;
//
//        }
        System.out.println(nStrChar);
    }
}
