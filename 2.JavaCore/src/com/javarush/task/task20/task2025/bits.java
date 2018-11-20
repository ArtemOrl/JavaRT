package com.javarush.task.task20.task2025;

public class bits {


    public static void main(String[] args) {
        //побитовое сдвигание
//        long temp = 2L;
//        temp = (temp << 3) + (temp << 1) + 9L;
//        System.out.println(temp);


        //izmerenie
        Long t0 = System.currentTimeMillis();


        int i = 232;
        //число 232 в двоичной системе
        System.out.println(Integer.toBinaryString(i));
        i = i>>3;
        System.out.println(Integer.toBinaryString(i));
        //обратыный перевод из двоичной системы в десятичную
        System.out.println(Integer.parseInt(Integer.toBinaryString(i), 2));

        i = i % 10;
        System.out.println(i);

//        int x;
//        int j = 2345;
//        System.out.println(j);
//        x = j % 10;
//        j = j / 10;
//        System.out.println(j +  " " + j%10 + " " + x);
//        x = j % 10;
//        j = j / 10;
//        System.out.println(j +  " " + j%10 + " " + x);x = j % 10;
//        j = j / 10;
//        System.out.println(j +  " " + j%10 + " " + x);x = j % 10;
//        j = j / 10;
//        System.out.println(j +  " " + j%10 + " " + x);

        int digNumb = getDigNumb(923845724309L);
        System.out.println("digNumb = " + digNumb);


        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1-t0) + " ms");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1000000 + " MB");

    }
    private static int getDigNumb (long numb) {
        long temp = 0L;
        int digNumb = 1;
        while ((temp = temp * 10 + 9L)/*(temp = (temp << 3) + (temp << 1) + 9L)*/ < numb && temp > 0)
            System.out.println("temp = " + temp);
            digNumb++;

        //разница с этим методом 400 мб в памяти
//        int digNumb = Long.toString(numb).length();
        return digNumb;
    }
}
