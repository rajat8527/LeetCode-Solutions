package com.leetcode.solutions.strings;

import java.util.*;

public class ScrambledString {
    private static boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;

        if(s1.length() == 0 || s1.equals(s2))
            return true;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(!new String(arr1).equals(new String(arr2))){
            return false;
        }

        for(int i=1; i<s1.length(); i++){
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            if(isScramble(s11, s21) && isScramble(s12, s22)){
                return true;
            }
            s21 = s2.substring(0, s2.length()-i);
            s22 = s2.substring(s2.length()-i);
            if(isScramble(s11, s21) && isScramble(s12, s22)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isScramble("great","rgeat"));
    }
}
