package com.example.javaspring.codingTest.java;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class tesgt {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
//        ArrayList<String> arr = new ArrayList<>();
//
//        StringBuilder sb = new StringBuilder();
//        arr.forEach(sb::append);
//
//        Child newChild = new Child();
//        newChild.test();
//
//        Parent parent = newChild;
//        parent.test();
//

//        OkGoogle okGoogle = new OkGoogle();

//        String korean = "자바를 자바라";
//        byte[] bytes = korean.getBytes(StandardCharsets.UTF_8);
//        for (byte data : bytes) {
//            System.out.print(data + " ");
//            System.out.println(bytes.length);
//        }
//        String newKorean = new String(bytes, StandardCharsets.UTF_8);
//        System.out.println(newKorean);

//
//        tesgt t = new tesgt();
//        OOP oop = new t.new OOP();

        //List t = new A();
//
//        ArrayList<String> list = new ArrayList<>();
//        list.add("1");
//
//        String[] tempArray = new String[3];
//        String[] strList = list.toArray(tempArray);
//        for (String temp : strList) {
//            System.out.println("temp = " + temp);
//        }
//
//        ArrayList<String> list2 = new ArrayList<>();
//        list2.add("1");
//        list2.add("2");
//
//        String[] tempArray2 = new String[1];
//        String[] strList2 = list.toArray(tempArray2);
//        for (String temp : strList2) {
//            System.out.println("temp = " + temp);
//        }
//
//        WeakReference<StringBuilder> reference = new WeakReference<>(new StringBuilder());
//
//        String originS = "h";
//        //originS = originS + "e" + "llo";
//        originS = originS.concat("e").concat("llo");

//        List<Integer> elements = new ArrayList<>();
//
//        Iterator<Integer> iterator = elements.iterator();
//
//        while (iterator.hasNext()) {
//            System.out.println("iterator.next() = " + iterator.next());
//        }
//
//        elements.forEach((Integer element) -> {
//            System.out.println("element = " + element);
//        });
//
//        elements.forEach(element -> System.out.println("element = " + element));
//
//        tesgt t = new tesgt();
//        tesgt.Human human = t.new Human(10, 10);
//
//        Map<Human, Integer> map = new HashMap<>();
//        map.put(human, 10);
//
//        if (map.containsKey(human)) {
//            System.out.println("map.get(human) = " + map.get(human));
//        }
//
//        human.setAge(50); // 이제 해시코드값도 바뀜
//
//        if (map.containsKey(human)) {
//            System.out.println("map에서 꺼냄: map.get(human) = " + map.get(human));
//        } else {
//            System.out.println("human = " + human);
//        }

        String originalString = "테스트";
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(originalString.getBytes(StandardCharsets.UTF_16));

        System.out.println("bytesToHex(encodedHash) = " + bytesToHex(encodedHash));


    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    class Human {
        private int age;
        private int num;

        public Human(int age, int num) {
            this.age = age;
            this.num = num;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Human human = (Human) o;
            return age == human.age && num == human.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, num);
        }

        @Override
        public String toString() {
            return "Human{" +
                "age=" + age +
                ", num=" + num +
                '}';
        }
    }

    public class OOP {
        public void test() {
            System.out.println("OOP");
        }
    }


    public static class Parent {
        public void test() {

        }

    }

    public static class Child extends Parent {
        public void test() {
            System.out.println("ho");
        }
    }
}
