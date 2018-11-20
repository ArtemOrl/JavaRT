package com.javarush.task.task19.task1921;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String text = "Иванов Иван Иванович 31 12 1987";
//        String text = "Вася 15 5 2013";
//        String[] tags = text.split("(?=[а-яА-я]\\p{Space}\\p{Digit})");


        //Делит текст и каждую цифру, а второй блок на случай если цифра одна
//        String[] tags = text.split("(\\p{Space})(?=\\p{Digit}\\p{Digit})|(\\p{Space})(?=\\p{Digit})");
//        String[] tags = text.split("(?=\\p{Digit}\\p{Digit}\\p{Digit}\\p{Digit}\\p{Digit})");
//        String[] tags = text.split("(?<=\\D\\p{Space})|(?<=\\d)(?=\\D)(?=\\d)");

        //Делит текст и цифры пополам
//        String[] tags = text.split("(?<=\\D\\p{Space})(?=\\d)");
        //Делит текст и цифры пополам и удаляет пробелы
        String[] tags = text.split("(?<=\\D)(?:\\p{Space})(?=\\d)");

//        String[] tags = text.split("([а-яА-я]+)(?:\\\\s?|\\\\t?)");
        for (String tag : tags) {
            System.out.println(tag);
        }









    }






}
