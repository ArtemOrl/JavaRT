package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException{
        //start here - начни тут -c Petrov м 12/11/1990 Suka ж 11/11/1989
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        try{
//        if (args[0].equals("-c")) {
            switch (args[0]){

                case "-c": synchronized (allPeople){
            Person person;
            for (int i = 1; i <= args.length-3; i+=3){
                if (args[i+1].equals("м")) {
                    person = Person.createMale(args[i], dateFormat.parse(args[i+2]));
                } else {
                    person = Person.createFemale(args[i], dateFormat.parse(args[i+2]));
                }
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }

            break;
            //-u 0 Petrov м 12/11/1990 1 Suka ж 11/11/1989
        }case "-u":synchronized (allPeople){//else if (args[0].equals("-u")) {
            for (int i = 1; i <= args.length-4; i+=4){
                allPeople.get(Integer.parseInt(args[i])).setName(args[i+1]);
                if (args[i+2].equals("м"))
                    allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
                else if (args[i+2].equals("ж"))
                    allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);
                allPeople.get(Integer.parseInt(args[i])).setBirthDay(dateFormat.parse(args[i+3]));
            }



            break;
            //-d 0 1
        }case "-d":synchronized (allPeople){//else if (args[0].equals("-d")) {
            for (int i = 1; i < args.length; i+=1){
                allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
                allPeople.get(Integer.parseInt(args[i])).setName(null);
                allPeople.get(Integer.parseInt(args[i])).setSex(null);
            }

            break;
            //i 0 1
        }case "-i": synchronized (allPeople){//else if (args[0].equals("-i")) {
                    for (int i = 1; i < args.length; i += 1) {
                        dateFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
                        System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " " +
                                (allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.MALE) ? "м" : "ж") + " " +
                                dateFormat.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay()));
                    }
                }
        }
    } catch (ParseException e) {
        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
    }
    }
}
