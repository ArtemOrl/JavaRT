package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
//public class Solution implements Serializable, AutoCloseable {
//    private transient FileOutputStream stream;
//
//    private String fileName;
//
//    public Solution(String fileName) throws FileNotFoundException {
//        this.stream = new FileOutputStream(fileName);
//    }
//
//    public void writeObject(String string) throws IOException {
//        stream.write(string.getBytes());
//        stream.write("\n".getBytes());
//        stream.flush();
//    }
//
//    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.defaultWriteObject();
////        out.close();
//    }
//
//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//
//        stream = new FileOutputStream(fileName, true);
//        in.defaultReadObject();
//
////        in.close();
//    }
//
//    @Override
//    public void close() throws Exception {
//        System.out.println("Closing everything!");
//        stream.close();
//    }
//
//    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//
//        Solution solution = new Solution("/Users/a1/Desktop/file.txt");
//        solution.writeObject("Eb tvoe suku bliad!!!");
//
//        Solution solution1 = new Solution("/Users/a1/Desktop/file.txt");
//        solution1.writeObject("Mrazi ebat!");
//
//        FileInputStream fiStream = new FileInputStream("/Users/a1/Desktop/file.txt");
//        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
//
//        Solution loadedObject = (Solution) objectStream.readObject();
//
//
//        fiStream.close();
//        objectStream.close();
//        System.out.println(loadedObject);
//
//    }
//}

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution("/Users/a1/Desktop/file.txt");
        solution.writeObject("Shalom!\r\n");
        ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("/Users/a1/Desktop/file.txt"));
        oos.writeObject(solution);

        ObjectInputStream ois = new ObjectInputStream((new FileInputStream("/Users/a1/Desktop/file.txt")));
        Solution solution2 = (Solution) ois.readObject();
        solution2.writeObject("Shalom again!");

    }
}
