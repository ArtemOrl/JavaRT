package com.javarush.task.task20.task2005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Очень странные дела
*/

public class Solution {
//    public static void main(String[] args) {
//        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
//        try {
//            File your_file_name = File.createTempFile("/Users/a1/Desktop/file.txt", null);
//            OutputStream outputStream = new FileOutputStream(your_file_name);
//            InputStream inputStream = new FileInputStream(your_file_name);
//
//            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
//            ivanov.save(outputStream);
//            outputStream.flush();
//
//            Human somePerson = new Human();
//            somePerson.load(inputStream);
//            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
//            System.out.println(ivanov.equals(somePerson));
//            inputStream.close();
//
//        } catch (IOException e) {
//            //e.printStackTrace();
//            System.out.println("Oops, something wrong with my file");
//        } catch (Exception e) {
//            //e.printStackTrace();
//            System.out.println("Oops, something wrong with save/load method");
//        }
//    }
//
//    public static class Human {
//        public String name;
//        public List<Asset> assets = new ArrayList<>();
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return false;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            Human human = (Human) o;
//
//            if (name == null ? !name.equals(human.name) : human.name != null) return false;
//            return assets != null ? assets.equals(human.assets) : human.assets == null;
//
//        }
//
//        @Override
//        public int hashCode() {
//            int result = name != null ? name.hashCode() : 0;
//            result = 31 * result + (assets != null ? assets.hashCode() : 0);
//            return (int) (Math.random() * 100);
//        }
//
//        public Human() {
//        }
//
//        public Human(String name, Asset... assets) {
//            this.name = name;
//            if (assets != null) {
//                this.assets.addAll(Arrays.asList(assets));
//            }
//        }
//
//        public void save(OutputStream outputStream) throws Exception {
//            //implement this method - реализуйте этот метод
////            PrintWriter printWriter = new PrintWriter(outputStream);
////            printWriter.println(this.name);
////            if (this.assets.size() > 0) {
////                for (Asset current : this.assets)
////                    printWriter.println(current.getName());
////            } else if (this.assets==null){
////                printWriter.println("");
////            }
////            printWriter.close();
//
//
////            PrintWriter pw = new PrintWriter(outputStream);
////            String isNameExist = name != null ? "name exist" : "name don't exist";
////            pw.println(isNameExist);
////            if (isNameExist.equals("name exist"))
////                pw.println(name);
////
////            String isAssetsExist = assets != null ? "asset exist" : "asset don't exist";
////            pw.println(isAssetsExist);
////            if (isAssetsExist.equals("asset exist"))
////            {
////                for (Asset x : assets)
////                {
////                    pw.println(x.getName());
////                    String isAssetPriceExist = x.getPrice() != 0.0 ? "price exist" : "price don't exist";
////                    if (isAssetPriceExist.equals("price exist"))
////                        pw.println(x.getPrice());
////                }
////            }
////            pw.close();
//
//
//            PrintWriter printWriter = new PrintWriter(outputStream);
//            if(this.name != null) {
//                printWriter.println("yes");
//                printWriter.println(this.name);
//                printWriter.println(assets.size());
//
//                if (this.assets.size() > 0) {
//                    for (Asset current : this.assets) {
//                        printWriter.println(current.getName());
//                        printWriter.println(current.getPrice());
//                    }
//                }
//            }
//            else if(this.name == null)
//                printWriter.println("no");
//            printWriter.close();
//        }
//
//        public void load(InputStream inputStream) throws Exception {
//            //implement this method - реализуйте этот метод
////            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
////
////            this.name = reader.readLine();
////            String assetName;
////            while ((assetName = reader.readLine()) != null)
////                this.assets.add(new Asset(assetName));
////            reader.close();
//
////            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
////            String nExist = br.readLine();
////            if (nExist.equals("name exist"))
////                name = br.readLine();
////
////            String aExist = br.readLine();
////            if (aExist.equals("asset exist"))
////                while (br.ready())
////                    assets.add(new Asset(br.readLine()));//, Double.parseDouble(br.readLine())
////            br.close();
//
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            String name1= reader.readLine();
//            if(name1.equals("yes")){
//                this.name = reader.readLine();
//                int i=Integer.parseInt(reader.readLine());
//                while((i--)>0) {
//                    Asset asset = new Asset(reader.readLine());
//                    asset.setPrice(Double.parseDouble(reader.readLine()));
//                    this.assets.add(asset);
//                }
//            }
//            else if(name1.equals("no"))
//                this.name = null;
//            reader.close();
//        }
//    }

    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {
            File file1 = File.createTempFile("C:\\Users\\Igor\\Desktop\\data1.txt", null);
            OutputStream outputStream = new FileOutputStream(file1);
            InputStream inputStream = new FileInputStream(file1);

            //Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            Human ivanov = new Human();
            ivanov.save(outputStream);
            outputStream.flush();
            outputStream.close();

            Human somePerson = new Human();
            somePerson.load(inputStream);

            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }
//    @Override
//        public boolean equals(Object o) {
//            if (this == o) return false;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            Human human = (Human) o;
//
//            if (name == null ? !name.equals(human.name) : human.name != null) return false;
//            return assets != null ? assets.equals(human.assets) : human.assets == null;
//
//        }
//
//        @Override
//        public int hashCode() {
//            int result = name != null ? name.hashCode() : 0;
//            result = 31 * result + (assets != null ? assets.hashCode() : 0);
//            return (int) (Math.random() * 100);
//        }
//
//        public Human() {
//        }
//
//        public Human(String name, Asset... assets) {
//            this.name = name;
//            if (assets != null) {
//                this.assets.addAll(Arrays.asList(assets));
//            }
//        }
    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name == null ? human.name != null : !name.equals(human.name)) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            if(this.name != null) {
                printWriter.println("yes");
                printWriter.println(this.name);
                printWriter.println(assets.size());

                if (this.assets.size() > 0) {
                    for (Asset current : this.assets) {
                        printWriter.println(current.getName());
                        printWriter.println(current.getPrice());
                    }
                }
            }
            else if(this.name == null)
                printWriter.println("no");
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String name1= reader.readLine();
            if(name1.equals("yes")){
                this.name = reader.readLine();
                int i=Integer.parseInt(reader.readLine());
                while((i--)>0) {
                    Asset asset = new Asset(reader.readLine());
                    asset.setPrice(Double.parseDouble(reader.readLine()));
                    this.assets.add(asset);
                }
            }
            else if(name1.equals("no"))
                this.name = null;
            reader.close();
        }
    }
}
