package com.leetcode.solutions.strings;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class UniqueLetterStrings {
    public static int uniqueLetterString(String s) {
        int count = 0;

        for (int from = 0; from < s.length(); from++) {
            for (int to = from + 1; to <= s.length(); to++) {
                count += countUnique(s.substring(from, to));
            }
        }

        return count%1000000007;
    }

    private static int countUnique(String word){
        List<Character> outputList = new ArrayList<>();
        Map<Character, Integer> wordCountMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            wordCountMap.merge(c, 1, Integer::sum);
        }
        wordCountMap.forEach((k,v)->{
            if(v == 1){
                outputList.add(k);
            }
        });
        return outputList.size()%1000000007;
    }

    public static void main(String[] args) {
        System.out.println(uniqueLetterString("ABA"));
    }
}
