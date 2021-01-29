package com.example.algorithms.md5;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ObjectChecksum {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String s1 = "Manish";
        String s2 = "Manish";
        System.out.println(getChecksum(s1));
        System.out.println(getChecksum(s2));
        System.out.println(getChecksum(s1).equals(getChecksum(s1)));
    }

    public static String getChecksum(Serializable object) throws IOException, NoSuchAlgorithmException {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(baos.toByteArray());
            return DatatypeConverter.printHexBinary(thedigest);
        } finally {
            oos.close();
            baos.close();
        }
    }
}
