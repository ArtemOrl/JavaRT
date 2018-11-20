package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
//        Man man1 = new Man();
//        man1.name = "Vasya";
//        man1.age = 18;
//        man1.address = "Jopa";
//        System.out.println(man1.name + " " + man1.age + " " + man1.address);
//
//
//        Man man2 = new Man();
//        man2.name = "Kolya";
//        man2.age = 18;
//        man2.address = "Jopa";
//        System.out.println(man2.name + " " + man2.age + " " + man2.address);
//
//        Woman woman1 = new Woman();
//
//        woman1.name = "Sveta";
//        woman1.age = 18;
//        woman1.address = "Ebenya";
//
//        System.out.println(woman1.name + " " + woman1.age + " " + woman1.address);
//
//        Woman woman2 = new Woman();
//
//        woman2.name = "Polya";
//        woman2.age = 18;
//        woman2.address = "Ebenya";
//
//        System.out.println(woman2.name + " " + woman2.age + " " + woman2.address);

        Man man1 = new Man("Vasya", 25, "Wallstr");
        Man man2 = new Man("Petro", 48, "Sunbichstr");
        Woman woman1 = new Woman ("Lena", 45, "Braitonbeach");
        Woman woman2 = new Woman ("Olya", 18, "Comunity");

        System.out.println (man1.name + " " + man1.age + " " + man1.address);
        System.out.println (man2.name + " " + man2.age + " " + man2.address);
        System.out.println (woman1.name + " " + woman1.age + " " + woman1.address);
        System.out.println (woman2.name + " " + woman2.age + " " + woman2.address);
    }

    public static class Man{
        String name;
        int age;
        String address;

        public Man() {
        }

        public Man(String name) {
            this.name = name;
        }

        public Man(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    public static class Woman{
        String name;
        int age;
        String address;

        public Woman() {
        }

        public Woman(String name) {
            this.name = name;
        }

        public Woman(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
}
