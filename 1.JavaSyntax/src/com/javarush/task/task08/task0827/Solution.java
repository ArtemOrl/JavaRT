package com.javarush.task.task08.task0827;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.*;
import java.util.Date;
import java.util.*;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 21 2013"));
    }

    public static boolean isDateOdd(String date) {
//        Date s = new Date(date);
//
//        Date w = new Date();
//        w.setYear(s.getYear());
//        w.setMonth(0);
//        w.setDate(0); //Не забудьте учесть первый день года.
//
//        int r = s.getDay()-w.getDay();
//
//        if (r % 2 != 0) return true;
//        else return false;


        Date yearStartDate = new Date(date); // получили первое число переданного года
        int year = yearStartDate.getYear();
        yearStartDate.setHours(0);
        yearStartDate.setMinutes(0);
        yearStartDate.setSeconds(0);

        yearStartDate.setDate(1);      // первое число
        yearStartDate.setMonth(0);     // месяц январь, нумерация для месяцев 0-11
        yearStartDate.setYear(year);

        Date yearGetDate = new Date(date); // получили переданную дату
        yearGetDate.setHours(0);
        yearGetDate.setMinutes(0);
        yearGetDate.setSeconds(0);

        long msTimeDistance = yearGetDate.getTime() - yearStartDate.getTime();
        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках

        //System.out.println(yearStartDate);
        //System.out.println(yearGetDate);
        int dayCount = (int) (msTimeDistance/msDay); //количество целых дней
        //System.out.println("Days from start of year: " + dayCount);

        return (dayCount % 2 == 0);
    }
}
