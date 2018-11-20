package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;


        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();

//        String res = result.replaceAll("\\D", "");


        String[] arr = result.split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[2]);
        int c = 0;
        if (arr[1].equals("+"))
        {
            c = a + b;
        } else if (arr[1].equals("-"))
        {
            c = a - b;
        } else if (arr[1].equals("*"))
        {
            c = a * b;
        }

        //Возвращаем все как было
        System.setOut(consoleStream);

//        //разворачиваем строку
//        StringBuilder stringBuilder = new StringBuilder(result);
//        stringBuilder.reverse();
//        String reverseString = stringBuilder.toString();

        //выводим ее в консоль
//        System.out.println(res);
        System.out.println(a + " " + arr[1] + " " + b + " = " + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

