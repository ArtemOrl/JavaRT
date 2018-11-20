package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try{
            InputStream inStream = new FileInputStream(Statics.FILE_NAME);
            String s = "";
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (inStream.available() > 0)
            {
                char elem = ((char)inStream.read());
                s += elem;
            }
            String delimiter = "\n";
            String strArray[] = s.split(delimiter);
            for (int i = 0; i < strArray.length; i++) {
                String s1 = strArray[i];

                lines.add(s1);
            }
        } catch (FileNotFoundException e){System.out.println("File not found");}
        catch (IOException e) {e.printStackTrace();}
    }
    public static void main(String[] args) {
        System.out.println(lines);
    }
}
