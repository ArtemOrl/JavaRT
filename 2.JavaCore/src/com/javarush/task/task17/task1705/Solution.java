package com.javarush.task.task17.task1705;

import java.util.ArrayList;
import java.util.List;

/* 
Сад-огород
*/

public class Solution {


    public static void main(String[] args) {

    }


    public static class Garden {

        public final List<String> fruits = new ArrayList<String>();
        public final List<String> vegetables = new ArrayList<String>();

        public synchronized void addFruit(int index, String fruit){
            System.out.println("Сейчас будет добавлена заметка [" + fruit + "] На позицию " + index);
            fruits.add(index, fruit);
            System.out.println("Уже добавлена заметка [" + fruit + "]");
        }
        public synchronized void removeFruit(int index){
            System.out.println("Сейчас будет удалена заметка с позиции " + index);
            fruits.remove(index);
            System.out.println("Уже удалена заметка [" +  "] с позиции " + index);
        }
        public synchronized void addVegetable(int index, String vegetable){
            System.out.println("Сейчас будет добавлена заметка [" + vegetable + "] На позицию " + index);
            vegetables.add(index, vegetable);
            System.out.println("Уже добавлена заметка [" + vegetable + "]");
        }
        public synchronized void removeVegetable(int index){
            System.out.println("Сейчас будет удалена заметка с позиции " + index);
            vegetables.remove(index);
            System.out.println("Уже удалена заметка [" +  "] с позиции " + index);
        }
    }
}
