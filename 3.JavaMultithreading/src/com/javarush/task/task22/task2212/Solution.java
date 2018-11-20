package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static boolean checkTelNumber(String telNumber) {
//        if (telNumber.startsWith("+")){
//            String newwww = telNumber.replaceAll("[()]", "");
//            String www = telNumber.replaceAll("[\\D]", "");
////            System.out.println(www);
//            if (www.length()==12) return true;
//            else return false;
//        }
//        else if (telNumber.startsWith("(")||telNumber.startsWith("[0-9]")){
//            String newwww = telNumber.replaceAll("[()-]", "");
//            System.out.println(newwww);
//            if (newwww.length()==10) return true;
//            else return false;
//        }
//        return false;
        return (telNumber!=null&&(telNumber.matches("^\\+[\\(\\-]?(\\d[\\(\\)\\-]?){11}\\d$") ||
                telNumber.matches("^\\(?(\\d[\\-\\(\\)]?){9}\\d$"))
                && telNumber.matches("[\\+]?\\d*(\\(\\d{3}\\))?\\d*\\-?\\d*\\-?\\d*\\d$"));
    }

    public static void main(String[] args) {

        System.out.println(checkTelNumber("+38(097)2474235"));
        System.out.println(checkTelNumber("097247-4235"));
        String[] s = {
                "",
                "+380501234567",
                "+38(050)1234567",
                "+38050123-45-67",
                "050123-4567",
                "+38)050(1234567",
                "+38(050)1-23-45-6-7",
                "050ххх4567",
                "0501236",
                "(0)501234567",
                "+38(050)1-23-45--6-7",
                "+3-8(050)1-23-45--6-7",
                "+38050123-4567-"
        };

        for (String t : s) System.out.printf("%25s :   %5s %n",t,checkTelNumber(t));


    }
    public static boolean checkMail (String mail){
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";//url
        return mail.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    }
}
