package com.javarush.task.JSONSerialization2;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws JsonGenerationException, IOException, IOException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jeferson";

        House house = new House();
        house.pets.add(dog);
        house.pets.add(cat);

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, house);
        System.out.println(writer.toString());
    }
}
