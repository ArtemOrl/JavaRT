package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
//        String fileName = "/Users/a1/Desktop/file.txt";
        FileInputStream fis =  new FileInputStream(fileName);
        BufferedReader input = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String text = "";

        String s;
        while ((s=input.readLine())!=null){sb.append(s);sb.append("\n");}
        input.close();
        fis.close();

//        System.out.println(sb);

        text = sb.toString();
        text = text.replace("\n", " ");
        String[] words = text.split(" ");
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
//        StringBuilder result = new StringBuilder();
//        ArrayList<String> list = new ArrayList<>();
//        Arrays.sort(words);
//        for (int i = 0; i < words.length; i++) {
//            list.add(words[i]);
//
//        }
//
//        StringBuilder word = new StringBuilder(words[0]);
//        for (int i = 0; i < words.length; i++) {
//
//
//            String newWord = word.toString();
//
////            System.out.println(newWord + " NewWord");
//            StringBuilder word1 = new StringBuilder(word.reverse());
//            for (int j = 0; j < words.length; j++) {
//
//
////                System.out.println(words[j] + " wordj");
//
//                String s = words[j];
////                System.out.println(s + " s");
////                System.out.println(Character.toString(word1.charAt(0)).toUpperCase());
//                if (s.startsWith(Character.toString(word1.charAt(0)).toUpperCase())) {
//                    if (!(result.toString().contains(newWord))) {
//                        result.append(newWord).append(" ");
//
//                    }
//                    if (!(result.toString().contains(s))) {
//                        result.append(s).append(" ");
//                        newWord = s;
//                    }
//                    word = new StringBuilder(s);
//                }
//            }
//        }
//
//
//        if (!(result.equals(""))){
//            String n = result.toString();
//            n = n.substring(0, result.lastIndexOf(" "));
//            result = new StringBuilder(n);
//        }
//        if (words.length==0) return new StringBuilder();
//        return result;

        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, words);
        StringBuilder sb = new StringBuilder();
        if (strings.size() == 0) {
            return new StringBuilder();
        }

        sb.append(strings.get(0));
        strings.remove(0);

        while (strings.size() > 0) {
            for (int i = 0; i < strings.size(); i++) {
                String a = strings.get(i).toUpperCase().toLowerCase();
                String b = sb.toString().toUpperCase().toLowerCase();
                if (a.charAt(0) == b.charAt(sb.length() - 1)) { // в конец
                    sb.append(" ").append(strings.get(i));
                    strings.remove(i);
                    continue;
                }

                if (b.charAt(0) == a.charAt(a.length() - 1)) { //в начало
                    sb.insert(0, " ");
                    sb.insert(0, strings.get(i));
                    strings.remove(i);
                }
            }
        }
        return sb;
    }
}
