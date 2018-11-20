package com.javarush.task.task15.task1527;

import javax.print.DocFlavor;
import java.io.*;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main (String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        InputStream inStream = new FileInputStream(reader.readLine());
        String line = reader.readLine();
        String parametr;
        double value;
        char[] charArray = line.toCharArray();
        String[] stringArray = new String[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            String x = Character.toString(c);
            stringArray[i] = x;
        }

//        for (int i = 0; i < stringArray.length; i++) {
//            System.out.print(stringArray[i]);
//            if (stringArray[i].equals("?")) break;
//        }
        ArrayList<Object> list = new ArrayList<>();
        ArrayList<Object> list1 = new ArrayList<>();
        for (int i = 0; i < stringArray.length; i++) {

//            System.out.println(stringArray[i]        );
            String s = stringArray[i];
            int count = 0;
            String word = "";
            String valu = "";
            if (stringArray[i].equals("?") || stringArray[i].equals("&")) {
                for (int j = i+1; /*(stringArray[j].equals("=")||stringArray[j].equals("&"))*/; j++) {
                    String s1 = stringArray[j];
//                    System.out.println(s1);
                    if (stringArray[j].equals("=")) {
                        if (word.equals("obj")){
                            for (int k = j+1; ; k++) {
                                if (stringArray[k].equals("&")){
                                    try{
                                    value = Double.parseDouble(valu);
//                                    alert(value);
                                    list1.add(value);
                                    break;}
                                    catch (NumberFormatException e){
                                        list1.add(valu);
//                                        parametr = valu;
                                        break;
                                    }
                                }
                                String s2 = stringArray[k];
                                valu+=s2;
                                count+=1;

                            }
                        }
                        break;
                    }
                    if (stringArray[j].equals("&")) break;
                    word+=s1;
                    count+=1;
//                    System.out.println(word);
                }
                list.add(word);
//                alert(word);
            }
            i+=count;


        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");

        }
        System.out.println();
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) instanceof String) alert((String) list1.get(i));
            if (list1.get(i) instanceof Double) alert((Double) list1.get(i));

        }
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) instanceof String) alert((String) list.get(i));
//            if (list.get(i) instanceof Double) alert((Double) list.get(i));
//        }
    }






//public class Solution {
//    public static void main(String[] args) throws IOException{
//        //add your code here
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String url = br.readLine();
//        int n = url.indexOf('?');
//        String u1 = url.substring(n+1);
//        ArrayList<String> list = new ArrayList<>();
//        String value = "";
//
//        for (String temp : u1.split("&"))
//        {
//            int i = 0;
//            for (String t1 : temp.split("="))
//            {
//                if (i == 0)
//                    list.add(t1);
//                i++;
//                if (t1.contentEquals("obj")) {
//                    value = temp.substring(4);
//                }
//            }
//        }
//        for (String a : list)
//        {
//            System.out.print(a + " ");
//        }
//        System.out.println();
//
//        if (value != "")
//        {
//            try {
//                alert(Double.parseDouble(value));
//            }
//            catch (Exception e) {
//                alert(value);
//            }
//        }
//    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
