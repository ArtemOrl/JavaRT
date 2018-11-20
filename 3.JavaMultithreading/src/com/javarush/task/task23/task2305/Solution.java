package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public static class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution solution = new Solution();
        Solution solution1 = new Solution();
        solution.innerClasses[0] = new InnerClass();
        solution.innerClasses[1] = new InnerClass();
        solution1.innerClasses[0] = new InnerClass();
        solution1.innerClasses[1] = new InnerClass();
        Solution[] solutions = new Solution[2];
        solutions[0] = solution;
        solutions[1] = solution1;
        return solutions;
    }

    public static void main(String[] args) {

    }
}
