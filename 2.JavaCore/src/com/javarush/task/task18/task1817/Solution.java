package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream(args[0]);
        String s = "";



//        ArrayList<Integer> list = new ArrayList<>();
        while (file.available() > 0)
        {
            char elem = ((char)file.read());
            s += elem;
//            int data = file.read();
//            list.add(data);
        }
        file.close();
        char[] chars = s.toCharArray();
        int countAll = chars.length;

//        System.out.println(countAll + " countAll");
        int count32 = 0;
        for (int i = 0; i < chars.length; i++) {
            String aString = Character.toString(chars[i]);

            if (aString.equals(" ")) count32++;
        }

//        System.out.println(count32 + " count32");
        double result = (count32*1.0/countAll*1.0)*100.0;
//        System.out.println(result);
        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(result);
        System.out.println(format);
    }
}
