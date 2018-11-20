package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

//import com.javarush.task.task15.task1525.Statics;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String forFile1 = reader.readLine();
        String forFile2 = reader.readLine();
        reader.close();
        FileInputStream inStream = new FileInputStream(forFile1);
        String s = "";
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (inStream.available() > 0)
        {
            char elem = ((char)inStream.read());
            s += elem;
        }
        inStream.close();
        String delimiter = " ";
        String strArray[] = s.split(delimiter);

        int[] strings = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            float s1 = Float.parseFloat(strArray[i]);
            int res = Math.round(s1);
//            System.out.println(s1);
//            System.out.println(res);
            strings[i] = res;
        }

//        for (int i = 0; i < strings.length; i++) {
//            System.out.println(strings[i]);
//
//        }


        FileOutputStream file1outStream = new FileOutputStream(forFile2);
        for (int i = 0; i < strings.length; i++) {
            file1outStream.write(Integer.toString(strings[i]).getBytes());
            file1outStream.write(delimiter.getBytes());
        }
        file1outStream.close();


//        static {
//            try{
//                InputStream inStream = new FileInputStream(Statics.FILE_NAME);
//                String s = "";
//                ArrayList<Integer> arrayList = new ArrayList<>();
//                while (inStream.available() > 0)
//                {
//                    char elem = ((char)inStream.read());
//                    s += elem;
//                }
//                String delimiter = "\n";
//                String strArray[] = s.split(delimiter);
//                for (int i = 0; i < strArray.length; i++) {
//                    String s1 = strArray[i];
//
//                    lines.add(s1);
//                }
//            } catch (FileNotFoundException e){System.out.println("File not found");}
//            catch (IOException e) {e.printStackTrace();}
//        }
    }
}
