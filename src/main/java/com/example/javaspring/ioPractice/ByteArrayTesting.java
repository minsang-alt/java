package com.example.javaspring.ioPractice;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayTesting {
    public static void main(String[] args) {
        byte[] src = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        byte[] dst;

        byte[] temp = new byte[4];

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(src);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int len;
        try {
            while ((len = byteArrayInputStream.read(temp)) != -1) {
                byteArrayOutputStream.write(temp,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        dst = byteArrayOutputStream.toByteArray();
        System.out.println("Arrays.toString(dst) = " + Arrays.toString(dst));


    }
}
