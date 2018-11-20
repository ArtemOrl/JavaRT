package com.javarush.task.task21.task2112;

import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflection {
//    Reflection в Java - java.lang.reflect API туториал(на русском)http://www.javenue.info/post/84
//    экспериментирую:
//    Вывод sin(30°) = 1/2
//    Можно так:
public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InstantiationException, IllegalAccessException,
        InvocationTargetException {
    double d0 = Math.PI/6;
    double dd0 = Math.sin(d0);

    System.out.println(dd0);
//    А можно, вот, так:
    Class mathClass = Math.class;
    Field piFild = mathClass.getField("PI");
    Method sinMethod = mathClass.getMethod("sin",double.class);

    Class printStreamClass = System.out.getClass();
    Constructor<PrintStream> printStreamClassConstruct =
            printStreamClass.getConstructor(OutputStream.class);
    Method printDoubleMethod = printStreamClass.getMethod("println", double.class);

    PrintStream myOunPrint = printStreamClassConstruct.newInstance(System.out);

    double d1 =(double) piFild.get(null)/6;
    double dd1 = (double) sinMethod.invoke(null,d1);

    printDoubleMethod.invoke(myOunPrint,dd1);
//    Вывод в консоль:
//    0.49999999999999994
//    а ещё можно посмотреть методы класса:
    Arrays.stream(Math.class.getMethods())
            .map(Method::getName)
            .forEach(System.out::println);
}

}
