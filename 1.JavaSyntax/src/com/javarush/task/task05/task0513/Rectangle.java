package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {

    int top, left, width, height;

    public void initialize(int top, int left, int width, int height){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public void initialize(int top, int left){
        this.top = top;
        this.left = left;
        width = 0;
        height = 0;
    }

    public void initialize(int top, int left, int width){
        this.top = top;
        this.left = left;
        this.width = width;
        height = width;
    }

    public void initialize(int width){
        top = 0;
        left = 0;
        this.width = width;
        height = width;
    }

    public static void main(String[] args) {

    }
}
