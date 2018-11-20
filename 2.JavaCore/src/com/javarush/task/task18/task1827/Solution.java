package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {

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
}
