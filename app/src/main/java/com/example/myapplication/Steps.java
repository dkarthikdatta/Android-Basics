package com.example.myapplication;

import com.example.myapplication.dsAlgo.Utility;

import java.util.Arrays;

public class Steps {
    public static void main(String[] args) {
//        System.out.println(findNumberOfWays(5));

//        System.out.println(findNumberOfWaysSpace(5));
        primes(10);
    }

    private static int findNumberOfWays(int n) {
        // 1 -> 1
        // 2 -> 2
        // 3 -> 4
        // 4 -> ?

        // sc -> o(n) -> 0(1) // memorization is not a soln(recursion)
        // tc -> o(n)
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    private static int findNumberOfWaysSpace(int n) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }

        // sc -> 0(1)
        // tc -> o(n)

        int p0 = 0;
        int p1 = 1;
        int p2 = 2;
        int p3 = 4;
        int ans = 0;
        for (int i = 4; i <= n; i++) {
            ans = p3 + p2 + p1;
            p1 = p2;
            p2 = p3;
            p3 = ans;
        }
        return ans;
    }

    private static void primes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j = j + i) {
                    prime[j] = false;
                }
            }
        }

        Utility.printArray(prime);
        int ans = 0;
        for(int i=2; i<=n; i++){
            if(prime[i]){
                ans = ans + i;
            }
        }

        System.out.println(ans);

        // tc = o(NlogN) + o(N) ~ O(nlogn)
        // sc = o(n)

    }


}
