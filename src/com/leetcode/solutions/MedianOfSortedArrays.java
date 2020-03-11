package com.leetcode.solutions;

public class MedianOfSortedArrays {
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];

        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        while (leftPointer < nums1.length || rightPointer < nums2.length) {
            if (leftPointer < nums1.length && rightPointer < nums2.length) {

                if (nums1[leftPointer] < nums2[rightPointer]) {
                    result[resultPointer++] = nums1[leftPointer++];
                } else {
                    result[resultPointer++] = nums2[rightPointer++];
                }
            } else if (leftPointer < nums1.length) {
                result[resultPointer++] = nums1[leftPointer++];
            } else if (rightPointer < nums2.length) {
                result[resultPointer++] = nums2[rightPointer++];
            }

        }

        int mid = result.length/2;

        if (result.length % 2 == 1){
            return result[mid];
        }
        else{
            return (double)(result[mid-1] + result[mid]) / 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
}
