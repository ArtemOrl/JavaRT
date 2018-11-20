package com.javarush.task.task32.task3210;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
text of file = 2019EU2416871 6657127 olga 71 6528494 max 73 3895895 liza
*/

public class Solution {
//    public static void main(String... args) throws IOException {
//        File path = new File(args[0]);
//        int number = Integer.parseInt(args[1]);
//        String text = args[2];
//
//        RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");
//        randomAccessFile.seek(number);
//
//        byte[] b = text.getBytes();
//        byte[] buf = new byte[text.length()];
//
//        randomAccessFile.read(buf, 0, buf.length);
//        boolean sovpadenie = false;
//        for (int i = 0; i < b.length; i++) {
//            if (b[i]==buf[i]) sovpadenie = true;
//            else {
//                sovpadenie = false;
//                randomAccessFile.seek(path.length());
//                randomAccessFile.write("false".getBytes());
//                randomAccessFile.close();
//                break;
//            }
//        }
//        if (sovpadenie == true){
//            randomAccessFile.seek(path.length());
//            randomAccessFile.write("true".getBytes());
//            randomAccessFile.close();
//        }
//    }

    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
            byte[] buf = new byte[text.length()];
            file.seek(number);
            file.read(buf, 0, buf.length);
            String lineFromFile = convertByteToString(buf);
            String storeToFile = lineFromFile.equals(text) ? "true" : "false";
            file.seek(file.length());
            file.write(storeToFile.getBytes());
        }
    }


    public static String convertByteToString (byte readBytes[]) {
        //return new String(readBytes, StandardCharsets.UTF_8);
        return new String(readBytes);
    }
}
