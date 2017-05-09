package com.company;

/**
 * Created by wangmeng on 17/5/9.
 */
public class Chapter4 {

    public static class MaxArray {
        int low;
        int high;
        int value;

        public MaxArray(int low, int high, int value) {
            this.low = low;
            this.high = high;
            this.value = value;
        }
    }

    public static MaxArray findMaxCrossingSubarray(int[] A, int low, int mid, int high) {
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
        return new MaxArray(maxLeft, maxRight, leftSum + rightSum);
    }

    public static MaxArray findMaximumSubarray(int[] A, int low, int high) {

        if (high == low) {
            return new MaxArray(low, high, A[low]);
        } else {
            int mid = (low + high) / 2;


            MaxArray leftArray = findMaximumSubarray(A, low, mid);
            int leftLow = leftArray.low;
            int leftHigh = leftArray.high;
            int leftSum = leftArray.value;

            MaxArray rightArray = findMaximumSubarray(A, mid + 1, high);
            int rightLow = rightArray.low;
            int rightHigh = rightArray.high;
            int rightSum = rightArray.value;


            MaxArray crossArray = findMaxCrossingSubarray(A, low, mid, high);
            int crossLow = crossArray.low;
            int crossHigh = crossArray.high;
            int crossSum = crossArray.value;

            if (leftSum >= rightSum && leftSum >= crossSum) {
                return new MaxArray(leftLow, leftHigh, leftSum);

            } else if (rightSum >= leftSum && rightSum >= crossSum) {
                return new MaxArray(rightLow, rightHigh, rightSum);

            } else {
                return new MaxArray(crossLow, crossHigh, crossSum);
            }
        }
    }

    // 矩阵的乘法运算，C11 = A11 * B11 + A12 * B12;依次类推。
    public static int[][] squareMatrixMultiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}
