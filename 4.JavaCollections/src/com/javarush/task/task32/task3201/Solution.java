package com.javarush.task.task32.task3201;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws Exception {
        File path = new File(args[0]);
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");

        if (number < text.length()){
            randomAccessFile.seek(number);
            randomAccessFile.write(text.getBytes());
            randomAccessFile.close();
        } else {
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(text.getBytes());
            randomAccessFile.close();
        }

//        String fileName = args[0];
//        long position = Integer.parseInt(args[1]);
//
//        String text = args[2];
//
//        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
//        position = position > file.length() ? file.length() : position;
//        file.seek(position);
//        file.write(text.getBytes());
//        file.close();

    }
}
