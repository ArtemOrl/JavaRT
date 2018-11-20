package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        for (int i = 0; i < alphabet.size(); i++) {
            char c = abcArray[i];
            int counter = 0;
            for (int j = 0; j < list.size(); j++) {

                char[] stroka = list.get(j).toCharArray();
                //System.out.println(stroka);
                for (int k = 0; k < stroka.length; k++) {
                    char c1 = stroka[k];
                    if (c1==c){
                        counter++;
                    }
                }
            }
            System.out.println(c + " " + counter);
        }
    }

}
