package com.javarush.task.task31.task3101;

public class Test {
    private Integer m;

    private int a;

    private int s;



    public void method() {

        s = m + a;

    }



    public static void main(String[] args) {

        Test t = new Test();

        t.method();

        System.out.println(t.s);

    }
}
