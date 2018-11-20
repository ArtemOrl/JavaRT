package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;

import javax.crypto.ShortBufferException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.BadPaddingException;

public class Solution {
    public static void main(String[] args) throws IOException/*, NoSuchAlgorithmException, NoSuchPaddingException,
//            InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException,
//            BadPaddingException*/{
//
//        FileInputStream inputStream = new FileInputStream(new File(args[1]));
//
////        byte[] input = new byte[inputStream.available()];
////        while (inputStream.available()>0) {
////            inputStream.read(input);
////        }
//        int data;
//        ArrayList<Integer> file = new ArrayList<>();
//        while (inputStream.available() > 0) {
//            data = inputStream.read();
//            file.add(data);
//        }
//
//        inputStream.close();
////        for (int i = 0; i < file.size(); i++) {
////            System.out.print(file.get(i)+ " ");
////
////        }
//
//
////        byte[] keyBytes = {112,1,2,3,4,5,6,7};
////        byte[] ivBytes = {110, 1, 2, 4, 5, 6, 7, 80};
////
////
////
////        //Initialisation
////        // wrap key data in Key/IV specs to pass to cipher
////        SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
////        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
////        // create the cipher with the algorithm you choose
////        // see javadoc for Cipher class for more info, e.g.
////        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
////
////        if (args[0].equals("-e")){
////            cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
////            byte[] encrypted= new byte[cipher.getOutputSize(input.length)];
////            int enc_len = cipher.update(input, 0, input.length, encrypted, 0);
////            enc_len += cipher.doFinal(encrypted, enc_len);
////
////            String enc_lenn = Integer.toString(enc_len);
////
////            byte[] enc_len1 = enc_lenn.getBytes();
////            FileOutputStream fileOutputStream2 = new FileOutputStream("/Users/a1/Desktop/file_e.txt");
////            FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
////
////            fileOutputStream.write(encrypted);
////            fileOutputStream2.write(enc_len1);
////            fileOutputStream.close();
////            fileOutputStream2.close();
////        }
////        else if (args[0].equals("-d")){
////
////            BufferedReader reader = new BufferedReader( new FileReader (args[1]));
////            String line = null;
////            StringBuilder stringBuilder = new StringBuilder();
////            String ls = System.getProperty("line.separator");
////            while( ( line = reader.readLine() ) != null ) {
////                stringBuilder.append( line );
////                stringBuilder.append( ls );
////            }
////
////            stringBuilder.deleteCharAt(stringBuilder.length()-1);
////            String encrypt = stringBuilder.toString();
////            byte[] encrypted = encrypt.getBytes();
////            reader.close();
////
////            System.out.println(encrypt);
//////            BufferedReader reader1 = new BufferedReader( new FileReader (args[3]));
//////            String line1 = null;
//////            StringBuilder stringBuilder1 = new StringBuilder();
//////            String ls1 = System.getProperty("line.separator");
//////            while( ( line1 = reader.readLine() ) != null ) {
//////                stringBuilder1.append( line1 );
//////                stringBuilder1.append( ls1 );
//////            }
//////
//////            stringBuilder.deleteCharAt(stringBuilder.length()-1);
//////            String zu = stringBuilder.toString();
//////            int enc_len = Integer.parseInt(zu);
//////            reader1.close();
////
//////            FileInputStream inputStream1 = new FileInputStream(new File(args[3]));
//////
//////            byte[] input1 = new byte[inputStream.available()];
//////            while (inputStream.available()>0) {
//////                inputStream.read(input);
//////            }
//////            inputStream1.close();
////
////            String zu = new String(Files.readAllBytes(Paths.get(args[3])));
////            int enc_len = Integer.parseInt(zu);
////            System.out.println(enc_len);
////
////            cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
////            byte[] decrypted = new byte[cipher.getOutputSize(enc_len)];
////            int dec_len = cipher.update(encrypted, 0, enc_len, decrypted, 0);
////            dec_len += cipher.doFinal(decrypted, dec_len);
////
////            FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
////
////            fileOutputStream.write(decrypted);
////            fileOutputStream.close();
////        }
////        else if (args[0].equals("-p")){
////            cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
////            byte[] encrypted= new byte[cipher.getOutputSize(input.length)];
////            int enc_len = cipher.update(input, 0, input.length, encrypted, 0);
////            enc_len += cipher.doFinal(encrypted, enc_len);
////
////            System.out.println(encrypted);
////            System.out.println(enc_len);
////
////            cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
////            byte[] decrypted = new byte[cipher.getOutputSize(enc_len)];
////            int dec_len = cipher.update(encrypted, 0, enc_len, decrypted, 0);
////            dec_len += cipher.doFinal(decrypted, dec_len);
////
////            System.out.println(decrypted);
////            System.out.println(dec_len);
////
////        }
//        //еще заходик
////        System.out.println();
//        if (args[0].equals("-e")){
//
//            FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
//
//            for (int i = 0; i < file.size(); i++) {
//                fileOutputStream.write(file.get(i)*2 );
//
////                System.out.print(file.get(i)*2 + " ");
//            }
//
//
//            fileOutputStream.close();
//
//        }
//        else if (args[0].equals("-d")){
//
//            FileInputStream inputStream1 = new FileInputStream(new File(args[1]));
//
//
//            ArrayList<Integer> obrabotka = new ArrayList<>();
//            while (inputStream1.available() > 0) {
//                int data1 = inputStream1.read();
//                obrabotka.add(data1/2);
//            }
//
//
//            inputStream1.close();
//            FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
//
//            for (int i = 0; i < obrabotka.size(); i++) {
//                fileOutputStream.write(obrabotka.get(i));
//
//            }
//
//            fileOutputStream.close();
//        }


        //В моем случае небыло разбивки на методы

            FileInputStream inputStream = new FileInputStream(args[1]);
            ArrayList<Integer> bytes = new ArrayList<>();
            while (inputStream.available() > 0) {
                bytes.add(inputStream.read());
            }
            ArrayList<Integer> output = new ArrayList<>();
            if (args[0].equals("-e")) output = encrypt(bytes);
            else if (args[0].equals("-d")) output = decrypt(bytes);
            FileOutputStream outputStream = new FileOutputStream(args[2]);
            for (Integer integer : output) {
                outputStream.write(integer);
            }
            inputStream.close();
            outputStream.close();
        }

        private static ArrayList<Integer> encrypt(ArrayList<Integer> bytes) {
            ArrayList<Integer> list = new ArrayList<>();
            for (Integer aByte : bytes) {
                list.add(aByte + 3);
            }
            return list;
        }

        private static ArrayList<Integer> decrypt(ArrayList<Integer> bytes) {
            ArrayList<Integer> list = new ArrayList<>();
            for (Integer aByte : bytes) {
                list.add(aByte - 3);
            }
            return list;

    }

}
