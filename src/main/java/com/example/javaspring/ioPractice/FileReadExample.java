package com.example.javaspring.ioPractice;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class FileReadExample {
    public static void main(String[] args) {
        String filePath = "파일 경로"; // 파일 경로를 여기에 지정하세요.
        ArrayList<byte[]> byteList = new ArrayList<>();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath), 15)) {
            byte[] buffer = new byte[15];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                byte[] data = new byte[bytesRead];
                System.arraycopy(buffer, 0, data, 0, bytesRead);
                byteList.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
