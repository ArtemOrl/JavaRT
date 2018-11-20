package com.javarush.task.task10.task1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Одинаковые слова в списке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        ArrayList<String> wordsCheck = new ArrayList<>(list);
        for (int i = 0; i < wordsCheck.size(); i++) {
            int count = 0;
            //char[] word = wordsCheck.get(i).toCharArray(); //odno slovo v vide massiva
            String word = wordsCheck.get(i);
            for (int j = 0; j < list.size(); j++) {
                //char[] wordFromList = list.get(j).toCharArray(); //to je tol'ko iz drugogo massiva
                String wordFromList = list.get(j);
                if (word.equals(wordFromList)) count++;
            }
            result.put(word, count);

        }


        return result;
    }

}

