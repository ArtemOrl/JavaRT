package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {

        if (this.strength>anotherCat.strength){
            return true;


        }else return false;
    }

    public static void main(String[] args) {

        Cat cat1 = new Cat();
        cat1.name = "Suka";
        cat1.age = 2;
        cat1.weight = 20;
        cat1.strength = 10;

        Cat cat2 = new Cat();
        cat1.name = "Pizdec";
        cat1.age = 3;
        cat1.weight = 15;
        cat1.strength = 15;

        cat1.fight(cat2);
    }
}
