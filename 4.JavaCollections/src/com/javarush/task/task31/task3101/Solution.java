package com.javarush.task.task31.task3101;

import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
//public class Solution {
//
//    private static List<File> fileList = new ArrayList<>();
//    public static void main(String[] args) throws IOException {
//
//        File path = new File(args[0]);
//        String resultFileAbsolutePath = args[1];
//
//        scanDirectories(path);
//
//        Collections.sort(fileList, new Comparator<File>() {
//            @Override
//            public int compare(File o1, File o2) {
//                String fileName1 = o1.getName();
//                String fileName2 = o2.getName();
//                return fileName1.compareTo(fileName2);
//            }
//        });
//
//        fileList.remove(new File(resultFileAbsolutePath));
//        File resFile = new File(resultFileAbsolutePath);
//        File newFile = new File(path + "/allFilesContent.txt");
//        if(FileUtils.isExist(resFile)){
//            FileUtils.renameFile(resFile, newFile);
//        }else{
//            System.out.println("Файла для переименования не сущевствует.");
//        }
////        File resFile = new File(resultFileAbsolutePath);
////        String nnn = "/Users/a1/Desktop/allFilesContent.txt";
////        File newFile1 = new File(nnn);
////        System.out.println(newFile1.toString());
//
//
////        resFile.renameTo(newFile1);
//
////        FileUtils.renameFile(resFile, newFile1);
////        System.out.println(resFile);
//
////        Path resFile = Paths.get(resultFileAbsolutePath);
////        Path renamedResFile = Files.move(resFile, resFile.resolveSibling("allFilesContent.txt"));
////
////
////        BufferedWriter writer = new BufferedWriter(new FileWriter(renamedResFile.toFile()));
//        BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
//
//        for (File file : fileList) {
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//
//            while (reader.ready()){
//                writer.write(reader.readLine());
//                writer.newLine();
//            }
//            reader.close();
//        }
//        writer.close();
//
//    }
//
//    public static void scanDirectories (File path){
//        for (File file : path.listFiles()) {
//            if (file.isDirectory()){
//                if (file.listFiles().length != 0){
//                    scanDirectories(file);
//                }
//                else file.delete();
//            }
//            else {
//                if (file.length() > 50){
//                    file.delete();
//                }
//                else  fileList.add(file);
//            }
//        }
//    }
//}

public class Solution {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        String resultFileAbsolutePath = args[1];

        ArrayList<String> absolutePaths = new ArrayList<>();

        File directory = new File(path);
        File resultFile = new File(resultFileAbsolutePath);

        String renamedFilePath = resultFile.getParent() + "\\" + "allFilesContent.txt";
        File renamedFile = new File(renamedFilePath);

        if (FileUtils.isExist(resultFile))
            FileUtils.renameFile(resultFile, renamedFile);

        FileOutputStream outputStream = new FileOutputStream(renamedFile);

        for (File file : directory.listFiles()) {
//            if (FileUtils.isExist(file)) {
                if (file.isFile()) {
                    if (file.length() <= 50) absolutePaths.add(file.getAbsolutePath());
                }
                if (file.isDirectory()) copyingFileFromDirectiry(file, absolutePaths);
//            }
        }

        Collections.sort(absolutePaths, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                File f1 = new File(o1);
                File f2 = new File(o2);
                return f1.getName().compareToIgnoreCase(f2.getName());
            }
        });

        for (String filePath : absolutePaths) {
            FileInputStream inputStream = new FileInputStream(new File(filePath));

            while (inputStream.available() > 0) {
                byte[] buffer = new byte[inputStream.available()];
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.write("\n".getBytes());
            inputStream.close();
        }

        outputStream.close();
    }


    public static void copyingFileFromDirectiry(File directory, ArrayList<String> absolutePaths) {
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                if (file.length() <= 50) absolutePaths.add(file.getAbsolutePath());
            }
            if (file.isDirectory()) copyingFileFromDirectiry(file, absolutePaths);
        }
    }

}
