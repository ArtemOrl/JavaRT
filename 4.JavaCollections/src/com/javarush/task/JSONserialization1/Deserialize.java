package com.javarush.task.JSONserialization1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.StringReader;

public class Deserialize {
    public static void main(String[] args) throws Throwable{
        String jsonString = "{ \"name\":\"Murka\", \"age\":5, \"weight\":4}";
        StringReader reader = new StringReader(jsonString);

        ObjectMapper mapper = new ObjectMapper();

        Cat cat = mapper.readValue(reader, Cat.class);
    }
}
