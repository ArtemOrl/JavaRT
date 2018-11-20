package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static class Thread1 extends Thread{
        public void run(){
            while (true){
                try{
                int count = 1;
                System.out.println(count);
                Thread.sleep(500);
                count++;}
                catch (InterruptedException e){}
            }
        }
    }
    public static class Thread2 extends Thread {
        public void run(){
            while (true){
                try{
                    int count = 1;
                    System.out.println(count);
                    Thread.sleep(500);
                    count++;}
                catch (InterruptedException e){
                    System.out.println("InterruptedException");
                }
            }
        }
    }
    public static class Thread3 extends Thread {
        public void run(){
            while (true){
                try{
                    System.out.println("Ура");
                    Thread.sleep(500);
                    }
                catch (InterruptedException e){}
            }
        }
    }
    public static class Thread4 extends Thread implements Message {
        public boolean isAlive = false;
        public void run(){
            while (true){
                if (isAlive==true) break;
                try{
                    System.out.println("Bzdin");
                    Thread.sleep(2000);
                }
                catch (InterruptedException e){}
            }
        }

        @Override
        public void showWarning() {
            isAlive = true;
        }
    }
    public static class Thread5 extends Thread {
        int chislo;
        int count = 0;
        String vvod = "";


        public void run(){
            try{
                while (!vvod.equals("N")){

                        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                        vvod = reader.readLine();

    //                if (vvod=="N") {
    //                    System.out.println(count);
    //                    break;
    //                }

                    if (!vvod.equals("N")){chislo = Integer.parseInt(vvod);
                    count += chislo;}
                    }
                System.out.println(count);

            }
            catch (IOException e){}

//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            int sum = 0;
//
//            try{
//
//                while (!isInterrupted())
//                {
//                    String s = reader.readLine();
//
//                    if (s.equals("N")) this.interrupt();
//
//                    else
//                    {
//                        int integer = Integer.parseInt(s);
//
//                        sum += integer;
//                    }
//                }
//
//                throw new InterruptedException();
//
//            }catch (IOException e)
//            {
//
//            }catch (InterruptedException e)
//            {
//                System.out.println(sum);
//            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread5();
        thread.start();
    }
}