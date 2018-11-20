package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateTest {
    public static void main(String[] args) throws IOException, ParseException {

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String s = reader.readLine();
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        String dd = "12 1 1999";
        Date d= format.parse("12 12 1999");
        System.out.println(d);
    }
}
