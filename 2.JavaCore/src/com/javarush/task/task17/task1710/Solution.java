package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException {
//        //start here - начни тут
//
////        for (int i = 0; i < allPeople.size(); i++) {
////            Person person = allPeople.get(i);
////            int id = i;
////            System.out.println(person.getName() + " "+ person.getSex()+ " " + person.getBirthDay() + " " + id);
////        }
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String vvod = reader.readLine();
//        char elem[] = vvod.toCharArray();
//        String delimiter = " ";
//        String strArray[] = vvod.split(delimiter);
////        for (int i = 0; i < strArray.length; i++) {
////            String s = strArray[i];
////            System.out.print(s + " ");
////        }
//
//        String analyze = Character.toString(elem[1]);
//
//        if (analyze.equals("c")){
//            if (strArray[2].equals("м")){
//                allPeople.add(Person.createMale(strArray[1], new Date(strArray[3])));
//                System.out.println(allPeople.size()-1);
//                for (int i = 0; i < allPeople.size(); i++) {
//                    Person person = allPeople.get(i);
//                    int id = i;
//                    System.out.println(person.getName() + " "+ person.getSex()+ " " + person.getBirthDay() + " " + id);
//                }
//            }
//            else if (strArray[2].equals("ж")){
//                allPeople.add(Person.createFemale(strArray[1], new Date(strArray[3])));
//                int g = allPeople.size()-1;
//                System.out.println(g);
//                for (int i = 0; i < allPeople.size(); i++) {
//                    Person person = allPeople.get(i);
//                    int id = i;
//                    System.out.println(person.getName() + " "+ person.getSex()+ " " + person.getBirthDay() + " " + id);
//                }
//            }
//        }
//        if (analyze.equals("u")){
//            if (strArray[3].equals("м")){
//                allPeople.set(Integer.parseInt(strArray[1]), Person.createMale(strArray[2], new Date(strArray[4])));
//                for (int i = 0; i < allPeople.size(); i++) {
//                    Person person = allPeople.get(i);
//                    int id = i;
//                    System.out.println(person.getName() + " "+ person.getSex()+ " " + person.getBirthDay() + " " + id);
//                }
//            }
//            else if (strArray[3].equals("ж")){
//                allPeople.set(Integer.parseInt(strArray[1]), Person.createFemale(strArray[2], new Date(strArray[4])));
//                for (int i = 0; i < allPeople.size(); i++) {
//                    Person person = allPeople.get(i);
//                    int id = i;
//                    System.out.println(person.getName() + " "+ person.getSex()+ " " + person.getBirthDay() + " " + id);
//                }
//            }
//        }
//        if (analyze.equals("d")){
//            allPeople.set(Integer.parseInt(strArray[1]), Person.createMale(null,  null));
//            Person person = allPeople.get(Integer.parseInt(strArray[1]));
//            person.setSex(null);
//            for (int i = 0; i < allPeople.size(); i++) {
//                person = allPeople.get(i);
//                int id = i;
//                System.out.println(person.getName() + " "+ person.getSex()+ " " + person.getBirthDay() + " " + id);
//            }
//        }
//        if (analyze.equals("i")){
//            Person person = allPeople.get(Integer.parseInt(strArray[1]));
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
//            System.out.println(person.getName() + " " + person.getSex() + " " + simpleDateFormat.format(person.getBirthDay()));
//        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

            if (args[0].equals("-c")) {
                Person person;
                if (args[2].equals("м")) {
                    person = Person.createMale(args[1], dateFormat.parse(args[3]));
                } else {
                    person = Person.createFemale(args[1], dateFormat.parse(args[3]));
                }
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            } else if (args[0].equals("-u")) {
                allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                if (args[3].equals("м"))
                    allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
                else if (args[3].equals("ж"))
                    allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
                allPeople.get(Integer.parseInt(args[1])).setBirthDay(dateFormat.parse(args[4]));
            } else if (args[0].equals("-d")) {
                allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
            } else if (args[0].equals("-i")) {
                dateFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " " +
                        (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE) ? "м" : "ж") + " " +
                        dateFormat.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
            }
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
