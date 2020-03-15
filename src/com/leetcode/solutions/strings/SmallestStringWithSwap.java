package com.leetcode.solutions.strings;

import java.util.*;
import java.util.stream.Collectors;

public class SmallestStringWithSwap {
    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
      char[] a = s.toCharArray();
      pairs.sort(Comparator.comparing(e -> e.get(0)));
      List<String> stringList = new ArrayList<>();
      for(List<Integer> x : pairs){
          char temp = a[x.get(0)];
          a[x.get(0)] = a[x.get(1)];
          a[x.get(1)] = temp;
          stringList.add(new String(a));
      }
      Collections.sort(stringList);
      System.out.println(stringList);
      return stringList.get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0,1));
        pairs.add(Arrays.asList(1,2));
        smallestStringWithSwaps("cba", pairs);
    }
}
