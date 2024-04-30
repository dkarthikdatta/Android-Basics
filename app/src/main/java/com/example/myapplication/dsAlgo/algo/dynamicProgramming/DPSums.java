package com.example.myapplication.dsAlgo.algo.dynamicProgramming;

import com.example.myapplication.dsAlgo.Utility;

import java.util.Arrays;

public class DPSums {

    public static void main(String[] args) {
//        noOfPaths(10, 10);
//        optimalKeys(11);

        System.out.println("Max cuts: " + maximizeCuts(7, 5, 5, 2));
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


    private static void longestIncreasingSubsequence(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

        }
    }


    //Function to find the maximum number of cuts.
    public static int maximizeCuts(int n, int x, int y, int z) {
        int min = Math.min(x, y);
        min = Math.min(min, z);

        if (n < min) {
            return 0;
        }

        int[] dp = new int[n + 1];

        for (int i = 0; i < min; i++) {
            dp[i] = 0;
        }
        System.out.println(Arrays.toString(dp));

        for (int i = min; i <= n; i++) {
            int xcut = 0, ycut = 0, zcut = 0;
            if (i - x == 0 || (i - x > 0 && dp[i - x] != 0)) {
                xcut = dp[i - x] + 1;
            }
            if (i - y == 0 || (i - y > 0 && dp[i - y] != 0)) {
                ycut = dp[i - y] + 1;
            }
            if (i - z == 0 || (i - z > 0 && dp[i - z] != 0)) {
                zcut = dp[i - z] + 1;
            }
            dp[i] = Math.max(xcut, ycut);
            dp[i] = Math.max(dp[i], zcut);
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }

}
