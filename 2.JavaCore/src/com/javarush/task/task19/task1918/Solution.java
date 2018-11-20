package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String file = br.readLine();
            br.close();
            String text = "";
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.ready()){
                char currentChar = (char)reader.read();
                text += currentChar;
            }
            reader.close();

            String tag = args[0];

            String text1 = text.replaceAll("\\n", "");
            String[] tags = text1.split("(?=\\<\\p{ASCII}+\\<\\/)");

            ArrayList<String> nextTags = new ArrayList<>();
            String nextTag;

            int count;
            for (count = 0; count < tags.length;) {
                nextTag = "";
                if (tags[count].startsWith("<"+tag)) {
                    nextTag+=tags[count];

                    int i = count+1;
                    if (count==tags.length-1) {
                        if (tags[count].contains("</" + tag + ">")){
                            nextTags.add(nextTag);
                            break;
                        }
                    }
                    for ( ; i < tags.length;) {

                        nextTag += tags[i];
                        if ((tags[i].contains("</" + tag + ">"))&&(tags[i+1].contains("<span"))) {
                            nextTags.add(nextTag);

                            //на случай вложенных тегов
                            String[] words = nextTag.split("(?=span)");
                            int countOfTag = words.length - 1;
                            if (countOfTag>2){
                                nextTags.add(poiskVlogTag(nextTag, tag));
                            }
                            count+=i-count;
                            break;
                        }
                        i++;
                    }
                }
                count+=1;
            }

            for (String s : nextTags) {
                System.out.println(s);
            }

        }

        public static String poiskVlogTag (String nextTag, String tag){
            String text1 = nextTag.replaceAll("\\n", "");
            String[] tags = text1.split("(?=\\<\\p{ASCII}+\\<\\/)");
            tags[0] = " ";
            ArrayList<String> nextTags1 = new ArrayList<>();
            String nextTag1;
            int count;
            for (count = 0; count < tags.length;) {
                nextTag1 = "";
                if (tags[count].startsWith("<"+tag)) {
                    nextTag1+=tags[count];
                    int i = count+1;

                    for ( ; i < tags.length;) {

                        nextTag1 += tags[i];
                        if ((tags[i].contains("</" + tag + ">"))) {
                            nextTags1.add(nextTag1);
                            count+=i-count;
                            break;
                        }
                        i++;
                    }
                }
                count+=1;
            }

            return nextTags1.get(0);
        }
}
