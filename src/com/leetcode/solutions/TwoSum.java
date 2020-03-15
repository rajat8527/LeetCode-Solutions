package com.leetcode.solutions;

import java.util.*;

public class TwoSum {
    private static int[] twoSum(int[] nums, int target) {
       List<Integer> integerList = new ArrayList<>();
       List<Integer> indexList = new ArrayList<>();
        Map<Integer, Integer> indexMap = new TreeMap<>();
       for(int i : nums){
           integerList.add(i);
       }
       for(int i = 0; i < integerList.size(); i++){
           for(int j = 1; j < integerList.size(); j++){
               if(integerList.get(i)+integerList.get(j) == target){
                   if(indexMap.containsKey(i) || indexMap.containsKey(j)){
                       break;
                   }else{
                       indexMap.put(i, integerList.get(i));
                       indexMap.put(j, integerList.get(j));
                   }
               }
           }
       }
       indexMap.forEach((k,v) -> indexList.add(k));
       int[] index = new int[indexList.size()];
       for(int i = 0; i < indexList.size(); i++){
           index[i] = indexList.get(i);
       }
        for (Integer integer : indexList) {
            System.out.println(integer);
        }
       return index;
    }

    public static void main(String[] args) {
       twoSum(new int[]{2,5,5,11}, 9);
    }
}
