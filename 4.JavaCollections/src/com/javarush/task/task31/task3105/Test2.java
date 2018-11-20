package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Test2 {

    private static final byte[] BUFFER = new byte[4096 * 1024];

    public static void main(String[] args) throws Exception {
        File zipFile = new File(args[1]);
        File tmpFile = File.createTempFile("zip", "tmp");

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(tmpFile));

        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[1]));
        //append new file to zipfile
        zipOutputStream.putNextEntry(new ZipEntry("new" + args[0].substring(args[0].lastIndexOf(File.separator))));
        File file = new File(args[0]);
        Files.copy(file.toPath(), zipOutputStream);

        ZipEntry entry;
        while((entry = zipInputStream.getNextEntry()) != null) {
            if(entry.getName().equals("new" + args[0].substring(args[0].lastIndexOf(File.separator))))
                continue;
            ZipEntry newEntry = new ZipEntry(entry);
            newEntry.setCompressedSize(-1);
            zipOutputStream.putNextEntry(newEntry);
            copy(zipInputStream, zipOutputStream);
            zipOutputStream.closeEntry();
        }
        zipInputStream.close();


        zipOutputStream.close();
        zipFile.delete();
        tmpFile.renameTo(zipFile);
    }

    public static void copy(InputStream input, OutputStream output) throws IOException {
        int bytesRead;
        while ((bytesRead = input.read(BUFFER))!= -1) {
            output.write(BUFFER, 0, bytesRead);
        }
    }
}
