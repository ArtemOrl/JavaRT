package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        text = text.replaceAll(" ", "");
        char[] charArray = text.toCharArray();

        ArrayList<Character> vowel = new ArrayList<>();
        ArrayList<Character> noVowel = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (isVowel(c)==true) vowel.add(c);
            else noVowel.add(c);
        }
        for (Character c : vowel) {
            System.out.print(c + " ");
        }
        System.out.println();
        for (Character character : noVowel) {
            System.out.print(character + " ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}