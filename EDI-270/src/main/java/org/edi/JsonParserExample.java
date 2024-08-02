package edi;

import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParserExample {
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"John\", \"age\":30}";
        ObjectMapper mapper = new ObjectMapper();

        try {
            Person person = mapper.readValue(jsonString, Person.class);
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Person {
        private String name;
        private int age;

        // Getters and setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
    }
}

