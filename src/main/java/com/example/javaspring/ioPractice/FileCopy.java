package com.example.javaspring.ioPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy  {
    public static void main(String[] args) {
        try (
            FileInputStream fileInputStream = new FileInputStream("/Users/minsang/study/streamTest.md");
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/minsang/study/copyStreamTest.md");
        ){
            byte[] temp = new byte[8192];

            long start = System.currentTimeMillis();
            while(fileInputStream.read(temp)!=-1){
                fileOutputStream.write(temp);
            }
            long end = System.currentTimeMillis();
            System.out.println((end-start)/1000.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
