package com.example.javaspring.chap02.book;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if (s == null || s.isEmpty()) return PasswordStrength.INVALID;

        boolean lengthEnough = s.length() >= 8;
        boolean containsNum = meetsContainingNumberCriteria(s);
        boolean containsUpp = meetsContainingUppercaseCriteria(s);

        if(lengthEnough && !containsNum && !containsUpp)
            return PasswordStrength.WEAK;
        if(!lengthEnough && containsNum && !containsUpp)
            return PasswordStrength.WEAK;
        if(!lengthEnough && !containsNum && containsUpp)
            return PasswordStrength.WEAK;


        if (!lengthEnough) return PasswordStrength.NORMAL;
        if (!containsNum) return PasswordStrength.NORMAL;
        if (!containsUpp) return PasswordStrength.NORMAL;


        return PasswordStrength.STRONG;
    }

    private boolean meetsContainingNumberCriteria(String s) {
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingUppercaseCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }
}
