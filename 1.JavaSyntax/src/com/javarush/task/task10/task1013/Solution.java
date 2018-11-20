package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name, address, analen;
        private int age;
        private boolean sex;
        private int sisky;
        //, piska, jopa, hui


        public Human() {
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public Human(String name, String address, String analen) {
            this.name = name;
            this.address = address;
            this.analen = analen;
        }

        public Human(String name, String address, String analen, int age) {
            this.name = name;
            this.address = address;
            this.analen = analen;
            this.age = age;
        }

        public Human(String name, String address, String analen, int age, boolean sex) {
            this.name = name;
            this.address = address;
            this.analen = analen;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, String address, String analen, int age, boolean sex, int sisky) {
            this.name = name;
            this.address = address;
            this.analen = analen;
            this.age = age;
            this.sex = sex;
            this.sisky = sisky;
        }

        public Human(String name, String address, String analen, int age, boolean sex, int sisky, int piska) {
            this.name = name;
            this.address = address;
            this.analen = analen;
            this.age = age;
            this.sex = sex;
            this.sisky = sisky;
            this.sisky = sisky;
        }

        public Human(String name, String address, String analen, int age, boolean sex, int sisky, int piska, int jopa) {
            this.name = name;
            this.address = address;
            this.analen = analen;
            this.age = age;
            this.sex = sex;
            this.sisky = sisky;
            this.sisky = sisky;
            this.sisky = sisky;
        }

        public Human(String name, String address, String analen, int age, boolean sex, int sisky, int piska, int jopa, int hui) {
            this.name = name;
            this.address = address;
            this.analen = analen;
            this.age = age;
            this.sex = sex;
            this.sisky = sisky;
            this.sisky = sisky;
            this.sisky = sisky;
            this.sisky = sisky;
        }
    }
}
