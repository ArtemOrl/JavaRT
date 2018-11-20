package com.javarush.task.task20.task2025;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class test {
    private static List<Long> replica = new ArrayList<>();

    public static long[][] arr = new long[10][19];
    public static void main(String[]args) {
        long start = System.currentTimeMillis();

        SetArr();
//        Long n = (Long)2147483648L;
        Long n = (Long)1_000_000_000_000L;
        long[] array = getNumbers(n);
        long end = System.currentTimeMillis() - start;
        long memore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        SimpleDateFormat sdf = new SimpleDateFormat("ss.SSS");
        System.out.println("Time = " + sdf.format(new Date(end)));
        System.out.println("Memory = " + memore / 1048576);

        Set<Long> armstrongNumbers = new TreeSet<>(Arrays.stream(array).boxed().collect(Collectors.toSet()));

        //тут я подумал може проблема в выводе

        long[] res = new long[armstrongNumbers.size()];

        Object[] narr = armstrongNumbers.toArray();
        for (int i = 0; i < narr.length; i++) {
            long o = Long.parseLong(String.valueOf(narr[i]));

            res[i] = o;
        }
        for (long re : res) {
            System.out.print(re + " ");
        }

    }



    //вначале пробовал перебором... нувыпонели
    public static long[] getNumbers(long N) {
        for (long i = 0; i <= N; i++)
        {
            if (isNumberUnique(i)) {
                long sumOfPowers = sum(i);
                if (isArmstrongNumber(sumOfPowers)) {
                    replica.add(sumOfPowers);
                }
            }
        }

        long[] result = new long[replica.size()];
        for (int j = 0; j < replica.size(); j++) {
            result[j] = replica.get(j);
        }

        return result;
    }

    private static boolean isArmstrongNumber(long number) {
        if (sum(number) == number) {
            return true;
        }

        return false;
    }

    private static boolean isNumberUnique(long number) {
        long lastDigit = 0;
        long currentDigit;

        while (number > 0) {
            currentDigit = number % 10;
            if (lastDigit > currentDigit) {
                return false;
            }
            lastDigit = currentDigit;
            number /= 10;
        }

        return true;
    }

    public static long sum(long a) {
        long addition = 0;
        int d = ("" + a).length();
        long b = a % 10;
        while (a >= 1) {
            //тут чуть-чуть ускорил за счет таблицы степеней
//            addition += Math.pow(b, d);
            addition += pow(b, d);
            a /= 10;
            b = a % 10;
        }

        return addition;
    }

    public static void SetArr()
    {
        for(int i=0; i<10; i++)
        {
            for(int j=0; j<19; j++)
            {
                arr[i][j] = (long) Math.pow(i,j);
            }
        }
    }
    public static long pow (long b, long d){

        int i = (int) b;
        int j = (int) d;
        return arr[i][j];
    }
}
