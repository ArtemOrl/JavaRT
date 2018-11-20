package com.javarush.task.task05.task0512;

/* 
Создать класс Circle
*/

public class Circle {

    int centerX, centerY, radius, width, color;


    public void initialize(int circleX, int circleY, int radius){
        this.centerX = circleX;
        this.centerY = circleY;
        this.radius = radius;
//        width =10;
//        color = 1;
    }

    public void initialize(int circleX, int circleY, int radius, int width){
        this.centerX = circleX;
        this.centerY = circleY;
        this.radius = radius;
        this.width =width;
//        color = 2;
    }

    public void initialize(int circleX, int circleY, int radius, int width, int color){
        this.centerX = circleX;
        this.centerY = circleY;
        this.radius = radius;
        this.width = width;
        this.color = color;
    }
    public static void main(String[] args) {

    }
}
