package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) throws NullPointerException {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("Country", "Ukraine");
        map.put("city", "Kiev");
//        map.put("name", null);
//        map.put("Country", null);
//        map.put("city", null);
        map.put("age", null);

        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params)throws NullPointerException {

        String result = "";
        String template;
        for (Map.Entry<String, String> pair : params.entrySet()){
            if (pair.getValue()!=null){//(!(pair.getValue().equals("null")))&&pair.getKey()!=null&&
                template = "%s = '%s' and ";
                String temp = String.format(template, pair.getKey(), pair.getValue());
                result += temp;
            }
        }
        if (!(result.equals(""))) result = result.substring(0, result.lastIndexOf(" and"));
        return result;
    }
}
