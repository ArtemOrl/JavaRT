package com.javarush.task.task09.task0928;

import java.io.*;

/* 
Код не компилится…
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        String sourceFileName = reader.readLine();
//        String destinationFileName = reader.readLine();

        FileInputStream fileInputStream = null;
        String sourceFileName = null;
        while (true)
        {
            try
            {
                sourceFileName = reader.readLine();
                fileInputStream = new FileInputStream(sourceFileName);
                break;
            }
            catch (FileNotFoundException e)
            {
                System.out.println("Файл не существует");
            }
        }

        String destinationFileName = reader.readLine();
        FileOutputStream fileOutputStream = new FileOutputStream(destinationFileName);

        while (fileInputStream.available() > 0)
        {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}
