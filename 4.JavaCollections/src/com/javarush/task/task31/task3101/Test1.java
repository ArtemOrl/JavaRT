package com.javarush.task.task31.task3101;

public class Test1 {
    public class Sup {

        Sup() {

            System.out.println("Super default constructor");

        }



        Sup(int i) {

            System.out.println("Super(int) constructor");

        }

    }



    public class Sub extends Test1.Sup {

        Sub() {

            System.out.println("Sub default constructor");

        }



        Sub(String s) {

            System.out.println("Sub(String) constructor");

        }



        Sub(Object o) {

            this("");

            System.out.println("Sub(Object) constructor");

        }



        Sub(int i) {

            super(i);

            System.out.println("Sub(int) constructor");

        }

    }



    public static void main(String[] args) {

        new Test1().new Sub(new Object());

    }
}
