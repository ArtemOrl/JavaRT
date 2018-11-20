package com.javarush.task.task21.task2108;

import java.util.Arrays;

/*
Клонирование растений
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        protected Tree clone() throws CloneNotSupportedException {
//            return new Tree(super.name, this.branches);
            //потому что branches[] может быть пустым или нет
            if (branches==null) return new Tree(super.name, null);
            String[] branches = Arrays.copyOf(getBranches(), getBranches().length);
            Tree tree = new Tree(super.name, branches);
            return tree;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tree)) return false;
            Tree tree = (Tree) o;
            if (branches != tree.branches) return false;
            return Arrays.equals(branches, tree.branches);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(branches);
        }
    }
}
