package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
//    public static List<String> allLines = new ArrayList<String>();
//    public static List<String> forRemoveLines = new ArrayList<String>();
//
//    public static void main(String[] args) throws IOException, CorruptedDataException {
//
////        try {
////            joinData();
////        } catch (IOException exception) {exception.printStackTrace();}
//
//
//
//        joinData();
//    }
//
//    public static void joinData () throws CorruptedDataException, IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        String firstFileName = reader.readLine();
//        String secondFileName = reader.readLine();
//
//        InputStream inStream1 = new FileInputStream(firstFileName);
//        InputStream inStream2 = new FileInputStream(secondFileName);
//
//
//        String s = "";
//
//        while (inStream1.available() > 0)
//        {
//            char elem = ((char)inStream1.read());
//            s += elem;
//        }
//        String delimiter = "\n";
//        String strArray[] = s.split(delimiter);
//        for (int i = 0; i < strArray.length; i++) {
//            String s1 = strArray[i];
//
//            allLines.add(s1);
//        }
//
//        s = "";
//
//        while (inStream2.available() > 0)
//        {
//            char elem = ((char)inStream2.read());
//            s += elem;
//        }
//        delimiter = "\n";
//        String strArray1[] = s.split(delimiter);
//        for (int i = 0; i < strArray1.length; i++) {
//            String s1 = strArray1[i];
//
//            forRemoveLines.add(s1);
//        }
//
//        //Proverka est li v allLines vse stroki iz forRemoveLines
//        int sravnenie = 0;
//
//        for (int i = 0; i < forRemoveLines.size(); i++) {
//            String s1 = forRemoveLines.get(i);
//            for (int j = 0; j < allLines.size(); j++) {
//                String allLine = allLines.get(j);
//                if (s1.equals(allLine)) sravnenie+=1;
//            }
//        }
//
//
////        System.out.println(sravnenie + " sravnenie");
////        System.out.println(forRemoveLines.size() + " forRemoveLines.size()");
//
//
//        //Esli vse stroki iz forRemoveLines est' to udal'yaem ih vse iz allLines
//        if (sravnenie==forRemoveLines.size()){
//            for (int i = 0; i < forRemoveLines.size(); i++) {
//                String s1 = forRemoveLines.get(i);
//                for (int j = 0; j < allLines.size(); j++) {
//                    String allLine = allLines.get(j);
//                    if (s1.equals(allLine)) allLines.remove(allLines.get(j));
//                }
//            }
//
//
////            for (int i = 0; i < allLines.size(); i++) {
////                System.out.println(allLines.get(i) + " allLines to chto ostalos'" + i);
////            }
//
//
//        }
//
//        else {
////            for (int i = 0; i < allLines.size(); i++) {
////                allLines.remove(0);
////            }
//
//
//            allLines.clear();
////            System.out.println(allLines.size() + " allLines.size() after clear");
//
//
//
////            for (int i = 0; i < allLines.size(); i++) {
////                System.out.println(allLines.get(i));
////            }
////            for (int i = 0; i < forRemoveLines.size(); i++) {
////                System.out.println(forRemoveLines.get(i));
////            }
//            throw new CorruptedDataException();
//        }
//        inStream1.close();
//        inStream2.close();
//    }


    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException
    {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
////        String fileOne = reader.readLine();
////        String fileTwo = reader.readLine();
////
////        writeInList(fileOne,allLines);
////        writeInList(fileTwo, forRemoveLines);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();

        InputStream inStream1 = new FileInputStream(firstFileName);
        InputStream inStream2 = new FileInputStream(secondFileName);


        String s = "";

        while (inStream1.available() > 0)
        {
            char elem = ((char)inStream1.read());
            s += elem;
        }
        String delimiter = "\n";
        String strArray[] = s.split(delimiter);
        for (int i = 0; i < strArray.length; i++) {
            String s1 = strArray[i];

            allLines.add(s1);
        }

        s = "";

        while (inStream2.available() > 0)
        {
            char elem = ((char)inStream2.read());
            s += elem;
        }
        delimiter = "\n";
        String strArray1[] = s.split(delimiter);
        for (int i = 0; i < strArray1.length; i++) {
            String s1 = strArray1[i];

            forRemoveLines.add(s1);
        }
        Solution c = new Solution();
        c.joinData();
    }



    public void joinData () throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines) ) {
            allLines.removeAll(forRemoveLines)  ;
            return;
        }

        for (String s : forRemoveLines) {
            if (!allLines.contains(s)){
                allLines.clear();
                throw  new CorruptedDataException();
            }

        }
    }

    public static void writeInList(String file, List<String> list) throws FileNotFoundException
    {
        BufferedReader in = new BufferedReader(new FileReader(file));
        try{
            String s;
            while((s = in.readLine()) != null){
                String[] strings = s.split(" ");

                for (String x : strings){
                    list.add(x);

                }
            }
        }catch (Exception e){

        }


    }
}
