package com.leetcode.solutions.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    private static int longestStrChain(String[] words) {
        Arrays.sort(words , Comparator.comparingInt(String::length));
        Map<String, Integer> wordLengthMap = new HashMap<>();
        int count = 0;
        for (String word : words) {
            int pointer = 1;
            StringBuilder sb = new StringBuilder(word);
            for(int i = 0 ; i < word.length() ; i++) {
                char c = sb.charAt(i);
                String tempWord = sb.deleteCharAt(i).toString();
                if(wordLengthMap.containsKey(tempWord)) {
                    pointer = Math.max(pointer, wordLengthMap.get(tempWord)+1);
                }
                sb.insert(i, c);
            }
            wordLengthMap.put(word, pointer);
            count = Math.max(count, pointer);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }
}
