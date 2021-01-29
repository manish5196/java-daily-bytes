package com.example;

import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;

public class HTMLToText {

    public static void main(String[] args) throws IOException {
        File file  = new File("src/input/PDF.html");
        final String s = Jsoup.parse(file, "UTF-8")
                              .wholeText();

        System.out.println(s);
    }
}
