package com.javarush.task.task19.task1918;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Archive {
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
//        System.out.println(text);
        String tag = args[0];

        // XML тэг в формате <xxx></xxx>
//        Pattern pattern = Pattern.compile("^<([a-z]+)([^>]+)*(?:>(.*)<\\/\\1>|\\s+\\/>)$");
//        Pattern pattern = Pattern.compile(":|;");
//        String[] animals = pattern.split("cat:dog;bird:cow");

//        String[] tags = text.split("(?=<span)|(?=</span>)");
//        String[] tags = text.split("(?=<span>)");
//        String[] tags = text.split("(?=<s[a-z]*[A-z]*\\s*\\p{P}*</s)");

        String text1 = text.replaceAll("\\n", "");
        String[] tags = text1.split("(?=\\<\\p{ASCII}+\\<\\/)");

//        Pattern p = Pattern.compile("(?=(<span\\.*\\</span>))");
//        Matcher m = p.matcher(text);
//sim-control     3110/tcp   simulator control port
//([-a-zAz]+)(?:\\s?|\\t?)+(\\d+)\\/((tcp|udp))

//        while(m.find()) {
//            System.out.println(testStr.substring(m.start(), m.end()));
//        }

//        System.out.println();
//        System.out.println();
        ArrayList<String> nextTags = new ArrayList<>();
        String nextTag;
        int count;
        for (count = 0; count < tags.length;) {
            nextTag = "";
            if (tags[count].startsWith("<"+tag)) {
                nextTag+=tags[count];
//               System.out.println(nextTag + " NextTag pered for2");
                int i = count+1;
                if (count==tags.length-1) {
                    if (tags[count].contains("</" + tag + ">")){
                        nextTags.add(nextTag);
                        break;
                    }
                }
                for ( ; i < tags.length;) {



                    //Эти счетчики важные
//                   System.out.println(count + " count vhod v for2");
                    nextTag += tags[i];
//                   System.out.println(tags[i] + " tags[i] for2");
//                   System.out.println(nextTag + " NextTag");
                    if ((tags[i].contains("</" + tag + ">"))&&(tags[i+1].contains("<span"))) {
                        nextTags.add(nextTag);

                        //на случай вложенных тегов
//                       System.out.println(nextTag + "         NextTag pered dobavleniem");
                        String[] words = nextTag.split("(?=span)");
                        int countOfTag = words.length - 1;
//                       System.out.println(countOfTag + "         COUNT OF TAG");//it works
                        if (countOfTag>2){

                            nextTags.add(poiskVlogTag(nextTag, tag));
//                           System.out.println(poiskVlogTag(nextTag, tag));
                        }

                        count+=i-count;
//                       System.out.println(count + " count for2");
                        break;
                    }
                    i++;

//                   count++;
                }
//               count+=i;

            }

            count+=1;
//            System.out.println(count + " count for1");
        }


//        System.out.println();
//        for (String s : tags) {
//            System.out.println(s);
//        }
//        System.out.println();
        for (String s : nextTags) {
            System.out.println(s);
        }
//        String replace = text.replaceAll("\\p{Punct}","");
//        String replace2 = replace.replaceAll("\\n","");

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
//               System.out.println(nextTag + " NextTag pered for2");
                int i = count+1;
//                if (count==tags.length-1) {
//                    if (tags[count].contains("</" + tag + ">")){
//                        nextTags1.add(nextTag1);
//                        break;
//                    }
//                }
                for ( ; i < tags.length;) {



                    //Эти счетчики важные
//                   System.out.println(count + " count vhod v for2");
                    nextTag1 += tags[i];
//                   System.out.println(tags[i] + " tags[i] for2");
//                   System.out.println(nextTag + " NextTag");
                    if ((tags[i].contains("</" + tag + ">"))) {
                        nextTags1.add(nextTag1);


                        count+=i-count;
//                       System.out.println(count + " count for2");
                        break;
                    }
                    i++;

                }
            }

            count+=1;
//            System.out.println(count + " count for1");
        }

//        System.out.println(nextTags1.get(0));
//        for (String s : nextTags1) {
//            System.out.println(s);
//        }
        return nextTags1.get(0);
    }
}

