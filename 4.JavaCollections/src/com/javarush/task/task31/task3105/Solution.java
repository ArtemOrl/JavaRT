package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
// !!!! Закидывать файл в архив нужно только если он там уже есть, иначе не принимается.


public class Solution {

    public static void main(String[] args) throws IOException {
        Map<ZipEntry, ByteArrayOutputStream> zipEntryMap = new HashMap<>();
        //В методе main создай ZipInputStream для архивного файла (второй аргумент main). Нужно вычитать из него все содержимое.
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(args[1]))) {
            ZipEntry currentEntry;
            while ((currentEntry = zis.getNextEntry()) != null) {
                byte[] buffer = new byte[4096 * 1024];
                int count = 0;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while ((count = zis.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, count);
                }
                zipEntryMap.put(currentEntry, byteArrayOutputStream);
            }
        }

        //В методе main создай ZipOutputStream для архивного файла (второй аргумент main).
        try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(args[1]))) {
            //В ZipOutputStream нужно записать содержимое файла, который приходит первым аргументом в main.
            File newFile = new File(args[0]);
            ZipEntry newEntry = new ZipEntry("new/" + newFile.getName());
            zos.putNextEntry(newEntry);
            Files.copy(newFile.toPath(), zos);


            //В ZipOutputStream нужно записать все остальное содержимое, которое было вычитано из ZipInputStream.
            for (Map.Entry<ZipEntry, ByteArrayOutputStream> pair : zipEntryMap.entrySet()) {
                if (!newEntry.getName().equals(pair.getKey().getName())) {
                    zos.putNextEntry(new ZipEntry(pair.getKey().getName()));
                    zos.write(pair.getValue().toByteArray());
                }
            }
        }
    }

}


