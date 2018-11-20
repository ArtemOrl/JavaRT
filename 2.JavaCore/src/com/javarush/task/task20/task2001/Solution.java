package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("/Users/a1/Desktop/file.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            String isNameExist = name != null ? "name exist" : "name don't exist";
            pw.println(isNameExist);
            if (isNameExist.equals("name exist"))
                pw.println(name);

            String isAssetsExist = assets != null ? "asset exist" : "asset don't exist";
            pw.println(isAssetsExist);
            if (isAssetsExist.equals("asset exist"))
            {
                for (Asset x : assets)
                {
                    pw.println(x.getName());
                    String isAssetPriceExist = x.getPrice() != 0.0 ? "price exist" : "price don't exist";
                    if (isAssetPriceExist.equals("price exist"))
                        pw.println(x.getPrice());
                }
            }
            pw.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String nExist = br.readLine();
            if (nExist.equals("name exist"))
                name = br.readLine();

            String aExist = br.readLine();
            if (aExist.equals("asset exist"))
                while (br.ready())
                    assets.add(new Asset(br.readLine(), Double.parseDouble(br.readLine())));
            br.close();

        }
    }
}
