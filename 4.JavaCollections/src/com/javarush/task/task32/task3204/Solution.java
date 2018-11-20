package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        Random rand = new Random();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        int q = rand.nextInt((57 - 48) + 1) + 48;
        int w = rand.nextInt((90 - 65) + 1) + 65;
        int e = rand.nextInt((122 - 97) + 1) + 97;
        stream.write(q);
        stream.write(w);
        stream.write(e);
        for (int i = 0; i < 5; i++) {



            int a = rand.nextInt((57 - 48) + 1) + 48;
            int b = rand.nextInt((90 - 65) + 1) + 65;
            int c = rand.nextInt((122 - 97) + 1) + 97;
            int x =  (1 + (int) (Math.random() * 3));
            if (x == 1) stream.write(a);
            else if (x == 2) stream.write(b);
            else stream.write(c);
        }
        return stream;
    }
}