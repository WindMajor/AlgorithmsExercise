package com.company;

/**
 * Created by wangmeng on 17/5/8.
 */
public class Chapter2 {


    public static int[] insertionSort_A(int[] A) {
        int key, i;
        for (int j = 1; j < A.length; j++) {
            key = A[j];
            i = j - 1;
            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }
        return A;
    }

    public static int[] merge(int[] A, int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        //把数组的排好序的左半边赋值给L
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }

        //把数组的排好序的右半边赋值给R
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }

        //在比大小的过程中保证一定大于
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        // 小的放左边，大的方右边
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i = i + 1;
            } else {
                A[k] = R[j];
                j = j + 1;
            }
        }
        return A;
    }

    public static int[] mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
        return A;
    }
}
