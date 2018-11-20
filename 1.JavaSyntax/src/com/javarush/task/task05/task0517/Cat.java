package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {

    String name;
    int age;
    int weight;
    String color;
    String address;

    public Cat(String name) {
        this.name = name;
        age = 10;
        weight =10;
        color = "shit";

    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        color = "shit";
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        weight = 10;
    }

    public Cat(int weight, String color) {
        this.weight = weight;
        this.color = color;
        age = 10;
    }

    public Cat(int weight, String color, String address) {
        this.weight = weight;
        this.color = color;
        this.address = address;
        age = 10;
    }

    public static void main(String[] args) {

    }
}
