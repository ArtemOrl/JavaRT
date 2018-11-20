package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
//        clock.run();//эту хуйню требовалось убрать, т.к. у объекта уже сразу есть автозапуск start()!!!

        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }
        int seconds = 0;

        public void run() {
            //add your code here - добавь код тут
            try{
                while (countSeconds>=0){

                    System.out.print(countSeconds + " ");
                    Thread.sleep(1000);
                    countSeconds--;
                    seconds++;
                    if (seconds>3) throw new InterruptedException();
                    if (countSeconds==0) break;

                }
                System.out.println("Марш!");


//                int inter=0;
//                for(int i=countSeconds;i>0;i--){
//                    System.out.format("%d ",countSeconds--);
//                    Thread.sleep(1000);
//                    inter++;
//                    if(inter>3.5)throw new InterruptedException();
//                    if(countSeconds==0)System.out.println("Марш!");
//                }

            }catch (InterruptedException e)
            {
                System.out.println("Прервано!");
            }
        }
    }
}
