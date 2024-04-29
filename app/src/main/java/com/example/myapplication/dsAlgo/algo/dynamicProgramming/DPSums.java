package com.example.myapplication.dsAlgo.algo.dynamicProgramming;

import com.example.myapplication.dsAlgo.Utility;

public class DPSums {

    public static void main(String[] args) {
//        noOfPaths(10, 10);
        optimalKeys(11);
    }

    /**
     * noOfPaths
     * <a href="https://leetcode.com/problems/unique-paths/description/">Link</a>
     * The problem is to count all the possible paths from top left to bottom right of an MxN matrix
     * with the constraints that from each cell you can either move to right or down.
     */
    private static void noOfPaths(int M, int N) {
        // since we can say that in 0th row, all the cells have only 1 path - just horizontal line
        // since we can say that in 0th column, all the cells have only 1 path - just vertical line
        // we can store these results and any other cell path is sum of [i-1][j] and [i][j-1]
        int[][] arr = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 1;
                }
            }
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        System.out.println(arr[M - 1][N - 1]);
    }

    /**
     * optimalKeys
     * <a href="https://www.geeksforgeeks.org/problems/special-keyboard3018/1">Link</a>
     * <p>
     * here used, Bottom up -> tabulation -> iteration
     * another ,  Top Down -> memorization -> recursion
     */
    static void optimalKeys(int N) {

        int[] arr = new int[N + 1];

        for (int i = 0; i <= 6; i++) {
            arr[i] = i;
        }
        for (int i = 7; i <= N; i++) {
            arr[i] = max(i, arr);
        }
        Utility.printArray(arr);
    }

    static int max(int i, int[] arr) {
        int max = 0;
        int curr = i - 3;
        int multiplier = 2;
        while (curr > 0) {
            int poss = arr[curr] * multiplier;
            max = Math.max(max, poss);
            curr = curr - 1;
            multiplier++;
        }
        return max;
    }


    private static void longestIncreasingSubsequence(int[] arr){
        int[] dp = new int[arr.length];
        for(int i=0; i<arr.length; i++){

        }
    }
}
