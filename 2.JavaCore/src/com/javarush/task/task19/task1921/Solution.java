package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException{

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        while (fileReader.ready()) {
            String s = fileReader.readLine();
            String[] person = s.split("(?<=\\D)(?:\\p{Space})(?=\\d)");
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
            Date date = format.parse(person[1]);

//            System.out.println(date);
            PEOPLE.add(new Person(person[0], date));
        }
        fileReader.close();
        for (int i = 0; i < PEOPLE.size(); i++) {
            String name = PEOPLE.get(i).getName();
            System.out.println(name);
        }
    }
}
