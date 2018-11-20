package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> listObsh = new ArrayList<>();
        ArrayList<Integer> listDel3 = new ArrayList<>();
        ArrayList<Integer> listDel2 = new ArrayList<>();
        ArrayList<Integer> listOst = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 20; i++) {
            String text = reader.readLine();
            int cifir = Integer.parseInt(text);
            listObsh.add(cifir);
        }

        for (int i = 0; i < listObsh.size(); i++) {
            Integer x = listObsh.get(i);

            if ((x % 3 == 0)&&(x % 2 == 0)){listDel3.add(x);listDel2.add(x);}
            else if ((x % 3 == 0)&&(x % 2 != 0)) listDel3.add(x);
            else if ((x % 3 != 0)&&(x % 2 == 0)) listDel2.add(x);
            else listOst.add(x);
        }

        printList(listDel3);
        printList(listDel2);
        printList(listOst);



    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)+" ");
        }
    }
}
