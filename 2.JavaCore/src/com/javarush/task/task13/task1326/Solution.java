package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

//import com.oracle.tools.packager.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        InputStream inStream = new FileInputStream(reader.readLine());

//        int[] array = null;
//        try (BufferedReader in = new BufferedReader(new FileReader(reader.readLine())))

//        try(inStream)
//        {
//            array = inStream.lines().mapToInt(Integer::parseInt).toArray();
//        }
//        catch (IOException | NumberFormatException e)
//        {
//            e.printStackTrace();
//        }

//        DataInputStream data = new DataInputStream(inStream);

        String s = "";
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (inStream.available() > 0)
        {

//            String result = IOUtils.toString(inStream, StandardCharsets.UTF_8);
            char elem = ((char)inStream.read());

            s += elem;
//            if (elem % 2 == 0) arrayList.add(elem);

        }
//        System.out.print(s);
//        char[] g = s.toCharArray();
//
//        for (char c : g) {
//            System.out.print(c);
//        }
        String delimiter = "\n";
        String strArray[] = s.split(delimiter);
//        for (int i = 0; i < strArray.length; i++) {
//            System.out.print(strArray[i]);
//
//        }

//        System.out.println(strArray[2]);
        for (int i = 0; i < strArray.length; i++) {
            String s1 = strArray[i];
            Integer s2 = Integer.parseInt(s1);
            arrayList.add(s2);
        }
//        for (Integer integer : arrayList) {
//            System.out.println(integer);
//        }

        Integer []array = new Integer[arrayList.size()];
        arrayList.toArray(array);
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int i1 = array[i];
            if (i1%2==0) arrayList1.add(i1);
        }
        Collections.sort(arrayList1);
        for (Integer integer : arrayList1) {
            System.out.println(integer);

        }
        inStream.close();
    }
}
