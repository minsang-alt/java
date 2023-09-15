package com.example.javaspring.chap02;

public class Password {
    final static int limitLength = 8;
    public static boolean checkLength(String password){
        return password.length() >= limitLength;
    }

    public static boolean checkNumber(String password){
        for (char c : password.toCharArray()) {
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkUpperCase(String password){
        for (char c : password.toCharArray()) {
            if(Character.isUpperCase(c)){
                return true;
            }
        }
        return false;
    }

    public static String check(String password) {
        int passNum = 0;
        if (checkNumber(password)) passNum++;
        if (checkLength(password)) passNum++;
        if (checkUpperCase(password)) passNum++;

        if (passNum == 3) return "Strength";
        else if (passNum > 1) return "Normal";


        return "Weak";

    }
}
