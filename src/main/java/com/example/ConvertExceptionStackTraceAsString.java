package com.example;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ConvertExceptionStackTraceAsString {
    public static void main(String[] args) {
        try {
            int division = 0 / 0;
        } catch (ArithmeticException ex) {
            try(StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw)) {
                StringBuilder sb = new StringBuilder();
                sb.append(String.format("Exception message: %s \n\n", ex.getMessage()));
                ex.printStackTrace(pw);
                String exceptionAsString = sw.toString();
                sb.append(String.format("Exception Stack Trace: %s", exceptionAsString));
                System.out.println(sb.toString());
            } catch (Exception e){}
        }
    }
}
