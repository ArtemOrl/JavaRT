package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hippodrome {

    private static List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    static Hippodrome game;

    public void run() throws InterruptedException{
        for (int i = 1; i <= 100; i++) {

            move();
            print();
            Thread.sleep(200);

        }
    }
    public void move(){
        for (Horse horse : horses) {
            horse.move();
        }
    }
    public void print(){
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();

        }
    }

    public Horse getWinner(){


        int indexOfHorseMaxDist = 0;
        for (int i = 1; i < horses.size(); i++) {
            if (horses.get(i).getDistance() > horses.get(indexOfHorseMaxDist).getDistance())
                indexOfHorseMaxDist = i;
        }
        return horses.get(indexOfHorseMaxDist);
    }
    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
    public static void main(String[] args) throws InterruptedException {


        horses = new ArrayList<>();

        Horse horse1 = new Horse("Gyna", 3, 0);
        Horse horse2 = new Horse("Lo-Lo", 3, 0);
        Horse horse3 = new Horse("Balyna", 3, 0);


        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        game = new Hippodrome(horses);
        System.out.println(game.getHorses());

        game.run();
        game.printWinner();
    }
}
