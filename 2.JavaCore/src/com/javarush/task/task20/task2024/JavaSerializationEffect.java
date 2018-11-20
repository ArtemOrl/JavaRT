package com.javarush.task.task20.task2024;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JavaSerializationEffect {

    public void effect() throws Throwable{
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("/Users/a1/Desktop/file.txt"));
        Test xx=new Test();
        for(int i=0;i<10;i++){
            xx.setA(i);
            out.writeObject(xx);
//            out.reset();           	// Сброс графа сериализации в потоке !!!!!!!!!!!!!!
        }                       		// Без этого объект пишется 1 раз, а после него - ссылки
        out.close();
        Test zz[]=new Test[10];
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("/Users/a1/Desktop/file.txt"));
        for(int i=0;i<10;i++)
            zz[i]=(Test)in.readObject();
        in.close();
        for(int i=0;i<10;i++)
            System.out.println("a="+zz[i].getA() + " "+zz[i]);
    }
    public static void main(String[] args) {
        try {
            JavaSerializationEffect xx=new JavaSerializationEffect();
            xx.effect();
        } catch(Throwable ee){ System.out.println(ee); }
    }
    public class Test{
        public Test() {
        }
        int A;

        public int getA() {
            return A;
        }

        public void setA(int a) {
            A = a;
        }
    }
}
