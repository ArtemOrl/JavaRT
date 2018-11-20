package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {

//        String result = "";
//        try{
//
//            for (int i = 0; i < 4; i++) {
//
//                String part = string.substring(string.indexOf(" "), string.indexOf(" ", string.indexOf(" ") + 1));
//                result += part;
//
//                string = string.replaceFirst(" ", "_");
//            }
//        } catch (TooShortStringException e){
//            System.out.println("TooShortStringException");
//        }
//        return result;

        if (string == null || string.isEmpty())
            throw new TooShortStringException();

        String s[] = string.split(" ");
        if (s.length<5)
            throw new TooShortStringException();

        return s[1] + " " + s[2] + " " + s[3] + " " + s[4];
    }

    public static class TooShortStringException extends RuntimeException{
    }
}