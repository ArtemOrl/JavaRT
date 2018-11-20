package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File your_file_name = File.createTempFile("/Users/a1/Desktop/ile_name.tmp", null);
            File file = new File("/Users/a1/Desktop/file.txt");
            OutputStream outputStream = new FileOutputStream(file);
            InputStream inputStream = new FileInputStream(file);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Vangelis");
            user.setLastName("Kondratevi");
            user.setBirthDate(new Date());//1508944516168L
            user.setMale(true);
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);

//            JavaRush javaRush = new JavaRush();
            User user1 = new User();
            user1.setFirstName("Pizdec");
            user1.setLastName("Ivanovich");
            user1.setBirthDate(new Date());//1508944516163L
            user1.setMale(true);
            user1.setCountry(User.Country.OTHER);
            javaRush.users.add(user1);


            javaRush.save(outputStream);
//            javaRush.save(outputStream);
            outputStream.flush();
            javaRush.save(outputStream);
            outputStream.flush();
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны



            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
//            PrintWriter writer = new PrintWriter(outputStream);
//            String areUsersPresent = users != null ? "yes" : "no";
//            writer.println(areUsersPresent);
//            if (areUsersPresent!=null){
//                int size = users.size();
//                writer.println(size);
//                for (int i = 0; i < size; i++) {
//
//                    User user = users.get(i);
//                    if (user.getFirstName()!=null)writer.println(user.getFirstName());
//                    if (user.getLastName()!=null) writer.println(user.getLastName());
//                    if (user.getBirthDate()!=null) writer.println(new SimpleDateFormat("dd-MM-yyyy").format(user.getBirthDate()));
//                    writer.println( user.isMale() ? "Male" : "Female");
//                    if (user.getCountry()!=null) writer.println(user.getCountry().getDisplayedName());
//
//                    writer.flush();//? is Work?
//                }
//            }
//            writer.close();

//            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            PrintWriter writer = new PrintWriter(outputStream);
            if (this.users != null) {
                for (User user : users) {
                    writer.println(user.getFirstName());
                    writer.println((user.getLastName()));
//                    writer.println(formatter.format(user.getBirthDate()));
                    writer.println(user.getBirthDate().getTime());
                    writer.println(user.isMale());
                    writer.println(user.getCountry().getDisplayedName());
                }
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            String areUsersPresent = reader.readLine();
//            if(areUsersPresent.equals("yes")){
//                int size = Integer.parseInt(reader.readLine());
//                if(size>0){
//                    for (int i = 0; i < size; i++) {
//                        User user = new User();
//                        String firstName = reader.readLine();
//                        user.setFirstName(firstName);
//
//                        String lastname = reader.readLine();
//                        user.setLastName(lastname);
//
//                        Date bd = new SimpleDateFormat("dd-MM-yyyy").parse(reader.readLine());
//                        user.setBirthDate(bd);
//
//                        boolean isMale = reader.readLine().equals("yes");
//                        user.setMale(isMale);
//
//                        String countryStr = reader.readLine();
//                        User.Country country;
//                        if(countryStr.equals("Ukraine")){
//                            country = User.Country.UKRAINE;
//                        } else if(countryStr.equals("Russia")){
//                            country = User.Country.RUSSIA;
//                        } else {
//                            country = User.Country.OTHER;
//                        }
//                        user.setCountry(country);
//                        users.add(user);
//                    }
//                }
//            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                User user = new User();
                user.setFirstName(line);
                user.setLastName(reader.readLine());
//                Date formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(reader.readLine());
//                user.setBirthDate(formatter);


                user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                user.setMale(Boolean.parseBoolean(reader.readLine()));
                String countries = reader.readLine();
                switch (countries) {
                    case "Ukraine":
                        user.setCountry(User.Country.UKRAINE);
                        break;
                    case "Russia":
                        user.setCountry(User.Country.RUSSIA);
                        break;
                    default:
                        user.setCountry(User.Country.OTHER);
                        break;
                }
                this.users.add(user);
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
