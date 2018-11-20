package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
//        detectAllWords(crossword, "home", "same");
        List<Word> wordList = detectAllWords(crossword, "home", "same");
        for (Word word : wordList) {
            System.out.println(word.toString());
        }
        System.out.println(wordList.size());
        /*

Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> wordList = new ArrayList<>();

        for (String word : words) nextWord: {
            String wordForList = word;
            char[] charWord = word.toCharArray();
            byte[] byteWord = word.getBytes();

            for (int i = 0; i < charWord.length; i++) {
//                String charLetter = Character.toString(charWord[i]);
                byte[] charLetter = Character.toString(charWord[i]).getBytes();
                int intLetter = charLetter[0];

                for (int j = 0; j < crossword.length; j++) {
                    for (int k = 0; k < crossword[j].length; k++) {
                        int elem = crossword[j][k];
                        if (elem==intLetter){

                            int cwI = j;
                            int cwJ = k;
//                            System.out.println(cwI + " cwI " + cwJ + " cwJ");

                            wordList.add(wordDetection(crossword, byteWord, cwI, cwJ, wordForList));

                            break nextWord;
                        }
                    }

                }

            }
        }

        return wordList;
    }

    public static Word wordDetection (int[][] crossword, byte[] word, int cwI, int cwJ, String wordForList){

        Word wword = null;

        int[][] searchDirections = new int[][] {
                {0, 1},
                {1, 1},
                {1, 0},
                {1, -1},
                {0, -1},
                {-1, -1},
                {-1, 0},
                {-1, 1},
        };


        int[] rightSearchDirection = null;
        int countI = 0;
        int countJ = 0;

        for (int n = 1; n < word.length; n++) {
            int b = (int)word[n];



            if (rightSearchDirection==null) {
                for (int i = 0; i < searchDirections.length; i++) {
                    int[] searchDirection = searchDirections[i];

                    if ((cwI + searchDirection[0])<crossword.length &&
                            ((cwJ + searchDirection[1]) < crossword[cwI + searchDirection[0]].length) &&
                            (crossword[cwI + searchDirection[0]][cwJ + searchDirection[1]] == b)) {
                        rightSearchDirection = searchDirection;
                        countI = cwI + searchDirection[0];
                        countJ = cwJ + searchDirection[1];
                        break;
                    }

                }
            }

            else if (rightSearchDirection!=null){
                if (n<word.length && (countI+rightSearchDirection[0])<crossword.length &&
                        (countJ+rightSearchDirection[1])<crossword[countI+rightSearchDirection[0]].length &&
                        crossword[countI+rightSearchDirection[0]][countJ+rightSearchDirection[1]] == b) {

                    countI = countI+rightSearchDirection[0];
                    countJ = countJ+rightSearchDirection[1];

                }
            }

            if (n==word.length-1){
                wword = new Word(wordForList);
                wword.startX = cwJ;
                wword.startY = cwI;
                wword.endX = countJ;
                wword.endY = countI;

            }
        }
        return wword;
    }
    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
