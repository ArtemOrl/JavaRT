package com.javarush.task.task03.task0307;

/* 
Привет Starcraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        for (int z = 1; z <= 10; z++){
            Zerg zerg = new Zerg();
            zerg.name = "Zerg "+ z;
        }
        for (int p = 1; p<=5; p++){
            Protoss protoss = new Protoss();
            protoss.name = "Protoss" + p;
        }
        for (int t = 1; t<=12; t++){
            Terran terran = new Terran();
            terran.name = "Terran " + t;
        }

    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
