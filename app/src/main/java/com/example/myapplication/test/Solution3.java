package com.example.myapplication.test;

public class Solution3 {

    // Recursively find maximum moves for a given array and target sum
    private static int recur(int l, int r, int[] arr, int targetSum, int count) {
        if (l + 1 > r) {
            return count;
        }

        int maxCount = count;
        if (l + 1 <= r && arr[l] + arr[l + 1] == targetSum) {
            maxCount = Math.max(maxCount, recur(l + 2, r, arr, targetSum, count + 1));
        }

        if (l <= r - 1 && arr[l] + arr[r] == targetSum) {
            maxCount = Math.max(maxCount, recur(l + 1, r - 1, arr, targetSum, count + 1));
        }

        if (r - 1 > l && arr[r] + arr[r - 1] == targetSum) {
            maxCount = Math.max(maxCount, recur(l, r - 2, arr, targetSum, count + 1));
        }

        return maxCount;
    }

    public static int minReduction(int[] arr) {
        if (arr.length < 2) return 0;

        int ans = 0;
        // Only compute from start and end if possible
        if (arr.length >= 2) {
            int sum1 = arr[0] + arr[1];
            int sum2 = arr[arr.length - 1] + arr[arr.length - 2];

            ans = Math.max(ans, recur(2, arr.length - 1, arr, sum1, 1));
            ans = Math.max(ans, recur(0, arr.length - 3, arr, sum2, 1));
        }

        // If the array is odd and long enough, consider middle removal
        if (arr.length >= 3) {
            int sum3 = arr[0] + arr[arr.length - 1];
            ans = Math.max(ans, recur(1, arr.length - 2, arr, sum3, 1));
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 5, 3, 3, 4, 2};
        int[] B = {4, 1, 4, 3, 3, 2, 5, 2};
        int[] C = {1, 9, 1, 1, 1, 1, 1, 1, 8, 1};
        int[] D = {1, 9, 8, 9, 5, 1, 2};
        int[] E = {1, 1, 2, 3, 1, 2, 2, 1, 1, 2};

        System.out.println(minReduction(A)); // Expected output: 3
        System.out.println(minReduction(B)); // Expected output: 4
        System.out.println(minReduction(C)); // Expected output: 1
        System.out.println(minReduction(D)); // Expected output: 3
        System.out.println(minReduction(E)); // Expected output: 4
    }
}