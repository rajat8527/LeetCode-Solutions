package com.leetcode.solutions.strings;

public class MinSwapToMakeStringEqual {
    public static int minimumSwap(String s1, String s2) {
        char[] charS1 = s1.toCharArray();
        char[] charS2 = s2.toCharArray();

        if(charS1.length != charS2.length){return -1;}

        int countX = 0;
        int countY = 0;

        for(int i=0;i<charS1.length;i++){
            if(charS1[i]==charS2[i]){
                continue;
            }
            if(charS1[i]=='x'){
                countX++;
            }
            if(charS1[i]=='y'){
                countY++;
            }
        }

        if((countX+countY)%2!=0){return -1;}

        int minSwap = countX/2+countY/2;

        if((countX%2+countY%2)!=0){
            minSwap+=2;
        }

        return minSwap;
    }

    public static void main(String[] args) {
        System.out.println(minimumSwap("xx","yy"));
    }
}
