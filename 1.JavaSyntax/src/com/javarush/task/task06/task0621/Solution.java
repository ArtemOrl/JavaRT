package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFatherName = reader.readLine();
        Cat catGrandFather = new Cat(grandFatherName, null, null);

        String grandMotherName = reader.readLine();
        Cat catGrandMother = new Cat(grandMotherName, null, null);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, null, catGrandFather);


        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, catGrandMother, null);

        String sanName = reader.readLine();
        Cat catSan = new Cat(sanName, catMother, catFather);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catFather);

        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSan);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parentF;
        private Cat parentM;


        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parentF, Cat parentM) {
            this.name = name;
            this.parentF = parentF;
            this.parentM = parentM;

        }

        @Override
        public String toString() {
            if ((parentF == null)&&(parentM == null))       return "Cat name is " + name + ", no mother " + ", no father";
            else if((parentF != null)&&(parentM == null))   return "Cat name is " + name + ", mother is " + parentF.name + ", no father";
            else if((parentF == null)&&(parentM != null))   return "Cat name is " + name + ", no mother"  + ", father is " + parentM.name;
            else if((parentF != null)&&(parentM != null))   return "Cat name is " + name + ", mother is " + parentF.name + ", father is " + parentM.name;
            else return null;
        }
    }

}
