package com.javarush.task.task27.task2706;

import com.javarush.task.task27.task2707.Solution;

public class try2707 {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {

        int lock1 = obj1.hashCode();
        int lock2 = obj2.hashCode();
        Object firstLock = lock1 > lock2 ? obj1 : obj2;
        Object secondLock = lock1 > lock2 ? obj2 : obj1;
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final com.javarush.task.task27.task2707.Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
//        int lock1 = o1.hashCode();
//        int lock2 = o2.hashCode();
//        return lock1 > lock2 ? true : false;

        if (o1.hashCode() < o2.hashCode()) {
            synchronized (o1) {
                synchronized (o2) {
                    return true;
                }
            }
        }
        else if (o1.hashCode() > o2.hashCode()) {
            synchronized (o2) {
                synchronized (o1) {
                    return false;
                }
            }
        }
        return false;


//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    synchronized (o2) {
//                        //System.out.println("o2 sleep");
//                        Thread.sleep(100);
//                        //System.out.println("o2 nesleep");
//                        synchronized (o1) {
////                            System.out.println("o1 sleep");
//                            Thread.sleep(1200);
//                            //System.out.println("o1 nesleep");
//                        }
//                    }
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //System.out.println("n2 stsrt");
//                solution.someMethodWithSynchronizedBlocks(o1, o2);
//                //System.out.println("n2 end");
//            }
//        });
//        t1.start();
//        Thread.sleep(100);
//        t2.start();
////        Thread.sleep(2000);
//        if (t2.getState() != Thread.State.BLOCKED) return true;
//        else if (t2.getState() == Thread.State.BLOCKED) return false;
////        return t2.getState() == Thread.State.BLOCKED;
//        return false;
    }

    public static void main(String[] args) throws Exception {
        final com.javarush.task.task27.task2707.Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
