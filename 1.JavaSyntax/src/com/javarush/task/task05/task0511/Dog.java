package com.javarush.task.task05.task0511;

/* 
Создать класс Dog
*/

public class Dog {

    String name;
    int height;
    String color;

    public void initialize(String name){
        this.name = name;
        height = 3;
        color = "shit";
    }
    public void initialize(String name, int height){
        this.name = name;
        this.height = height;
        color = "shit1";
    }
    public void initialize(String name, int height, String color){
        this.name = name;
        this.height = height;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
