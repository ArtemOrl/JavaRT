package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
//    public static String firstFileName;
//    public static String secondFileName;
//
//    //add your code here - добавьте код тут
//    static {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        try {
////            InputStream inStream1 = new FileInputStream(reader.readLine());
////            InputStream inStream2 = new FileInputStream(reader.readLine());
//            String firstFileName = reader.readLine();
//            String secondFileName = reader.readLine();
//
//        } catch (IOException exception) {
//
//        }
//    }

    public static String firstFileName;
    public static String secondFileName;

    static {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();

        } catch (IOException e) {

        }
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {

//        InputStream instream  = new FileInputStream(ReadFileThread.setFilename());

        private String fullFileName;


        private String result = "";
        public ReadFileThread(){}
        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

//        @Override
//        public String getFileContent() {
//            String result = "";
//            try {
//                InputStream inStream = new FileInputStream(fullFileName);
////            BufferedReader inStream = new BufferedReader(new FileReader(fullFileName));
//                String s = "";
//                while (inStream.available() > 0) {
//                    char elem = ((char) inStream.read());
//                    s += elem;
//                }
//                String delimiter = "\n";
//                String strArray[] = s.split(delimiter);
//                for (int i = 0; i < strArray.length; i++) {
//                    String s1 = strArray[i];
//
//                    result += s1;
//                    result += " ";
//                }
//                inStream.close();
//            } catch (FileNotFoundException e) {
//            } catch (IOException e2) {
//            }
//            return result;
//        }

//        @Override
//        public String getFileContent()
//        {
//            //объект, для построения строки
//            StringBuilder sb = new StringBuilder();
//            String string;
//
//            try{
//                //объект, для чтения файла из буффера
//                BufferedReader in = new BufferedReader(new FileReader(fullFileName));
//                while ((string = in.readLine()) != null){
//                    sb.append(string);
//                    sb.append(" ");
//                }
//
//                in.close();
//
//            }catch (FileNotFoundException e)
//            {
//
//            }catch (IOException e)
//            {
//
//            }
//            return sb.toString();
//        }



        @Override
        public String getFileContent() {
//            String result = "";
//            try {
//                InputStream inStream = new FileInputStream(fullFileName);
////            BufferedReader inStream = new BufferedReader(new FileReader(fullFileName));
//                String s = "";
//                while (inStream.available() > 0) {
//                    char elem = ((char) inStream.read());
//                    s += elem;
//                }
//                String delimiter = "\n";
//                String strArray[] = s.split(delimiter);
//                for (int i = 0; i < strArray.length; i++) {
//                    String s1 = strArray[i];
//
//                    result += s1;
//                    result += " ";
//                }
//                inStream.close();
//            } catch (FileNotFoundException e) {
//            } catch (IOException e2) {
//            }
            return result;
        }


        @Override
        public void run() {
            try {
                InputStream inStream = new FileInputStream(fullFileName);
//            BufferedReader inStream = new BufferedReader(new FileReader(fullFileName));

                String s = "";
                while (inStream.available() > 0) {
                    char elem = ((char) inStream.read());
                    s += elem;
                }
                String delimiter = "\n";
                String strArray[] = s.split(delimiter);
                for (int i = 0; i < strArray.length; i++) {
                    String s1 = strArray[i];

                    result += s1;
                    result += " ";
                }

                inStream.close();
            } catch (FileNotFoundException e) {
            } catch (IOException e2) {
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
}
