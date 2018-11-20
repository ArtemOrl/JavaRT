package com.javarush.task.task22.task2201;

public class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else
            if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
                System.out.println(getFormattedStringForSecondThread(t, e, string));
            } else {
                System.out.println(getFormattedStringForOtherThread(t, e, string));
            }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {

        String nameThrowable = e.getClass().getName();
        String nameOut = nameThrowable.substring(nameThrowable.lastIndexOf(".")+1, nameThrowable.length());
//        e.initCause(new StringIndexOutOfBoundsException());
        String nameThread = t.getName();
        return String.format(string, nameOut, e.getMessage(), nameThread);
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {

        String newThrowable = e.getClass().getName();
        String nameOut = newThrowable.substring(newThrowable.lastIndexOf(".")+1, newThrowable.length());
        String message = "java.lang.StringIndexOutOfBoundsException: String index out of range: -1";
        String nameThread = t.getName();
        return String.format(string, e.getMessage(), nameOut, nameThread);
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {

        String nameThrowable = e.getClass().getName();
        String nameOut = nameThrowable.substring(nameThrowable.lastIndexOf(".")+1, nameThrowable.length());
        String message = e.getMessage();
        String nameThread = t.getName();
        return String.format(string, nameThread, nameOut, e.getMessage());
    }

//    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
//        String name = String.format(string, e.getClass().getSimpleName(),e.getCause(),t.getName());
//
//        return name;
//    }
//
//    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
//        String name = String.format(string, e.getClass().getSimpleName(),e.getCause(),t.getName());
//        return name;
//    }
//
//    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
//        String name = String.format(string, e.getClass().getSimpleName(),e.getCause(),t.getName());
//        return name;
//    }
}

