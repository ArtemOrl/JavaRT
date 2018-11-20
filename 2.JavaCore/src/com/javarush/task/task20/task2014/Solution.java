package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        System.out.println(new Solution(4));
        File file = new File("/Users/a1/Desktop/file.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Solution savedObject = new Solution(4);
        if (savedObject!=null) oos.writeObject(savedObject);
        Solution savedObject1 = new Solution(5);
        Solution loadedObject = (Solution) ois.readObject();
        if (savedObject.string.equals(loadedObject.string)) System.out.println("true");
        oos.close();
        ois.close();
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
