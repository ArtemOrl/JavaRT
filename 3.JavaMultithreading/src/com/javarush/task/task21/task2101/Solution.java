package com.javarush.task.task21.task2101;

import java.util.ArrayList;
import java.util.Scanner;

/*
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {

        int a[] = new int[ip.length];
        byte[] na = new byte[ip.length];
        for (int i = 0; i < ip.length; i++) {

            a[i] = ip[i]&mask[i];
            na[i] = (byte) ((byte) ip[i]&mask[i]);
        }

        return na;
    }

    public static void print(byte[] bytes) {

        ArrayList<Integer> powers = new ArrayList<Integer>();


        powers.add(128);
        powers.add(64);
        powers.add(32);
        powers.add(16);
        powers.add(8);
        powers.add(4);
        powers.add(2);
        powers.add(1);


        System.out.println();
        for (byte aByte : bytes) {
            if (Integer.toBinaryString((int)aByte).length()>24) System.out.print(Integer.toBinaryString((int)aByte).substring(24) + " ");

            else if (Integer.toBinaryString((int)aByte).length()<24){
                ArrayList<Integer> binaryStore = new ArrayList<Integer>();
                int input = (int) aByte;
//                System.out.println(input);
                int printableInput = aByte;

                for (int i : powers) {
                    if (input < i) {
                        binaryStore.add(0);
                    } else {
                        input = input - i;
                        binaryStore.add(1);
                    }
                }

                String newString= binaryStore.toString();
                String finalOutput = newString.replace("[", "")
                        .replace(" ", "")
                        .replace("]", "")
                        .replace(",", "");
                System.out.print(finalOutput + " ");
            }
        }

    }
}
