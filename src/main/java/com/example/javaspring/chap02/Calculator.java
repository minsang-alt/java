package com.example.javaspring.chap02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

    public Integer calcSum(String filePath) throws IOException {
        BufferedReaderCallback<Integer> sumCallback = new BufferedReaderCallback<>() {
            @Override
            public Integer doSomethingWithReader(String line, Integer val) throws IOException {
                return val + Integer.valueOf(line);
            }
        };

        return fileReadTemplate(filePath, sumCallback, 0);
    }


    public <T> T fileReadTemplate(String filepath, BufferedReaderCallback<T> callback, T initial)
        throws IOException {
        BufferedReader br = null;

        try {
            br = new BufferedReader((new FileReader(filepath)));
            T res = initial;
            String line = null;
            while ((line = br.readLine()) != null) {
                res = callback.doSomethingWithReader(line, res);
            }

            return res;
        } catch (IOException e) {
            System.out.println("e = " + e);
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
