package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();
        String[] endLine = result.split("\n");
        ArrayList<String> endList = new ArrayList<>();
        int counter = 1;
        int j = 0;
        for (int i = 1; i < endLine.length+1; i++) {
            endList.add(endLine[j]);
            if (counter%2==0) endList.add("JavaRush - курсы Java онлайн");
            counter++;
            j++;
        }
        result = "";
        for (int i = 0; i < endList.size(); i++) {
            result += endList.get(i);
            result += "\n";

        }
        System.setOut(consoleStream);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
