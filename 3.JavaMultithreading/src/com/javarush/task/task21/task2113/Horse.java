package com.javarush.task.task21.task2113;

import java.util.List;

public class Horse {

    String name;
    double speed, distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move(){

        distance += speed * Math.random();
    }
    public void print(){
        int tochki = (int)distance;
        for (int i = 0; i < tochki; i++) {
            System.out.print(".");
        }
        System.out.print(name);
        System.out.println();
    }
}
