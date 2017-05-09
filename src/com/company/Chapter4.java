package com.company;

/**
 * Created by wangmeng on 17/5/9.
 */
public class Chapter4 {

    public static void findMaxCrossingSubarray(int[] A, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int maxLeft = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i >= low; i--) {
            sum = sum + A[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum = sum + A[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }
        System.out.println("maxLeft = " + maxLeft + " | leftSum = " + leftSum + " || maxRight = " + maxRight + " | rightSum = " + rightSum);
    }
}
