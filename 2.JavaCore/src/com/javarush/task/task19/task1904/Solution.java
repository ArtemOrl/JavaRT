package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(new Scanner("Иванов Иван Иванович 31 12 1950"));
        System.out.println(personScannerAdapter.read());
        personScannerAdapter.close();
    }

    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner fileScanner;
        public PersonScannerAdapter (Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() {


            Person person = null;
            if (fileScanner.hasNext()){
                String s = fileScanner.nextLine();
                String[] parts = s.split(" ");

                String lastName = parts[0];
                String firstName = parts[1];
                String middleName = parts[2];

                Calendar calendar = new GregorianCalendar(Integer.parseInt(parts[5]),
                        Integer.parseInt(parts[4])-1,
                        Integer.parseInt(parts[3]));

                person = new Person(firstName, middleName, lastName, calendar.getTime());
            }
            return person;
        }

        @Override
        public void close() {

            fileScanner.close();
        }
    }
}
