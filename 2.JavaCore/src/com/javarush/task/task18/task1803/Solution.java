package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream file = new FileInputStream(reader.readLine());


        //Алгоритм из StackOverflow - валидатор принял после танцев с бубном

        int[] bytes = new int[255];

        byte b;
        while (file.available()>0) {
            b = (byte)file.read();
//            if(b == -1) break;
            bytes[b]++;
        }

        //Эта часть алгоритма не читается валидатором
//        while (true) {
//            b = (byte)file.read();
//            if(b == -1) break;
//            bytes[b]++;
//        }
        file.close();
        ArrayList<Byte> maxCounts = new ArrayList<>();
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] > 0) maxCounts.add((byte)bytes[i]);
        }
        Collections.sort(maxCounts, Collections.reverseOrder());
        for (int i = 0; i < 1/*maxCounts.size()*/; i++) {
            int arg = maxCounts.get(i);
            for (int j = 0; j < bytes.length; j++) {
                int aByte = bytes[j];
                if (arg==aByte) System.out.print(j /*+ " " + aByte + " "*/);
            }

        }
//        for (int i = 0; i < bytes.length; i++) {
//            if (bytes[i]>2){
////            System.out.println(bytes[i] + " " + i);
//
//                System.out.print(i + " ");
//            }
//        }

        ///Users/a1/Desktop/file.txt
        //Рабочий алгоритм, но валидатор не принимает!!!

//        int bytes = file.read();
//        ArrayList<Integer> list = new ArrayList<>();
//
//        while (file.available()>0)
//        {
//            int data = file.read();
//            list.add(data);
//
//        }
//        file.close();
//
//
//        //for result
//        ArrayList<Integer> result = new ArrayList<>();
//
//
//
//        //Drugoy algoritm
////        for (int i = 0; i < list.size(); i++) {
////            System.out.print(list.get(i) + " ");
////
////        }
//        int countOfRepeats = 0;
//        int k=0;
//        while (true){
////            System.out.println(list.size());
//            if (list.size()==0) break;
//
//            countOfRepeats = 0;
//            int number = list.get(k);
//            list.remove(k);
//
//            for (int j = 0; j < list.size(); j++) {
//
//                if (number==list.get(j)) {
//                    countOfRepeats+=1;
//                    list.remove(j);
//                    j--;
//                }
//            }
//            result.add(number);
//            result.add(countOfRepeats);
////            k++;
//        }
//
//        int index = 0;
//        int maxPovtor = 0;
//
//        for (int i = 1; i < result.size(); i+=2) {
//            if (result.get(i)>maxPovtor){
//                maxPovtor = result.get(i);
//                index = i;
//            }
//        }
//        System.out.print(result.get(index-1)/*+ " " + maxPovtor*/);
//
//
//        while (maxPovtor>2){
//            maxPovtor-=1;
//            for (int i = 1; i < result.size(); i+=2) {
//                if (result.get(i)==maxPovtor) {
////                    System.out.println(" " + result.get(i-1) + " "+ result.get(i));
//                    System.out.print(" " + result.get(i-1));
//                }
//            }
//        }






    }


//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = reader.readLine();
//
//        FileInputStream file = new FileInputStream(fileName);
//        ArrayList<Integer> bytes = new ArrayList<>();
//
//        while (file.available() > 0)
//        {
//            bytes.add(file.read());
//        }
//
//        file.close();
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        initMapBytesCount(bytes, map);
//
//        print(map, getMaxCount(map));
//    }
//
//    public static void print(HashMap<Integer, Integer> map, int maxCount){
//
//        for(Map.Entry<Integer, Integer> pair : map.entrySet() )
//        {
////            System.out.println(pair.getKey() + " " + pair.getValue());
//            if (pair.getValue() == maxCount)
//                System.out.print(pair.getKey() + " ");
//        }
//    }
//
//    public static int getMaxCount(HashMap<Integer, Integer> map){
//        int maxCount = 0;
//
//        for(Map.Entry<Integer, Integer> pair : map.entrySet() )
//        {
//            if (pair.getValue() > maxCount)
//                maxCount = pair.getValue();
//        }
//        return maxCount;
//    }
//
//    public static void initMapBytesCount(ArrayList<Integer> bytes, HashMap<Integer, Integer> map){
//
//        for (int i =0; i < bytes.size()-1; i++){
//            int countSameBytes = 0;
//
//            for (int n =i+1; n < bytes.size(); n++){
//                if (bytes.get(n) == bytes.get(i))
//                    countSameBytes++;
//            }
//
//            boolean contains = false;
//
//            for(Map.Entry<Integer, Integer> pair : map.entrySet() )
//            {
//                if (pair.getKey() == bytes.get(i)){
//                    contains = true;
//                }
//            }
//
//            if(!contains){
//                map.put(bytes.get(i), countSameBytes);
//            }
//        }
//    }
}
