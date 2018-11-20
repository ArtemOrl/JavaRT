package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

//public class FileConsoleWriter extends FileWriter{
//    private FileWriter fileWriter;
//
//
//    public FileConsoleWriter(FileDescriptor fd) {
//        super(fd);
//    }
//
//
//    public FileConsoleWriter(File file, boolean append) throws IOException {
//        super(file, append);
//    }
//
//    public FileConsoleWriter(String fileName, boolean append) throws IOException {
//        super(fileName, append);
//    }
//
//    public FileConsoleWriter(File file) throws IOException {
//        super(file);
//    }
//
//    public FileConsoleWriter(String file) throws IOException {
//        super(file);
//    }
//
//    // ************************************************ ************
//
//    public void write(int c) throws IOException {
//        System.out.print((char) c);
//        super.write(c);
//    }
//
//    public void write(String s) throws IOException {
//        write(s, 0, s.length());
//    }
//
//    public void write(char[] buf) throws IOException {
//        write(buf, 0, buf.length);
//    }
//
//    public void write(char[] buf, int x, int y) throws IOException {
//        String temp = "";
//        for(char c : buf)
//            temp += c;
//        System.out.print(temp.substring(x, y));
//        super.write(buf, x, y);
//    }
//
//    public void write(String s, int x, int y) throws IOException {
//        System.out.print(s.substring(x, y));
//        super.write(s, x, y);
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//}

public class FileConsoleWriter
{
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException
    {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        this.fileWriter = new FileWriter(fd);
    }

    public void write(int c) throws IOException
    {
        fileWriter.write(c);
        System.out.println(c);
    }

    public void write(char[] cbuf, int off, int len) throws IOException
    {
        fileWriter.write(cbuf, off, len);


        System.out.println(String.copyValueOf(cbuf).substring(off, off + len));
    }

    public void write(String str, int off, int len) throws IOException
    {
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off, off + len));
    }

    public void close() throws IOException
    {
        fileWriter.close();
    }

    public void write(char[] cbuf) throws IOException
    {
        fileWriter.write(cbuf);
        System.out.println(String.valueOf(cbuf));
    }

    public void write(String str) throws IOException
    {
        fileWriter.write(str);
        System.out.println(str);
    }

    public static void main(String[] args) throws Exception
    {
//        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter(new BufferedReader(new InputStreamReader(System.in)).readLine());
//        fileConsoleWriter.write("12345", 1, 3);
//        fileConsoleWriter.close();
    }

}
