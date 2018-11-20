package com.javarush.task.task31.task3101;

import java.util.ArrayList;
import java.util.List;

public class h211 {

    public static String[][] arr = {{".", "o", ".", "o", ".", "o", ".", "o"},
            {".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", "."}};



    public static void main(String[] args) {
        String[][]rotatedArr = povorotNa90GradPochas(arr);

        List<List> list = findObjects(arr);
        List<List> list2 = findObjects(povorotNa90GradPochas(arr));

        printResult(list);
        printResult(list2);

    }

    public static List findObjects(String[][] arr){

        List<List<String[]>> list = new ArrayList<>();
        List<String[]> list1 = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            String[] strings = arr[i];

            if (ifO(strings)==false) {
                list1.add(strings);
                continue;
            }

            else if (ifO(strings)==true && howManyO(strings)==1){
                list1.add(strings);
                list.add(list1);
                list1=new ArrayList<>();
                continue;
            }

            else if (ifO(strings)==true && howManyO(strings)>1){
                return new ArrayList();

            }

        }

        return list;
    }

    public static boolean checkObjects(List<List> list){
        if (list.equals(null)) return false;
        else {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).size() == list.get(i + 1).size()) continue;
                else return false;
            }
        }
        return true;
    }

    public static void printResult (List<List> list){
        for (int i = 0; i < list.size(); i++) {
            List<String[]> lll = list.get(i);
            for (int j = 0; j < lll.size(); j++) {
                String[] arr = lll.get(j);
                for (int k = 0; k < arr.length; k++) {
                    System.out.print(arr[k]);

                }
                System.out.println();
            }
            System.out.println();

        }
    }

    public static boolean ifO(String[] arr){
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if (!s.equals("o")) continue;
            if (s.equals("o")) return true;

        }
        return false;
    }

    public static int howManyO(String[] arr){
        int o = 0;
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if (s.equals("o")) o += 1;
        }
        return o;
    }

    public static String[][] povorotNa90GradPochas (String[][] arr){
        int n = arr[0].length;//8
        int m = arr.length;//4
        String[][] resultArr = new String[n][m];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                resultArr[j][i] = arr[i][j];

            }

        }
        return resultArr;
    }
}
