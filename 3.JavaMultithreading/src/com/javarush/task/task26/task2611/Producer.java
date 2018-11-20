package com.javarush.task.task26.task2611;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable{
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

//    public Producer(BlockingQueue queue) {
//        this.queue = queue;
//    }

    public void run() {
        Thread currentThread = Thread.currentThread();
//        while (!currentThread.isInterrupted()) {
//            if (!map.isEmpty()) {
//                for (String key : map.keySet()) {
//                    System.out.println(map.remove(key));
//                }
//            }

//        }
//        try {
//            while (!currentThread.isInterrupted()) {
//                int i = 0;
//                map.put(Integer.toString(i), "Some text for" + i);
//                i++;
//
//        }} catch (Exception e) {
//            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
//        }

        try {
            int i = 1;
            //noinspection InfiniteLoopStatement
            while (true) {
                System.out.println("Some text for " + i++);
                map.put(Integer.toString(i), "Some text for" + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out
                    .println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
