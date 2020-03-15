package com.leetcode.solutions.strings;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {
    private static boolean process(String a, String b, String c, Map<String, Boolean> map){
        if (a.isEmpty() && b.isEmpty() && c.isEmpty()) return true;
        if (a.length() + b.length() != c.length()) return false;
        StringBuilder key = new StringBuilder(a);
        key.append(" ").append(b).append(" ").append(c);
        if (!map.containsKey(key.toString())){
            boolean resultOne = false;
            boolean resultTwo = false;
            if (!a.isEmpty() && a.charAt(0) == c.charAt(0)){
                resultOne = process(a.substring(1), b, c.substring(1), map);
            }
            if (!b.isEmpty() && b.charAt(0) == c.charAt(0)){
                resultTwo = process(a, b.substring(1), c.substring(1), map);
            }
            map.put(key.toString(), resultOne || resultTwo);
        }
        return map.get(key.toString());
    }

    private static boolean isInterleave(String s1, String s2, String s3) {
        return process(s1, s2, s3, new HashMap<>());
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabc","abad","aabacbad"));
    }
}
