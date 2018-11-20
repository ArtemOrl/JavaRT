package com.javarush.task.task16.task1626;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountDownRunnable(), "Уменьшаем").start();
        new Thread(new CountUpRunnable(), "Увеличиваем").start();
//        thread.start();
//        thread.join();
//        long end = System.currentTimeMillis() - start;
//
//        System.out.println(new SimpleDateFormat("'seconds : ' s, 'miliseconds : ' S").format(new Date(end)));

    }

    public static class CountUpRunnable implements Runnable{
        //Add your code here - добавь код тут
        private int countIndexUp = 1;

//        private float time = 0;
        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexUp += 1;
//                    time+=0.5;
//                    if (time>2.5) throw new InterruptedException();
                    if (countIndexUp > number) {
                        Thread.sleep(500);
                        return;
                    }
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexUp;
        }
    }



    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
