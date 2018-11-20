package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException{
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

        //Возвращаем все как было
        System.setOut(consoleStream);

//        //разворачиваем строку
//        StringBuilder stringBuilder = new StringBuilder(result);
//        stringBuilder.reverse();
//        String reverseString = stringBuilder.toString();

        //выводим ее в консоль
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String file1 = br.readLine();
        String file2 = br.readLine();


//        BufferedReader reader = new BufferedReader(new FileReader(file1));
//        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        FileOutputStream writer = new FileOutputStream(file2);
        br.close();
        writer.write(result.getBytes());
        writer.close();
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

