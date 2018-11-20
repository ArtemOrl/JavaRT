package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {

    public static List<String> listFileNames = new ArrayList<>();

    public static List<String> recursion (File dirPath) throws IOException {
        for(File file : dirPath.listFiles()){
            if(file.isFile()){
                listFileNames.add(file.getAbsolutePath());
            }else if(file.isDirectory()){
                File dirPath1 = new File(file.getAbsolutePath());
                recursion(dirPath1);
            }
        }
        return listFileNames;
    }

    public static List<String> getFileTree(String root) throws IOException {

        File path = new File(root);
        listFileNames = recursion(path);

        return listFileNames;
    }

    public static void main(String[] args) throws IOException {
        List<String> fileList = getFileTree("c:/path");
        for (String s : fileList) {
            System.out.println(s);
        }
    }

}
