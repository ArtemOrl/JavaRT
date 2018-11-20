package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {

//    public static class LineItem {
//
//        final Type type;
//        final String line;
//
//        LineItem(Type type, String line) {
//            this.type = type;
//            this.line = line;
//        }
//    }

    public static List<LineItem> lines = new ArrayList<LineItem>();


//    private static final List<String> file1Lines = new ArrayList<>();
//    private static final List<String> file2Lines = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();

        br.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));

        List<String> listFromFile1 = new ArrayList<>();
        List<String> listFromFile2 = new ArrayList<>();

        while (reader1.ready()){
            String s = reader1.readLine();
            listFromFile1.add(s);
        }
        reader1.close();
        while (reader2.ready()){
            String s1 = reader2.readLine();
            listFromFile2.add(s1);
        }

        reader2.close();


        int counter = 0;
        int indexLine = 0;

//        for (indexLine = 0; indexLine < 10; ){

        while (true){



//            if (listFromFile1.size()>listFromFile2.size()) if (indexLine>=listFromFile1.size()) break;
//            else if (listFromFile1.size()<listFromFile2.size()) if (counter>=listFromFile2.size()) break;

            if (indexLine==listFromFile1.size()) break;
            if (counter==listFromFile2.size()) break;




            String line1 = listFromFile1.get(indexLine);
            int last1 = line1.length()-1;
            char ch1 = line1.charAt(last1);

            String line2 = listFromFile2.get(counter);
            int last2 = line2.length()-1;
            char ch2 = line2.charAt(last2);

            System.out.println(line1 + " " + line2);
            System.out.println(last1 + " " + last2 + " index poslednego elem");
            System.out.println(ch1 + " " + ch2);
            System.out.println(Integer.parseInt(Character.toString(ch1)) + " + " + Integer.parseInt(Character.toString(ch2)));
            //если строки с № в каждом файле равны то ставим SAME
            if (Character.toString(ch1).equals(Character.toString(ch2))) {
                lines.add(new LineItem(Type.SAME, line1));
            }
//            else if (!(Character.toString(ch1).equals(Character.toString(ch2)))){
            else if (Integer.parseInt(Character.toString(ch1)) < Integer.parseInt(Character.toString(ch2))){
                lines.add(new LineItem(Type.REMOVED, line1));
//                indexLine--;
                counter--;
            }
            else if (Integer.parseInt(Character.toString(ch1)) > Integer.parseInt(Character.toString(ch2))){
                lines.add(new LineItem(Type.ADDED, line2));
                indexLine--;
            }
            //специальное условие для конца массивов
            if ((counter==listFromFile2.size()-1)&&indexLine<listFromFile1.size()) counter--;
//            if (counter<listFromFile2.size()&&(indexLine==listFromFile1.size()-1)) indexLine--;
            System.out.println("counter = " + counter + " list2size = " + listFromFile2.size());
            System.out.println("indexLine = " + indexLine + " list1size-1 = " + (listFromFile1.size()-1));



            indexLine++;
            counter++;
        }
        //Users/a1/Desktop/file1.txt
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i).type + " " + lines.get(i).line);

        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }



        //решение работает но не мое(((
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader file1Reader = new BufferedReader(new FileReader(reader.readLine()));
//        BufferedReader file2Reader = new BufferedReader(new FileReader(reader.readLine()));
//        reader.close();
//
//        while (file1Reader.ready()) {
//            file1Lines.add(file1Reader.readLine());
//        }
//        file1Reader.close();
//
//        while (file2Reader.ready()) {
//            file2Lines.add(file2Reader.readLine());
//        }
//        file2Reader.close();
//
//        int i1 = 0, i2 = 0;
//        boolean list1Empty = false;
//        boolean list2Empty = false;
//
//        while (true) {
//            if (i1 >= file1Lines.size()) {
//                list1Empty = true;
//            }
//            if (i2 >= file2Lines.size()) {
//                list2Empty = true;
//            }
//
//            //Only 1st list is empty.
//            if (list1Empty && !list2Empty) {
//                if (lines.get(lines.size() - 1).type.equals(Type.SAME)) {
//                    lines.add(new LineItem(Type.ADDED, file2Lines.get(i2)));
//                    break;
//                } else {
//                    return;
//                }
//            }
//            //Only 2nd list is empty.
//            if (list2Empty && !list1Empty) {
//                if (lines.get(lines.size() - 1).type.equals(Type.SAME)) {
//                    lines.add(new LineItem(Type.REMOVED, file1Lines.get(i1)));
//                    break;
//                } else {
//                    return;
//                }
//            }
//            //Both lists are empty.
//            if (list1Empty) {
//                break;
//            }
//
//            //if SAME
//            if (file1Lines.get(i1).equals(file2Lines.get(i2))) {
//                lines.add(new LineItem(Type.SAME, file1Lines.get(i1)));
//
//                if (i1 < file1Lines.size()) {
//                    i1++;
//                } else {
//                    list1Empty = true;
//                }
//
//                if (i2 < file2Lines.size()) {
//                    i2++;
//                } else {
//                    list2Empty = true;
//                }
//            }
//
//            //if not SAME
//            else //noinspection ConstantConditions
//                if (!list1Empty && !list2Empty) {
//                    //if ADD
//                    if ((i2 + 1 < file2Lines.size()) && file1Lines.get(i1).equals(file2Lines.get(i2 + 1))) {
//                        lines.add(new LineItem(Type.ADDED, file2Lines.get(i2)));
//                        lines.add(new LineItem(Type.SAME, file1Lines.get(i1)));
//
//                        if (i1 < file1Lines.size()) {
//                            i1++;
//                        } else {
//                            list1Empty = true;
//                        }
//
//                        if (i2 < file2Lines.size()) {
//                            i2++;
//                        } else {
//                            list2Empty = true;
//                        }
//
//                        if (i2 < file2Lines.size()) {
//                            i2++;
//                        } else {
//                            list2Empty = true;
//                        }
//                    }
//                    //if REMOVE
//                    else if ((i1 + 1 < file1Lines.size()) && file2Lines.get(i2)
//                            .equals(file1Lines.get(i1 + 1))) {
//                        lines.add(new LineItem(Type.REMOVED, file1Lines.get(i1)));
//                        lines.add(new LineItem(Type.SAME, file2Lines.get(i2)));
//
//                        if (i1 < file1Lines.size()) {
//                            i1++;
//                        } else {
//                            list1Empty = true;
//                        }
//
//                        if (i1 < file1Lines.size()) {
//                            i1++;
//                        } else {
//                            list1Empty = true;
//                        }
//
//                        if (i2 < file2Lines.size()) {
//                            i2++;
//                        } else {
//                            list2Empty = true;
//                        }
//                    }
//                }
//        }
//
//        for (LineItem line : lines) {
//            System.out.printf("%s %s%n", line.type, line.line);
//        }
//    }


//    public enum Type {
//        ADDED,        //added new line
//        REMOVED,      //removed line
//        SAME          //no changes
//    }


}
