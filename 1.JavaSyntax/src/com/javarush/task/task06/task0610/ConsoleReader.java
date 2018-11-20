package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String a = buf.readLine();
        return a;

    }

    public static int readInt() throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String a = buf.readLine();
        int b = Integer.parseInt(a);
        return b;
    }

    public static double readDouble() throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String a = buf.readLine();
        double b = Double.parseDouble(a);
        return b;
    }

    public static boolean readBoolean() throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String a = buf.readLine();
        boolean b = Boolean.parseBoolean(a);
        return b;
    }

    public static void main(String[] args) {

    }
}
