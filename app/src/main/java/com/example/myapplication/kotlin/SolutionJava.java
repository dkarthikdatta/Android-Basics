package com.example.myapplication.kotlin;

import com.example.myapplication.sdk.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class SolutionJava {

    public static void main(String[] args) {
        System.out.println("Min days: " + functionA());
    }


    public static int functionA() {
        int N = 7;

        int[] A = {7, 7, 7, 7, 13, 11, 12, 7};

        int[] array = new int[5];
        Student[] students = new Student[5];
        int m = 2, k = 3;
        int left = 0;
        int right = Integer.MAX_VALUE;
        int rose = 0;
        int boq = 0;
        ;
        if ((m * k) > N) {
            return -1;
        }

        while (left < right) {
            int mid = (left + right) / 2;
            rose = 0;
            boq = 0;
//            System.out.println(mid);
            for (int i = 0; i < N; i++) {
                if (A[i] > mid) {
                    rose = 0;
                } else if (++rose >= k) {
                    boq++;
                    rose = 0;
                }
            }
            if (boq < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    static int minOperation(int n)
    {
        if(n<=3) {
            return n;
        }
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        for(int i=4; i<=n; i++){
            arr[i] = Math.min(arr[i-1], arr[i/2]) + 1;
        }
        return arr[n];
    }

    static long trappingWater(int arr[], int n) {
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        int lmaxT = Integer.MIN_VALUE;
        int rmaxT = Integer.MIN_VALUE;

        for (int i=0; i<n ; i++){
            lmaxT = Math.max(lmaxT, arr[i]);
            lmax[i] = lmaxT;
            rmaxT = Math.max(rmaxT, arr[n-i-1]);
            rmax[n-i-1] = rmaxT;
        }
        System.out.println(Arrays.toString(lmax));
        System.out.println(Arrays.toString(rmax));

        long ans = 0;
        for (int i=0; i<n ; i++){
            ans = ans + Math.min(lmax[i], rmax[i]) - arr[i];
        }
        return ans;
    }

    public static List<String> find_permutation(String S) {
        List<String> ans = new ArrayList<String>();
        int[] freq = new int[S.length()];
        StringBuilder ds = new StringBuilder();
        permute(S, ans, freq, ds);
        return ans;
    }

    private static void permute(String s, List<String> ans, int[] freq, StringBuilder ds){
        if(ds.length() == s.length()){
            ans.add(ds.toString());
            return;
        }


        for(int i=0; i<s.length(); i++){
            if(freq[i] ==0){
                System.out.println("inside if");
                ds.append(s.charAt(i));
                freq[i] = 1;
                permute(s, ans, freq, ds);
                ds.deleteCharAt(ds.length()-1);
                freq[i] = 0;
            }
        }
    }

        public static int maxProfit(int[] prices) {
            // We need prices for 2 days at least to find the profit.
            if (prices == null || prices.length <= 1) {
                return 0;
            }

            int totalProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                // Checking if we can profit with previous day's price.
                // If yes, then we buy on previous day and sell on current day.
                // Add all such profits to get the total profit.
                if (prices[i - 1] < prices[i]) {
                    System.out.println("buy on day: " + (i-1) + " with value: " + prices[i - 1]);
                    System.out.println("sell on day: " + (i) + " with value: " + prices[i]);
                    totalProfit += prices[i] - prices[i - 1];
                }
            }

            return totalProfit;
        }
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            System.out.println("currently, temp at index: " + i);
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                System.out.println("currently filling ans at index: " + idx);
                ret[idx] = i - idx;
                System.out.println("currently filling ans at index, value: " + ret[idx]);
            }
            stack.push(i);
            System.out.println("current stack");
            printIntegerStack(stack);
        }
        return ret;
    }

    private static void printIntegerStack(Stack<Integer> stack){
        for (Integer integer : stack) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static int strStr(String haystack, String needle) {
        boolean found = false;
        int bigStart = 0;
        int smallStart = 0;
        int index = -1;
        boolean check = false;

        while(bigStart<haystack.length()){
            if(haystack.charAt(bigStart) == needle.charAt(smallStart)){
                index = bigStart;
                check = true;
                while(smallStart<needle.length()-1&&bigStart<haystack.length()-1){
                    smallStart++;
                    bigStart++;
                    System.out.println(" bigStart: " + bigStart + " smallStart: " + smallStart );
                    System.out.println(" bigStart char: " + haystack.charAt(bigStart) + " smallStart char: " + needle.charAt(smallStart) );

                    if(haystack.charAt(bigStart) == needle.charAt(smallStart)){
                        found = true;
                        continue;
                    } else {
                        System.out.println("in else bigStart: " + bigStart + " smallStart: " + smallStart );
                        found = false;
                        break;
                    }
                }
            }
            System.out.println("found value: " + found );
            if(check && found){
                return index;
            }
            index = -1;
            check= false;
            bigStart++;
            smallStart = 0;
        }
        return index;
    }

    public static double findMaxAverage(int[] nums, int k) {


        int max = Integer.MIN_VALUE;
        // for(int i=0; i<nums.length-k; i++){
        //     for(j = i)
        //     max = Math.max
        // }
        int currSum = 0;
        for(int i=0; i<k; i++){
            currSum = currSum + nums[i];
        }
        max = currSum;
        int index = k-1;
        while(index<nums.length-1){
            System.out.println("currSum: " + currSum);
            currSum = currSum - nums[index-k+1];
            index++;
            currSum = currSum + nums[index];
            max = Math.max(max, currSum);
            System.out.println("index: " + index);
        }
        double ans = max/k;
        return ans;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 1;
        int minSize = Integer.MAX_VALUE;
        int currSum = 0;
        currSum = nums[0];
        while (right<nums.length && left<=right){
            currSum = currSum + nums[right];
            System.out.println("currSum: " + currSum);
            if(currSum < target){
                right++;
            } else {
//                System.out.println("greater or equal sum: " + currSum);
                minSize = Math.min(minSize, right-left+1);
                currSum = currSum - nums[left];
                left++;
//                right++;
            }
        }
        return minSize;
    }
    public static List<String> findRepeatedDnaSequences1(String s) {
        List<String> res = new ArrayList<String>();
        Set<String> resset = new HashSet<String>();
        if(s == null || s.length() <= 10){
            return res;
        }
        Set<String> set = new HashSet<String>();
        int len = s.length();
        for(int i = 0; i <= len - 10; i++){
            String sub = s.substring(i, i + 10);
            System.out.println("in for: " + sub);
            if(!set.add(sub)){
                System.out.println("in if: " + sub);
                resset.add(sub);
            }
        }
        res.addAll(resset);
        return res;
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10){
            return new ArrayList<String>();
        }
        HashSet<String> hs = new HashSet<String>();
        List<String> ans = new ArrayList<String>();

        for(int i=0; i<s.length()-10; i++){
            String str = s.substring(i, i+10);
            System.out.println("i = " + i + " str =" + str);
            if(!hs.contains(str)){
                hs.add(str);
            } else {
                ans.add(str);
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 2){
                    int[] rotten = {i, j};
                    q.add(rotten);
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        System.out.println("fresh count: " + fresh);
        int time = 0;
        System.out.println("initial q size: " + q.size());
        while(q.size()!=0){
            time++;
            int rotten = q.size();
            for(int i=0; i<rotten; i++){
                System.out.println("Inside 1st for");
                int[] curr = q.poll();
                System.out.println("curr[0] = " +curr[0] + " curr[1] = " + curr[1]);
                int[][] dir = {
                        {curr[0] - 1, curr[1]},
                        {curr[0] +1, curr[1]},
                        {curr[0], curr[1] - 1},
                        {curr[0], curr[1] + 1}
                };

                for(int j=0; j<dir.length; j++){
                    System.out.println("Inside 2nd for, dir[j][0] = " + dir[j][0]  + " dir[j][1] = " + dir[j][1] );
                    if(dir[j][0]<0 || dir[j][0] >= grid.length || dir[j][1] <0 || dir[j][1]  >= grid[0].length || grid[dir[j][0]][dir[j][1]] == 2 ||  grid[dir[j][0]][dir[j][1]] == 0  ){
                        continue;
                    } else {
                        grid[dir[j][0]][dir[j][1]] = 2;
                        int[] rotten1 = {dir[j][0], dir[j][1]};
                        q.add(rotten1);
                        fresh--;
                    }
                }
            }
            print2DArray(grid);
        }
        if(fresh==0) return time; else return -1;
    }

    static void util(int N, ArrayList<Integer> ans, int[] arr){
        if(N==0){
            return;
        }
        int index = arr.length-1;
        while(index>=0){
            if(arr[index]<=N){
                ans.add(arr[index]);
                util(N-arr[index], ans, arr);
                break;
            } else {
                index--;
            }
        }
    }
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int size = coins.length;
        int rem = amount;
        int index = size-1;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        boolean found = false;
        while(rem >= 0 && index >=0){
            if(rem == 0){
                found = true;
                break;
            } else if(rem - coins[index] >= 0){
                rem = rem - coins[index];
                ans.add(coins[index]);
                System.out.println("rem: "+ rem + " adding: " + coins[index]);
            } else if(rem - coins[index]<0){
                index--;
            }
        }
        System.out.println(ans);
        System.out.println(found);

        if(found){
            return ans.size();
        } else {
            return -1;
        }
    }
    public static int[][] updateMatrix(int[][] mat) {

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                if(mat[i][j] == 0){
                    continue;
                } else {
                    int up =  Integer.MAX_VALUE, down = Integer.MAX_VALUE, right = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if(i<mat.length-1){
                        down = mat[i+1][j];
                    }
                    if(i>0){
                        up = mat[i-1][j];
                    }
                    if(j<mat[i].length-1){
                        right = mat[i][j+1];
                    }
                    if(j>0){
                        left = mat[i][j-1];
                    }
                    int min = down;
                    if(up<min){
                        min = up;
                    }
                    if(right<min){
                        min = right;
                    }
                    if(left<min){
                        min = left;
                    }
                    mat[i][j] = 1+min;
                }
            }
        }
        return mat;
    }
    public static int climbStairs(int n) {
        if(n==1 || n==2){
            return n;
        }
        int ans = climbStairs(n-1) + climbStairs(n-2);
        return ans;
    }

    static void combinationSum(int index, int[] arr, int target, ArrayList<Integer> ds, List<List<Integer>> ans) {
        if (index == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[index] <= target) {
//            System.out.println("index = " + index+ "arr[index] = " + arr[index]);
            ds.add(arr[index]);
            combinationSum(index, arr, target - arr[index], ds, ans);
            ds.remove(ds.size() - 1);
        }

        combinationSum(index + 1, arr, target, ds, ans);
    }

    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int mid = start + (end - start) / 2;
        boolean currVersion = false;
        int ans = 0;

        while (start <= end) {
            currVersion = isBadVersion(mid);
            if (currVersion) {
                if (!isBadVersion(mid + 1)) {
                    ans = mid + 1;
                    break;
                }
                start = mid + 1;
                mid = start + (end - start) / 2;
            } else {
                if (isBadVersion(mid - 1)) {
                    ans = mid;
                    break;
                } else {
                    end = mid - 1;
                    mid = start + (end - start) / 2;
                }
            }
        }
        return ans;
    }

    static boolean isBadVersion(int n) {
        return n <= 1;
    }

    static void fill(int[][] image, int row, int col, int color, int initial) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[row].length) {
            return;
        }

        if (image[row][col] == initial) {
            image[row][col] = color;
            fill(image, row + 1, col, color, initial);
            fill(image, row - 1, col, color, initial);
            fill(image, row, col + 1, color, initial);
            fill(image, row, col - 1, color, initial);
        }

    }

    public static void print2DArray(int[][] image) {
        System.out.println();
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;
        int ans = -1;
        while (mid != start) {
            if (nums[mid] < target) {
                start = mid;
                mid = (start + end) / 2;
            } else if (nums[mid] > target) {
                end = mid;
                mid = (start + end) / 2;
            } else {
                ans = mid;
                break;
            }
        }
        return ans;
    }
}