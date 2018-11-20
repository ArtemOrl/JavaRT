package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution implements Serializable {
    public A getOriginalObject(ObjectInputStream objectStream)throws IOException, ClassNotFoundException {
        try {A wer = (A)objectStream.readObject();
//            if (wer instanceof A) return wer;
//            else if (!(wer instanceof A)) return null;
            return wer;
        }catch (Exception e){e.printStackTrace();return null;}


//        A wer = (A)objectStream.readObject();
//        if (wer instanceof A) return wer;
//        else if (!(wer instanceof A)) return null;
//        else return null;


        }

    public class A implements Serializable  {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
