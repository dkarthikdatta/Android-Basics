package com.example.myapplication.dsAlgo.algo.dynamicProgramming;

import com.example.myapplication.dsAlgo.Utility;

import java.util.Arrays;

public class DpOnStocks {

    public static void main(String[] args) {
        int ans = maximumSumSubsequence(new int[]{0, 3, 3, 3, 1, -2}, new int[][]{
                {4, 0}, {1, 0}
        });
        System.out.println(ans);
//        System.out.println(maxSubSeq(new int[]{-3, -5, 9}));
    }

    public static int maximumSumSubsequence(int[] nums, int[][] queries) {
        int ans = 0;
        for (int i = 0; i < queries.length; i++) {
            nums[queries[i][0]] = queries[i][1];
            Utility.printArray(nums);
            int currAns = maxSubSeq(nums);
            ans = ans + currAns;
            System.out.println("i = " + i + " ans = " + currAns);
        }
        return ans;
    }

    private static int maxSubSeq(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxSubSeqUtil(nums, dp, nums.length - 1);
    }

    private static int maxSubSeqUtil(int[] nums, int[] dp, int index) {
        if (index < 0) {
            return 0;
        }
        if (index == 0) {
            return Math.max(nums[index], 0);
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int take = nums[index] + maxSubSeqUtil(nums, dp, index - 2);
        int noTake = 0 + maxSubSeqUtil(nums, dp, index - 1);
        return dp[index] = Math.max(take, noTake);
    }
}
