package com.example.javaspring.codingTest;

public class Palin {
    public static void main(String[] args) {
        Palin test = new Palin();
        boolean result = test.isPalindrome("A man, a plan, a canal: Panama A man, a plan, a canal: Panama");
        System.out.println("result: " + result);
    }

    public boolean isPalindrome(String s) {
        
        String palinS = "";
        String reverS = "";
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (Character.isLetterOrDigit(a)) {
                palinS += String.valueOf(Character.toUpperCase(a));
                reverS = String.valueOf(Character.toUpperCase(a)) + reverS;
            }
            System.out.println("painS: " + palinS + " reverS: " + reverS);
        }
        if (palinS == null) {
            return false;
        }
        if (palinS.length() == 0) {
            return true;
        }
        if (palinS.equals(reverS)) {
            return true;
        }
        return false;
    }
}
