package com.javarush.task.task20.task2023;

/* 
Делаем правильный вывод
*/
public class Solution {
    public static void main(String[] s) {
        A a = new C();
        a.method2();
//        A b = new A();
//        b.method2();
//        b.method1();
//        A c = new B();
//        c.method1();

    }

    public static class A {
        private void method1() {
            System.out.println("A class, method1");
        }

        public void method2() {
            System.out.println("A class, method2");
            method1();
        }
    }

    public static class B extends A {
        public void method1() {
            super.method2();
            System.out.println("B class, method1");

        }

        public void method2() {
            System.out.println("B class, method2");
        }
    }

    public static class C extends B {
        public void method1() {
            System.out.println("C class, method1");
        }


        public void method2() {
            System.out.println("C class, method2");
            super.method1();
        }
    }
}
