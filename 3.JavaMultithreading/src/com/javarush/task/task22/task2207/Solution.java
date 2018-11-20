package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fis =  new FileInputStream(fileName);
        BufferedReader input = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String text = "";

        String s;
        while ((s=input.readLine())!=null){sb.append(s);sb.append("\n");}
        input.close();
        fis.close();

        text = sb.toString();
        text = text.replace("\n", " ");
//        System.out.println(text);
        String[] words = text.split(" ");
//        for (int i = 0; i < words.length; i++) {
//            System.out.println(words[i]);
//
//        }
        for (int i = 0; i < words.length; i++) {
            StringBuilder wordObrab = new StringBuilder(words[i]);
//            System.out.println(wordObrab.toString() + " wordIObrab");
            for (int j = i+1; j < words.length; j++) {
                String word = words[j];
//                System.out.println(word + " word");

                if (word.equals(wordObrab.reverse().toString())) result.add(new Pair(word, wordObrab.reverse().toString()));

            }
        }
        for (int i = 0; i < result.size(); i++) {
            if ((i+1)==result.size()) break;
            if (result.get(i).first.equals(result.get(i+1).first)){
                result.remove(result.get(i));
                i--;
            }

        }
        for (Pair pair : result) {
            System.out.println(pair.first + " " + pair.second);
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
