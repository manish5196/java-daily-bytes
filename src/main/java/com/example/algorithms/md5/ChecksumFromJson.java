package com.example.algorithms.md5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.DatatypeConverter;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class ChecksumFromJson {
    public static void main(String[] args) throws NoSuchAlgorithmException, JsonProcessingException {
        Map<String,Object> payload = new HashMap<>();
        payload.put("person", new Person("xxxx", "f", 90));

        String json = new ObjectMapper().writeValueAsString(payload);

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(json.getBytes());
        String hash = DatatypeConverter.printHexBinary(thedigest);

        System.out.println(hash);
    }
}

class Person implements Serializable {
    String name;
    String gender;
    int age;

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
