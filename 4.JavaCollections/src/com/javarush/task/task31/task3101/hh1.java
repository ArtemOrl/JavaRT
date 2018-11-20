package com.javarush.task.task31.task3101;

import java.util.*;

public class hh1 {
    public static void main(String[] args) {
        //int[] arr = {7, 3, 12, 5};
        //int[] arr = {6, 9, 5, 2, 3};
        int[] arr = {8, 6, 9, 81, -1000000001};
        if (arr==null) System.out.println("");
        else {
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                set.add(arr[i]);
            }

            for (Integer integer : set) {
                list.add(integer);
            }
            Collections.sort(list);


            for (int i = 0; i < list.size(); i++) {
                if (i + 1 >= list.size()) break;
                if (list.get(0) > 1 || list.get(0) < 0) {
                    System.out.println(1);
                    break;
                }
                if ((list.get(i + 1) - list.get(i)) > 1) {
                    int i1 = (list.get(i + 1) - list.get(i)) - 1;
                    System.out.println(list.get(i + 1) - i1);
                    break;
                } else {
                    System.out.println("");
                    break;
                }
            }
        }
    }
}
