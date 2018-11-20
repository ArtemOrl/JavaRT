package com.javarush.task.task13.task1307;

/* 
Параметризованый интерфейс
*/

public class Solution {
    public static void main(String[] args) throws Exception {
//        SimpleObject<String> stringObject = new StringObject<Object>();
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    class StringObject<Object> implements SimpleObject<String>
    {
        public StringObject<String> getInstance(){
            return new StringObject();
        }
    }
}