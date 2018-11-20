package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        ArrayList<String> names = new ArrayList<>();
//
//
//        while (true){
//            String fileName = reader.readLine();
//            if (fileName.equals("end")) break;
//            names.add(fileName);
//        }
//        reader.close();
//
////        names.add("Users/a1/Desktop/file.txt.part5");
////        names.add("Users/a1/Desktop/file.txt.part4");
////        names.add("Users/a1/Desktop/file.txt.part2");
////        names.add("Users/a1/Desktop/file.txt.part1");
////        names.add("Users/a1/Desktop/file.txt.part3");
//
//        //It works
//        Collections.sort(names);
////        for (String name : names) {
////            System.out.println(name);
////        }
//
//        Solution c = new Solution();
//        c.writeFiles(names);
//
//    }
//
//    public void writeFiles(ArrayList<String> names) throws FileNotFoundException, IOException{
//        String name = names.get(0);
//        char[] name1 = name.toCharArray();
//        ArrayList<Character> name2 = new ArrayList<>();
//        int ind = 0;
//        for (int i = name1.length-1; i >= 0; i--) {
//            char c = name1[i];
//            name2.add(c);
//        }
//        while (true){
//            if (Character.toString(name2.get(0)).equals(".")) {
//                name2.remove(0);
//                break;
//            }
//            name2.remove(0);
//
//        }
////        for (int i = 0; i < name2.size(); i++) {
////            System.out.print(name2.get(i));
////
////        }
//        ArrayList<Character> name11 = new ArrayList<>();
//        for (int i = name2.size()-1; i >= 0; i--) {
//            char c = name2.get(i);
//            name11.add(c);
//        }
//        String nameFinal = "";
//        for (int i = 0; i < name11.size(); i++) {
//            char c = name11.get(i);
//            nameFinal += c;
//
//        }
//        System.out.println(nameFinal);
//
//
//        String slash = "/";
//        String path = slash + nameFinal;
//
////        System.out.println(path);
//
//
//        File fileFinal = new File(path);
//        FileOutputStream outputStream = new FileOutputStream(fileFinal);
//        for (int i = 0; i < names.size(); i++) {
//
////            File file = new File(names.get(i));
//            FileInputStream inputStream = new FileInputStream(new File(names.get(i)));
////            FileReader fileReader = new FileReader(names.get(i));
////            BufferedReader fileBufReader = new BufferedReader(fileReader);
////            FileInputStream inStream = new FileInputStream(names.get(i));
////            BufferedReader inputStream = new BufferedReader(new InputStreamReader(inStream));
//            while (inputStream.available()>0){
//                byte[] buffer = new byte[inputStream.available()];
//                int count = inputStream.read(buffer);
//                outputStream.write(buffer, 0, count);
//            }
//            inputStream.close();
//        }
//        outputStream.close();




        //example 2
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String name;
//        Set<File> fileset = new TreeSet<>();
//        while (!(name = reader.readLine()).equals("end")) {
//            File file = new File(name);
//            fileset.add(file);
//        }
//        Iterator<File> itr = fileset.iterator();
//        String folder = itr.next().getAbsolutePath();
//        folder = folder.substring(0, folder.length() - 6);
//        FileOutputStream resultFile = new FileOutputStream(folder, true);
//        for (File file : fileset) {
//            FileInputStream in = new FileInputStream(file);
//            byte[] buffer = new byte[in.available()];
//            while (in.available() > 0) {
//                in.read(buffer);
//                resultFile.write(buffer);
//            }
//            in.close();
//        }
//        resultFile.close();

        //example 3
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String fileName;

        while (!(fileName = bufferedReader.readLine()).equals("end")) {
            list.add(fileName);
        }

        bufferedReader.close();
        Collections.sort(list);

        String[] stringArray = list.get(0).split(".part");
        String summaryFileName = stringArray[0];

        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream = new FileOutputStream(summaryFileName, true);
        byte[] buffer;

        for (String aList : list) {
            fileInputStream = new FileInputStream(aList);
            buffer = new byte[fileInputStream.available()];
            //noinspection ResultOfMethodCallIgnored
            fileInputStream.read(buffer);
            fileInputStream.close();
            fileOutputStream.write(buffer);
        }

        fileOutputStream.close();

    }



}
