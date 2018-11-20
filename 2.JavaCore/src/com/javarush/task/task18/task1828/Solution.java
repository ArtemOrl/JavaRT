package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException{


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();

        //запишем содержимое файла1 в массив
        ArrayList<Integer> list1 = new ArrayList<>();
        FileInputStream file1inStream = new FileInputStream(fileName);
        while (file1inStream.available()>0)
        {
            int data = file1inStream.read();
            list1.add(data);

        }
        file1inStream.close();


        if (args[0].equals("-u")){

            ArrayList<String> arrayList = new ArrayList<>();

//            String fileName = bufferedReader.readLine();
            FileReader fileReader = new FileReader(fileName);
            BufferedReader fileBufReader = new BufferedReader(fileReader);

            String res;

            //сделаем пачку ID для нахождение искомого + сделаем arrayList со всеми строками для замены
            ArrayList<Integer> ids = new ArrayList<>();
            while((res = fileBufReader.readLine()) != null){

                arrayList.add(res);
                String id = "";
                char[] line = res.toCharArray();
                for (int i = 0; i < 8; i++) {
                    char c = line[i];
                    System.out.println(c);
                    if (Character.toString(c).equals(" ")) break;
                    id+=c;
                }
                ids.add(Integer.parseInt(id));


            }
            fileBufReader.close();

            //сформируем строку для изменения
            String ID = args[1];
            String n1;
            n1 = ID;
            if (n1.length()<8){
                while (n1.length()<8) n1+=" ";
            }
            String n2 = args[2];
            if (n2.length()<30){
                while (n2.length()<30) n2+=" ";
            }
            String n3 = args[3];
            if (n3.length()<8){
                while (n3.length()<8) n3+=" ";
            }
            String n4 = args[4];
            if (n4.length()<4){
                while (n4.length()<4) n4+=" ";
            }
            String ready = n1 + n2 + n3 + n4;

            //подменим строку в массиве
            for (int i = 0; i < arrayList.size(); i++) {

                if (arrayList.get(i).startsWith(ID)) arrayList.set(i, ready);

            }


            //запишем все обратно в файл
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            for (int i = 0; i < arrayList.size(); i++) {
                fileOutputStream.write(arrayList.get(i).getBytes());
                fileOutputStream.write("\n".getBytes());
            }

            fileOutputStream.close();
        }

        if (args[0].equals("-d")){

            ArrayList<String> arrayList = new ArrayList<>();

//            String fileName = bufferedReader.readLine();
            FileReader fileReader = new FileReader(fileName);
            BufferedReader fileBufReader = new BufferedReader(fileReader);

            String res;

            //сделаем пачку ID для нахождение искомого + сделаем arrayList со всеми строками для замены
            ArrayList<Integer> ids = new ArrayList<>();
            while((res = fileBufReader.readLine()) != null){

                arrayList.add(res);
//                String id = "";
//                char[] line = res.toCharArray();
//                for (int i = 0; i < 8; i++) {
//                    char c = line[i];
//                    System.out.println(c);
//                    if (Character.toString(c).equals(" ")) break;
//                    id+=c;
//                }
//                ids.add(Integer.parseInt(id));


            }
            fileBufReader.close();

            //сформируем строку для изменения
            String ID = args[1];

            if (ID.length()<8){
                while (ID.length()<8){
                    ID+=" ";
                }
            }

            System.out.println(ID);


            ArrayList<String> narray = new ArrayList<>();
            System.out.println(arrayList.size());
            //удалим строку в массиве
            for (int i = 0; i < arrayList.size(); i++) {

//                if (!(arrayList.get(i).startsWith(ID))) narray.add(arrayList.get(i));//arrayList.remove(i);

                if (arrayList.get(i).startsWith(ID)) arrayList.remove(i);
            }

            System.out.println(arrayList.size());

//            System.out.println(narray.size());
            //запишем все обратно в файл
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            for (int i = 0; i < arrayList.size(); i++) {

                fileOutputStream.write(arrayList.get(i).getBytes());
                fileOutputStream.write("\n".getBytes());
            }

            fileOutputStream.close();
        }

        if (args[0].equals("-c")){
            ArrayList<String> arrayList = new ArrayList<>();

//            String fileName = bufferedReader.readLine();
            FileReader fileReader = new FileReader(fileName);
            BufferedReader fileBufReader = new BufferedReader(fileReader);

            String res;

            //сделаем пачку ID для нахождение искомого
            ArrayList<Integer> ids = new ArrayList<>();
            while((res = fileBufReader.readLine()) != null){

                String id = "";
                char[] line = res.toCharArray();
                for (int i = 0; i < 8; i++) {
                    char c = line[i];
                    System.out.println(c);
                    if (Character.toString(c).equals(" ")) break;
                    id+=c;
                }
                ids.add(Integer.parseInt(id));
            }
            fileBufReader.close();


            Collections.sort(ids, Collections.reverseOrder());

            //добьем до 8 символов
            String newID = Integer.toString(ids.get(0)+1);
            String n1 = "";
            if (newID.length()<8){
                while (newID.length()<8){
                    newID+=" ";
                }
            }
            n1 = newID;

            String n2 = args[1];
            if (n2.length()<30){
                while (n2.length()<30) n2+=" ";
            }
            String n3 = args[2];
            if (n3.length()<8){
                while (n3.length()<8) n3+=" ";
            }
            String n4 = args[3];
            if (n4.length()<4){
                while (n4.length()<4) n4+=" ";
            }
            String ready = "\n" + n1 + n2 + n3 + n4;

            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            for (int i = 0; i < list1.size(); i++) {
                fileOutputStream.write(list1.get(i));
            }

            fileOutputStream.write(ready.getBytes());

            fileOutputStream.close();
        }
    }

    //Для анализа

//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = bufferedReader.readLine();
//        bufferedReader.close();
//        StringBuilder productName = new StringBuilder();
//
//        ArrayList<String> list = getStringList(fileName);
//        ArrayList<Long> idList = getIdList(fileName);
//        PrintWriter printWriter;
//        int index = idList.indexOf(Long.parseLong(args[1]));
//
//        if (args[0].equals("-u")) {
//            for (int i = 2; i < args.length - 2; i++) {
//                productName.append(args[i]).append(" ");
//            }
//
//            String trueProductName = setSpaces(productName.toString(), 30);
//            String truePrice = setSpaces(args[args.length - 2], 8);
//            String trueQuantity = setSpaces(args[args.length - 1], 4);
//            String id = setSpaces(args[1], 8);
//            String ourString = id + trueProductName + truePrice + trueQuantity;
//
//            if (!idList.contains(Long.parseLong(args[1]))) {
//                printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
//                printWriter.println(ourString);
//            } else {
//                list.set(index, ourString);
//                printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
//                for (String aString : list) {
//                    printWriter.println(aString);
//                }
//            }
//            printWriter.close();
//        } else if (args[0].equals("-d")) {
//            list.remove(index);
//            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
//            for (String aString : list) {
//                printWriter.println(aString);
//            }
//            printWriter.close();
//        }
//    }
//
//    private static ArrayList<String> getStringList(String fileName) throws IOException {
//        ArrayList<String> allList = new ArrayList<>();
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            allList.add(line);
//        }
//        bufferedReader.close();
//        return allList;
//    }
//
//    private static ArrayList<Long> getIdList(String fileName) throws IOException {
//        ArrayList<Long> allIds = new ArrayList<>();
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
//        String line;
//        Long currentId;
//        while ((line = bufferedReader.readLine()) != null) {
//            line = line.substring(0, 8).replaceAll("\\s", "");
//            currentId = Long.parseLong(line);
//            allIds.add(currentId);
//        }
//        bufferedReader.close();
//        return allIds;
//    }
//
//
//    @SuppressWarnings("Duplicates")
//    private static String setSpaces(String previousName, int count) {
//        String trueName;
//        if (previousName.length() > count) {
//            trueName = previousName.substring(0, count);
//        } else {
//            StringBuilder s = new StringBuilder();
//            for (int i = 0; i < (count - previousName.length()); i++) {
//                s.append(" ");
//            }
//            trueName = previousName + s;
//        }
//        return trueName;
//    }
}
