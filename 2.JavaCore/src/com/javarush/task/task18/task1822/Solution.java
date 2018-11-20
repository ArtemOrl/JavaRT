package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        String forFile1 = reader.readLine();
//        FileInputStream inStream = new FileInputStream(forFile1);
//
//        int id = Integer.parseInt(args[0]);
//
//        String s = "";
//
//        ArrayList<String[]> arrayList = new ArrayList<>();
//
//        while (inStream.available() > 0)
//        {
//            char elem = ((char)inStream.read());
//            s += elem;
//        }
//        inStream.close();
//        String delimiter = "\n";
//        String file[] = s.split(delimiter);
//
//        for (int i = 0; i < file.length; i++) {
//            String s1 = file[i];
//            String delimit = " ";
//            String array[] = s1.split(delimit);
//            arrayList.add(array);
//        }
//
//        for (int i = 0; i < arrayList.size(); i++) {
//            String[] s1 = arrayList.get(i);
////            for (int j = 0; j < s1.length; j++) {
////                System.out.print( s1[j] + " ");
////
////            }
////            System.out.println();
//
//            if (Integer.parseInt(s1[0])==id) {
//
////                System.out.print(id + " ");
//                for (int j = 0; j < s1.length; j++) {
//                    System.out.print(s1[j] + " ");
//
//                }
//            }
//
//        }


        if(args.length == 0){
            throw new IllegalArgumentException();
        }


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        BufferedReader fileBufReader = new BufferedReader(fileReader);

        String res;

        while((res = fileBufReader.readLine()) != null){
            if(res.startsWith(args[0] + " ")){
                System.out.println(res);
                break;
            }
        }

        reader.close();
        fileBufReader.close();
        fileBufReader.close();
    }
}
