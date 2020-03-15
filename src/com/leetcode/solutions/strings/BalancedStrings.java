package com.leetcode.solutions.strings;

public class BalancedStrings {
    private static int balancedStringSplit(String s) {
        int balance = 0;
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'L'){
                if(balance == 0){
                    answer++;
                }
                balance++;
            }else{
                if(balance == 0){
                    answer++;
                }
                balance--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));;
    }
}
