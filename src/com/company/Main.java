package com.company;

public class Main {

    private static int[] A = new int[]{3, 5, 2, 9, 1, 8, 4, 6, 0, 7};
    private static int[] B = new int[]{6, 7, 8, 9, 0, 1, 2, 3, 4, 5};
    private static int[] C = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 28, -7, 12, -5, -22, 15, -4, 7};

    public static void main(String[] args) {
        // write your code here

        int[] ints = Chapter2.insertionSort_A(A);

//        for (int i = 0; i < ints.length; i++) {
//            System.out.println("ints[" + i + "] = " + ints[i]);
//        }

//        int[] result = Chapter2.mergeSort(A, 0, 0);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println("result[" + i + "] = " + result[i]);
//        }

        Chapter4.findMaxCrossingSubarray(C, 0, 1, 15);
    }
}
