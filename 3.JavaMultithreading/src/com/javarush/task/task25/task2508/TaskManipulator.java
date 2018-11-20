package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    private Thread thread;

    @Override
    public void run()  {
//        try {
//            Thread.currentThread();
//            Thread.sleep(100);
//            System.out.println(String.format("%s", Thread.currentThread().getName()));
//        } catch (InterruptedException e1) {
//            e1.printStackTrace();
//        }
        try {
            while (!thread.isInterrupted()) {
                Thread.sleep(0);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            //System.out.println(e.getMessage());
        }
    }

    @Override
    public void start(String threadName) {
//        thread = new Thread(threadName);
//        thread.run();
        this.thread = new Thread(this);
        this.thread.setName(threadName);
        this.thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
