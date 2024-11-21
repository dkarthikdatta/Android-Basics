package com.example.myapplication.dsAlgo.algo.dynamicProgramming;

import com.example.myapplication.dsAlgo.Utility;
import com.example.myapplication.sdk.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Tabulation - bottom-up - iteration
 * Memorization - Top-down - recursion
 * <p>
 * 1. count distinct ways
 * 2. find all possible ways
 * 3. find min way
 * 4. find max way
 * 4. find best way
 * <p>
 * use (int) Math.pow(-10, 9) instead of Integer.MIN_VALUE -> practical use
 * https://chatgpt.com/c/bdebfd5d-ad60-46c4-8cfd-08c559921f7e
 */

// projects
// android dev
// kotlin - dsa
public class StriverDP {

    public static void main(String[] args) {
        uniquePathIn2DArray(3, 3);
    }
//    public static void main(String[] args) {
//        nonDPfibonacci(40);
//        memorizationFibonacci(40);
//        tabulationFibonacci(40);
//
////         noExtraSpaceDP(40) // using prev and prev2
//
////        https://www.naukri.com/code360/problems/count-ways-to-reach-nth-stairs_798650?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
//        climbStairs(); // count distinct ways // same as fibonacci
//
////      https://www.naukri.com/code360/problems/frog-jump_3621012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
//        // frog can jump one step or two step. find min energy required to reach end step such that it consumes min energy by jumping either one or two steps.
//        frogJumpRecursion();
//        memorizationFrogJump(new int[]{20, 30, 40, 20});
//        tabulationFrogJump(new int[]{20, 30, 40, 20});
//
////      https://atcoder.jp/contests/dp/tasks/dp_b
//        // same sum, solve when frog can jump k steps
//        tabulationFrogJumpKSteps(new int[]{20, 30, 40, 20, 40, 40, 50, 60}, 4);
//
////      https://www.naukri.com/code360/problems/maximum-sum-of-non-adjacent-elements_843261?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
//        // max sum of subsequence where you should pick non adjacent numbers
//        tabulationNonAdjSubsequnceMaxSum(new int[]{-3, -5, 9});
//        memorizationNonAdjSubsequnceMaxSum(new int[]{-3, -5, 9});
//
////      https://www.youtube.com/watch?v=AE39gJYuRog&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=8
////      https://www.naukri.com/code360/problems/ninja-s-training_3621003?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
//        ninjaTraining(3, new int[][]{
//                {1, 2, 5},
//                {3, 1, 1},
//                {3, 3, 3}
//        });
////        tabulationninjaTraining(3, new int[][]{
////                {1, 2, 5},
////                {3, 1, 1},
////                {3, 3, 3}
////        });
//
////          https://www.naukri.com/code360/problems/total-unique-paths_1081470?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
////        uniquePathIn2DArray(3, 3);
////        uniquePathIn2DArrayMaze(new int[][]{
////                {0, 0, 0},
////                {0, 0, 0},
////                {0, 0, 0}
////        });
//
//        ArrayList<Integer> one = new ArrayList<>(Arrays.asList(0, 0, 0));
//        ArrayList<Integer> two = new ArrayList<>(Arrays.asList(0, -1, 0));
//        ArrayList<Integer> three = new ArrayList<>(Arrays.asList(0, 0, 0));
////
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//        ans.add(one);
//        ans.add(two);
//        ans.add(three);
////
////          https://www.naukri.com/code360/problems/maze-obstacles_977241?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
//        mazeObstacles(ans);
//
////      https://www.naukri.com/code360/problems/minimum-path-sum_985349?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
////        minimumSumPath(new int[][]{
////                {8, 1, 6},
////                {4, 4, 16},
////                {2, 7, 20},
////                {20, 7, 20}
////        });
//
////        minimumSumPathTabulation(new int[][]{
////                {8, 1, 6},
////                {4, 4, 16},
////                {2, 7, 20},
////                {20, 7, 20}
////        });
//
////        int ans = getMaxPathSumVariableStart(new int[][]{
////                {1, 2, 10, 4},
////                {100, 3, 2, 1},
////                {1, 1, 20, 2}
////        });
////        System.out.println(ans);
//
////      https://www.naukri.com/code360/problems/maximum-path-sum-in-the-matrix_797998?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
////        int ans1 = getMaxPathSumVariableStart(new int[][]{
////                {10, 10, 2, -13, 20, 4},
////                {1, -9, -81, 30, 2, 5},
////                {0, 10, 4, -79, 2, -10},
////                {1, -5, 2, 20, -11, 4}
////        });
////        System.out.println(ans1);
////
////        int ans2 = getMaxPathSumVariableStartTabulation(new int[][]{
////                {10, 10, 2, -13, 20, 4},
////                {1, -9, -81, 30, 2, 5},
////                {0, 10, 4, -79, 2, -10},
////                {1, -5, 2, 20, -11, 4}
////        });
////        System.out.println(ans2);
//
////      https://www.naukri.com/code360/problems/subset-sum-equal-to-k_1550954?leftPanelTab=1%3Fsource%3Dyoutube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
////        subsetSumToK(4, 4, new int[]{6, 1, 2, 1});
////        subsetSumToKTabulation(4, 4, new int[]{6, 1, 2, 1});
//
//        int[] weights = {1, 2, 4, 5};
//        int[] values = {5, 4, 8, 6};
//        int maxWeight = 5;
//
////        zeroOneKnapSackRecursion(weights, values, maxWeight);
////        zeroOneKnapSackMemorization(weights, values, maxWeight);
////        zeroOneKnapSackTabulation(weights, values, maxWeight);
//
////        int[] coins = {12, 1, 3};
////        minimumCoinsRecursion(coins, 4);
////        minimumCoinsDp(coins, 4);
//
////        int[] denominations = {1, 2, 3};
////        countWaysToMakeChangeRecursion(denominations, 4);
////        countWaysToMakeChangeDp(denominations, 4);
////
////        String s1 = "adebc";
////        String s2 = "dcadb";
////
////        longestCommonSubsequenceDp(s1, s2);
////        longestCommonSubsequenceDpTabulation(s1, s2);
////        letterCombinations("23");
//    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Character, ArrayList<Character>> hm = new HashMap<>();
        hm.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        hm.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        hm.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        hm.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        hm.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        hm.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        hm.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        hm.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            list.add(hm.get(digits.charAt(i)));
        }

        ArrayList<String> ans = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        letterCombinationsUtil(ans, hm, sb, digits, 0);
//        Utility.printArrayListString(ans);
        return ans;
    }

    private static void letterCombinationsUtil(ArrayList<String> ans, HashMap<Character, ArrayList<Character>> hm, StringBuilder sb, String digits, int i) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
//            System.out.println("limit reached, sb = " + sb);
            return;
        }
//        System.out.println("Current i = " + i );
        ArrayList<Character> chars = hm.get(digits.charAt(i));
        for (int j = 0; j < chars.size(); j++) {
            // Choose a character and add it to the combination
//            System.out.println("inside for Current i = " + i );
//            System.out.println("inside for Current j = " + j );
//            System.out.println("inside for appending c = " + chars.get(j));
            sb.append(chars.get(j));
            // Recurse to the next digit
            letterCombinationsUtil(ans, hm, sb, digits, i + 1);
            // Backtrack: remove the last added character
//            System.out.println("inside for deleting c = " + chars.get(sb.length() - 1));
            sb.deleteCharAt(sb.length() - 1);
        }

    }


    private static void longestCommonSubsequenceDpTabulation(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
    }

    private static void longestCommonSubsequenceDp(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        System.out.println(longestCommonSubsequenceDpUtil(s1, s2, s1.length() - 1, s2.length() - 1, dp));
    }

    private static int longestCommonSubsequenceDpUtil(String s1, String s2, int index1, int index2, int[][] dp) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }
        if (s1.charAt(index1) == s2.charAt(index2)) {
            return dp[index1][index2] = 1 + longestCommonSubsequenceDpUtil(s1, s2, index1 - 1, index2 - 1, dp); // if both chars same, decrease the index for both
        }
        // checking if reducing index of either string produces max length
        return dp[index1][index2] = Math.max(longestCommonSubsequenceDpUtil(s1, s2, index1 - 1, index2, dp), longestCommonSubsequenceDpUtil(s1, s2, index1, index2 - 1, dp));
    }

    private static void countWaysToMakeChangeDp(int[] denominations, int value) {
        int[][] dp = new int[denominations.length][value + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        System.out.println(countWaysToMakeChangeDpUtil(denominations, dp, value, denominations.length - 1));
    }

    private static int countWaysToMakeChangeDpUtil(int[] denominations, int[][] dp, int value, int index) {
        if (index == 0) {
            return (value % denominations[index] == 0) ? 1 : 0;
        }
        if (dp[index][value] != -1) {
            return dp[index][value];
        }
        int noTake = countWaysToMakeChangeDpUtil(denominations, dp, value, index - 1);
        int take = 0;
        if (denominations[index] <= value) {
            take = countWaysToMakeChangeDpUtil(denominations, dp, value - denominations[index], index);
        }
        return dp[index][value] = take + noTake;
    }


    private static int unboundedKnapsackUtil(int[] profit, int[] weight, int index, int maxWeight, int[][] dp) {

        if (index == 0) {
            return maxWeight % weight[index] == 0 ? ((maxWeight / weight[index]) * profit[index]) : 0;
        }

        if (dp[index][maxWeight] != -1) {
            return dp[index][maxWeight];
        }

        int noTake = unboundedKnapsackUtil(profit, weight, index - 1, maxWeight, dp);
        int take = 0;
        if (weight[index] <= maxWeight) {
            take = profit[index] + unboundedKnapsackUtil(profit, weight, index, maxWeight - weight[index], dp);
        }
        return dp[index][maxWeight] = Math.max(take, noTake);
    }

    private static void countWaysToMakeChangeRecursion(int[] denominations, int value) {
        System.out.println(countWaysToMakeChangeRecursionUtil(denominations, value, denominations.length - 1));
    }

    private static int countWaysToMakeChangeRecursionUtil(int[] denominations, int value, int index) {
        if (index == 0) {
            return (value % denominations[index] == 0) ? 1 : 0;
        }

        int noTake = countWaysToMakeChangeRecursionUtil(denominations, value, index - 1);
        int take = 0;
        if (denominations[index] <= value) {
            take = countWaysToMakeChangeRecursionUtil(denominations, value - denominations[index], index);
        }
        return take + noTake;
    }

    private static void minimumCoinsDp(int[] coins, int target) {
        int[][] dp = new int[coins.length][target + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        System.out.println(minimumCoinsDpUtil(coins, target, dp, coins.length - 1));
    }

    private static int minimumCoinsDpUtil(int[] coins, int target, int[][] dp, int index) {
        if (index == 0) {
            if (target % coins[index] == 0) {
                return target / coins[index];
            } else return (int) Math.pow(10, 9);
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int noTake = minimumCoinsDpUtil(coins, target, dp, index - 1);
        int take = Integer.MAX_VALUE;
        if (coins[index] <= target) {
            take = 1 + minimumCoinsDpUtil(coins, target - coins[index], dp, index); // since infinite, take same coin again - same index
        }
        return dp[index][target] = Math.min(take, noTake);
    }

    private static void minimumCoinsRecursion(int[] coins, int target) {
        System.out.println(minimumCoinsRecursionUtil(coins, target, coins.length - 1));
    }

    private static int minimumCoinsRecursionUtil(int[] coins, int target, int index) {
        if (index == 0) {
            if (target % coins[index] == 0) {
                return target / coins[index];
            } else return Integer.MAX_VALUE;
        }

        int noTake = minimumCoinsRecursionUtil(coins, target, index - 1);
        int take = Integer.MAX_VALUE;
        if (coins[index] <= target) {
            take = 1 + minimumCoinsRecursionUtil(coins, target - coins[index], index); // since infinite, take same coin again - same index
        }
        return Math.min(take, noTake);
    }

    private static void zeroOneKnapSackTabulation(int[] weights, int[] values, int maxWeight) {
        int[][] dp = new int[weights.length][maxWeight + 1];

        for (int index = 0; index < weights.length; index++) {
            for (int currW = 0; currW <= maxWeight; currW++) {
                if (index == 0) {
                    if (weights[index] <= currW) {
                        dp[index][currW] = values[index];
                    } else {
                        dp[index][currW] = 0;
                    }
                } else {
                    int noTake = dp[index - 1][currW];
                    int take = Integer.MIN_VALUE;
                    if (weights[index] <= currW) {
                        take = values[index] + dp[index - 1][currW - weights[index]];
                    }
                    dp[index][currW] = Math.max(take, noTake);
                }
            }
        }
        System.out.println(dp[weights.length - 1][maxWeight]);
    }

    private static void zeroOneKnapSackMemorization(int[] weights, int[] values, int maxWeight) {
        int[][] dp = new int[weights.length][maxWeight + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        System.out.println(zeroOneKnapSackMemorizationUtil(weights, values, maxWeight, weights.length - 1, dp));
    }

    private static int zeroOneKnapSackMemorizationUtil(int[] weights, int[] values, int maxWeight, int index, int[][] dp) {
        if (index == 0) {
            if (weights[0] <= maxWeight) {
                return values[0];
            } else return 0;
        }
        if (dp[index][maxWeight] != -1) {
            return dp[index][maxWeight];
        }
        int nonTake = zeroOneKnapSackMemorizationUtil(weights, values, maxWeight, index - 1, dp);
        int take = Integer.MIN_VALUE;
        if (weights[index] <= maxWeight) {
            take = values[index] + zeroOneKnapSackMemorizationUtil(weights, values, maxWeight - weights[index], index - 1, dp);
        }
        return dp[index][maxWeight] = Math.max(take, nonTake);
    }

    private static void zeroOneKnapSackRecursion(int[] weights, int[] values, int maxWeight) {
        System.out.println(zeroOneKnapSackRecursionUtil(weights, values, maxWeight, weights.length - 1));
    }

    private static int zeroOneKnapSackRecursionUtil(int[] weights, int[] values, int maxWeight, int index) {
        if (index == 0) {
            if (weights[0] <= maxWeight) {
                return values[0];
            } else return 0;
        }

        int noTake = zeroOneKnapSackRecursionUtil(weights, values, maxWeight, index - 1);
        int take = Integer.MIN_VALUE;
        if (weights[index] <= maxWeight) {
            take = values[index] + zeroOneKnapSackRecursionUtil(weights, values, maxWeight - weights[index], index - 1);
        }
        return Math.max(take, noTake);
    }

    private static void subsetSumToKTabulation(int n, int target, int[] arr) {
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        Utility.print2DArray(dp);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (i == 0) {
                    dp[i][j] = (j == arr[i]);
                    System.out.println("at index = " + i + " val = " + arr[i] + " target = " + j);
                } else {
                    boolean notTake = dp[i - 1][j];
                    boolean take = false;
                    if (arr[i] <= j) {
                        take = dp[i - 1][j - arr[i]];
                    }
                    dp[i][j] = take || notTake;
                }
            }
        }
        Utility.print2DArray(dp);
        System.out.println(dp[n - 1][target]);
    }

    public static void subsetSumToK(int n, int k, int arr[]) {
        // Write your code here.

        int[][] dp = new int[n][k + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        System.out.println(subsetSumToKUtil(n - 1, k, arr, dp));
        Utility.print2DArray(dp);
    }

    private static boolean subsetSumToKUtil(int index, int target, int[] arr, int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return target == arr[index];
        }
        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }

        boolean notTake = subsetSumToKUtil(index - 1, target, arr, dp);
        boolean take = false;
        if (arr[index] <= target) {
            take = subsetSumToKUtil(index - 1, target - arr[index], arr, dp);
        }
        if (take || notTake) {
            dp[index][target] = 1;
        } else {
            dp[index][target] = 0;
        }
        return take || notTake;
    }

    private static int getMaxPathSumVariableStartTabulation(int[][] arr) {

        int[][] dp = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = arr[i][j];
                } else {
                    int down = (int) Math.pow(-10, 9);
                    int left = (int) Math.pow(-10, 9);
                    int right = (int) Math.pow(-10, 9);

                    if (i > 0) {
                        down = arr[i][j] + dp[i - 1][j];
                    }
                    if (j > 0) {
                        left = arr[i][j] + dp[i - 1][j - 1];
                    }
                    if (j < arr[0].length - 1) {
                        right = arr[i][j] + dp[i - 1][j + 1];
                    }
                    dp[i][j] = Math.max(down, Math.max(left, right));
                }
            }
        }
        int max = (int) Math.pow(-10, 9);

        for (int i = 0; i < dp[0].length; i++) {
            max = Math.max(dp[dp.length - 1][i], max);
        }
        Utility.print2DArray(dp);
        return max;
    }

    public static int getMaxPathSumVariableStart(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        int maxi = Integer.MIN_VALUE;

        // For each starting column, find the maximum path sum and update maxi
        for (int j = 0; j < matrix[0].length; j++) {
            int ans = getMaxPathSumUtil(matrix, dp, matrix.length - 1, j);
            maxi = Math.max(maxi, ans);
        }

        Utility.print2DArray(dp);

        return maxi;

    }

    private static int getMaxPathSumUtil(int[][] matrix, int[][] dp, int i, int j) {
        if (j < 0 || j >= matrix[0].length) {
            return (int) Math.pow(-10, 9);
        }
        if (i == 0) {
            return matrix[0][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = matrix[i][j] + getMaxPathSumUtil(matrix, dp, i - 1, j);
        int left = matrix[i][j] + getMaxPathSumUtil(matrix, dp, i - 1, j - 1);
        int right = matrix[i][j] + getMaxPathSumUtil(matrix, dp, i - 1, j + 1);
        return dp[i][j] = Math.max(up, Math.max(left, right));
    }


    private static void minimumSumPathTabulation(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = arr[0][0];
                } else {
                    int down = Integer.MAX_VALUE;
                    int right = Integer.MAX_VALUE;
                    if (i > 0) {
                        down = arr[i][j] + dp[i - 1][j];
                    }
                    if (j > 0) {
                        right = arr[i][j] + dp[i][j - 1];
                    }
                    dp[i][j] = Math.min(down, right);
                }
            }
        }
        System.out.println(dp[arr.length - 1][arr[0].length - 1]);

    }

    private static void minimumSumPath(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        Utility.print2DArray(dp);
        System.out.println(minimumSumPathUtil(arr, dp, arr.length - 1, arr[0].length - 1));
    }

    private static int minimumSumPathUtil(int[][] arr, int[][] dp, int i, int j) {
        if (i == 0 && j == 0) {
            return arr[0][0];
        }
        if (i < 0 || j < 0) {
            return (int) Math.pow(10, 9);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = arr[i][j] + minimumSumPathUtil(arr, dp, i - 1, j);
        int left = arr[i][j] + minimumSumPathUtil(arr, dp, i, j - 1);

        return dp[i][j] = Math.min(up, left);
    }


    static int mazeObstacles(ArrayList<ArrayList<Integer>> mat) {
        int[][] dp = new int[mat.size()][mat.get(0).size()];

        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        dp[0][0] = 1;
        Utility.print2DArray(dp);
        for (int i = 0; i < mat.size(); i++) {
            for (int j = 0; j < mat.get(i).size(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (mat.get(i).get(j) != -1) {
                    int right = 0;
                    int down = 0;
                    if (j > 0) {
                        right = dp[i][j - 1];
                    }
                    if (i > 0) {
                        down = dp[i - 1][j];
                    }
                    dp[i][j] = right + down;
                } else {
                    dp[i][j] = 0;
                }
                Utility.print2DArray(dp);
            }
        }
        Utility.print2DArray(dp);
        return dp[mat.size() - 1][mat.get(0).size() - 1];
    }

    private static void uniquePathIn2DArrayMaze(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];

        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        System.out.println(uniquePathIn2DArrayMazeUtil(arr, dp, arr.length - 1, arr[0].length - 1));
    }

    private static int uniquePathIn2DArrayMazeUtil(int[][] arr, int[][] dp, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (arr[i][j] == -1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int up = uniquePathIn2DArrayMazeUtil(arr, dp, i - 1, j);
        int left = uniquePathIn2DArrayMazeUtil(arr, dp, i, j - 1);
        return dp[i][j] = up + left;
    }

    private static void uniquePathIn2DArray(int M, int N) {
        int[][] dp = new int[M][N];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(uniquePathIn2DArrayUtil(M, N, dp, M - 1, N - 1, "init"));
        Utility.print2DArray(dp);
    }

    private static int uniquePathIn2DArrayUtil(int M, int N, int[][] dp, int i, int j, String source) {
        System.out.println("i = " + i + ", j= " + j + " source = " + source );
        Utility.print2DArray(dp);
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int up = uniquePathIn2DArrayUtil(M, N, dp, i - 1, j, "up");
        int left = uniquePathIn2DArrayUtil(M, N, dp, i, j - 1, "left");
        return dp[i][j] = up + left;
    }


    public static void ninjaTraining(int n, int[][] points) {

        int[][] dp = new int[n][4];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(trainingUtil(points, n - 1, 3, dp));
        Utility.print2DArray(dp);
    }

    static int trainingUtil(int[][] points, int day, int task, int[][] dp) {
        if (dp[day][task] != -1) {
            return dp[day][task];
        }

        //base case
        if (day == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                if (task != i) {
                    max = Math.max(max, points[0][i]);
                }
            }
            return dp[0][task] = max;
        }


        int maxPoint = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (task != i) {
                int point = points[day][i] + trainingUtil(points, day - 1, i, dp);
                maxPoint = Math.max(maxPoint, point);
            }
        }

        return dp[day][task] = maxPoint;

    }

    static void tabulationNinjaTraining(int n, int[][] points) {

        // base case
        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) { // assuming last task done with id 0,1,2,3
                dp[day][last] = 0;

                for (int task = 0; task < 3; task++) { //actual task performing

                    if (last != task) {
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }
        Utility.print2DArray(dp);
        System.out.println(dp[n - 1][3]);
    }

    private static void tabulationNonAdjSubsequnceMaxSum(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0]; // base case max sum till 0
        // max sum till index -> Max of either by taking that index or by taking index-2

        for (int i = 1; i < arr.length; i++) {
            int taken = arr[i];
            if (i - 2 >= 0) {
                taken = taken + dp[i - 2]; // take non adj
            }
            int nonTaken = dp[i - 1];
            dp[i] = Math.max(taken, nonTaken);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[arr.length - 1]);
    }

    private static void memorizationNonAdjSubsequnceMaxSum(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(memorizationNonAdjSubsequnceMaxSumUtil(arr, dp, arr.length - 1));
    }

    private static int memorizationNonAdjSubsequnceMaxSumUtil(int[] arr, int[] dp, int index) {
        if (index == 0) {
            return Math.max(arr[index], 0);
        }
        if (index < 0) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
//        int take = Integer.MIN_VALUE;
//        if(arr[index]>0){
            int take = arr[index] + memorizationNonAdjSubsequnceMaxSumUtil(arr, dp, index - 2);
//        }
        int notTake = 0 + memorizationNonAdjSubsequnceMaxSumUtil(arr, dp, index - 1);
        return dp[index] = Math.max(take, notTake);
    }

    private static void tabulationFrogJumpKSteps(int[] energy, int k) {
        int[] dp = new int[energy.length];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        for (int i = 1; i < energy.length; i++) {
            int jumpEnergy = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                int comingFrom = i - j;
                int currEnergy = Integer.MAX_VALUE;
                if (comingFrom >= 0) {
                    currEnergy = dp[comingFrom] + Math.abs((energy[i] - energy[comingFrom]));
                }
                jumpEnergy = Math.min(currEnergy, jumpEnergy);
            }
            dp[i] = jumpEnergy;
        }
        System.out.println(dp[energy.length - 1]);
    }

    /**
     * <a href="https://www.geeksforgeeks.org/minimum-cost-for-hopping-frog-to-reach-stair-n/">...</a>
     * minimal cost to jump to top of stairs, when frog can jump 1 or 2 steps at a time
     */
    private static void frogJumpRecursion() {
        System.out.println(frogJumpRecursionUtil(3, new int[]{20, 30, 40, 20}));
//        System.out.println(frogJumpMoRecursionUtil(3, new int[]{20, 30, 40, 20}));
    }

    private static int frogJumpRecursionUtil(int k, int[] energy) {
        if (k == 0) {
            return 0;
        }

        int oneStep = Integer.MAX_VALUE;
        int twoSteps = Integer.MAX_VALUE;
        if (k > 1) {
            twoSteps = frogJumpRecursionUtil(k - 2, energy) + Math.abs(energy[k] - energy[k - 2]);
        }
        oneStep = frogJumpRecursionUtil(k - 1, energy) + Math.abs(energy[k] - energy[k - 1]);
        return Math.min(oneStep, twoSteps);
    }

    private static void memorizationFrogJump(int[] energy) {
        int[] dp = new int[energy.length];
        Arrays.fill(dp, -1);
        System.out.println(memorizationFrogJumpUtil(dp, energy, energy.length - 1));
        System.out.println(Arrays.toString(dp));
    }

    private static int memorizationFrogJumpUtil(int[] dp, int[] energy, int i) {
        if (i == 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int oneStep = Integer.MAX_VALUE;
        int twoSteps = Integer.MAX_VALUE;
        if (i > 1) {
            twoSteps = memorizationFrogJumpUtil(dp, energy, i - 2) + Math.abs(energy[i] - energy[i - 2]);
        }
        oneStep = memorizationFrogJumpUtil(dp, energy, i - 1) + Math.abs(energy[i] - energy[i - 1]);
        return dp[i] = Math.min(oneStep, twoSteps);

        //space can be optimized by prev prev2 and curr update
    }

    private static void tabulationFrogJump(int[] energy) {
        int[] dp = new int[energy.length];

        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {

            int twoStep = Integer.MAX_VALUE;
            int oneStep = (dp[i - 1] + Math.abs(energy[i] - energy[i - 1]));
            if (i > 1) {
                twoStep = (dp[i - 2] + Math.abs(energy[i] - energy[i - 2]));
            }
            dp[i] = Math.min(oneStep, twoStep);
        }
        System.out.println(dp[energy.length - 1]);
    }

//    private static int frogJumpMoRecursionUtil(int k, int[] energy) {
//        System.out.println("on step = " + k);
//        if (k == 0) {
//            return 0;
//        }
//        int oneStep = Integer.MAX_VALUE;
//        int twoSteps = Integer.MAX_VALUE;
//        if (k > 1) {
//            twoSteps = 1 + frogJumpMoRecursionUtil(k-2, energy);
//        }
//        oneStep = 1+ frogJumpMoRecursionUtil(k - 1, energy);
//        return oneStep+twoSteps;
//    }

    private static void climbStairs() {

    }

    private static void memorizationFibonacci(int i) {
        long start = System.currentTimeMillis();

        int[] dp = new int[i + 1];

        //1. declare array of dp
        //2. store answer
        //3. check if subProblem answer is already present?
        Arrays.fill(dp, -1);
        System.out.println(memorizationFibonacciUtil(i, dp));
        long end = System.currentTimeMillis();
        System.out.println("memorizationFibonacci, time taken = " + (end - start));
    }

    private static int memorizationFibonacciUtil(int i, int[] dp) {
        if (i <= 1) {
            return i;
        }
        if (dp[i] != -1) {
            return dp[i];   // already calculated
        }
        //calculates for last case, f(2) = 0,1 once, stores f(2), and gives f(2) directly whenever asked
        return dp[i] = memorizationFibonacciUtil(i - 1, dp) + memorizationFibonacciUtil(i - 2, dp);
    }

    private static void tabulationFibonacci(int n) {
        long start = System.currentTimeMillis();
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
        long end = System.currentTimeMillis();
        System.out.println("tabulationFibonacci, time taken = " + (end - start));
    }


    /**
     * without dp, so many overlapping subProblems/ TL - 2^n
     */
    private static void nonDPfibonacci(int n) {
        long start = System.currentTimeMillis();
        System.out.println(fibonaciiUtil(n));
        long end = System.currentTimeMillis();
        System.out.println("nonDPfibonacci, time taken = " + (end - start));
    }

    private static int fibonaciiUtil(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonaciiUtil(n - 1) + fibonaciiUtil(n - 2);
    }


}

