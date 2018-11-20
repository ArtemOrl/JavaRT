package com.javarush.task.task25.task2512;

import java.util.ArrayList;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        t.interrupt();
        ArrayList<Throwable> throwables=new ArrayList<>();
        Throwable x=e;
        while (x!=null){
            throwables.add(0,x);
            x=x.getCause();
        }
        for(Throwable xx:throwables){
            System.out.println(xx);
        }
    }
    public static void main (String args[]) {
        Solution solution = new Solution();
        solution.uncaughtException(new Thread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
