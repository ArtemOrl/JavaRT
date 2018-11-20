package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Human child1 = new Human("child1",15,true);
        Human child2 = new Human("child2",10,false);
        Human child3 = new Human("child3",5,true);

        Human father = new Human("father",45,true, child1,child2,child3);
        Human mother = new Human("mother",40,false, child1,child2,child3);

        Human grandfather1 = new Human("grandfather1",70,true, father);
        Human grandmother1 = new Human("grandmother1",65,false, father);

        Human grandfather2 = new Human("grandfather2",75,true,mother);
        Human grandmother2 = new Human("grandmother2",60,false,mother);


        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());

        System.out.println(father.toString());
        System.out.println(mother.toString());

        System.out.println(grandfather1.toString());
        System.out.println(grandmother1.toString());
        System.out.println(grandfather2.toString());
        System.out.println(grandmother2.toString());

    }

    public static class Human {
        String name;
        int age;
        boolean sex;
        ArrayList<Human> children;

        public Human(String name, int age, boolean sex, Human... children) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = new ArrayList<Human>();

            if (children != null) for (Human people : children) this.children.add(people);
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
