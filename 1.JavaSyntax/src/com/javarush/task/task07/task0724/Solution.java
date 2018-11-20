package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {

        Human grandFather1  = new Human("Ganover", true, 65);
        Human grandFather2  = new Human("Joper", true, 66);

        Human grandMother1  = new Human("Huynya", false, 72);
        Human grandMother2  = new Human("Pizda", false, 73);
        Human mother  = new Human("Suka", false, 40, grandFather1, grandMother1);
        Human father  = new Human("Ueban", false, 39, grandFather2, grandMother2);
        Human child1  = new Human("Blia", false, 17, father, mother);
        Human child2  = new Human("UebanaNah", false, 18, father, mother);
        Human child3  = new Human("Soska", false, 19, father, mother);

        System.out.println(grandFather1.toString());
        System.out.println(grandFather2.toString());
        System.out.println(grandMother1.toString());
        System.out.println(grandMother2.toString());
        System.out.println(mother.toString());
        System.out.println(father.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());




    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















