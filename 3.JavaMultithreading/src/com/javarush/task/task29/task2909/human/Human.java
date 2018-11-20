package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{
    private static int nextId = 0;

    private int id;
    protected int age;
    protected String name;


//    protected int[] size;

    public class Size {
        public int  height,
                weight;
    }

    protected Size size;


    private BloodGroup bloodGroup;

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }


    public String getPosition() {
        return "Человек";
    }

    @Override
    public void live() {

    }

//    public static final int FIRST = 1;
//    public static final int SECOND = 2;
//    public static final int THIRD = 3;
//    public static final int FOURTH = 4;


    private List<Human> children = new ArrayList<>();

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human human){
        boolean isPresent = false;
        for (int i = 0; i < children.size(); i++) {
            if ((human.equals(children.get(i)))) {
                isPresent = true;
                break;
            }
        }
        if (isPresent==false) children.add(human);
    }

    public void removeChild (Human human){
        for (int i = 0; i < children.size(); i++) {
            if ((human.equals(children.get(i)))) {
                children.remove(children.get(i));
            }
        }
    }
//    public void setBloodGroup(int code) {
//        bloodGroup = code;
//    }
//
//    public int getBloodGroup() {
//        return bloodGroup;
//    }

//    public Human(boolean isSoldier) {
//        this.isSoldier = isSoldier;
//        this.id = nextId;
//        nextId++;
//    }


    public Human(){}
    public Human(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getCourse() {
//        return course;
//    }

//    public void live() {
//        if (isSoldier)
//            fight();
//    }

    public int getId() {
        return id;
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

//    public void printSize() {
//        System.out.println("Рост: " + size[0] + " Вес: " + size[1]);
//    }
}