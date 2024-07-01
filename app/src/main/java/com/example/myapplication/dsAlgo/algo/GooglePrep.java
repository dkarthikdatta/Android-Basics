package com.example.myapplication.dsAlgo.algo;

import com.example.myapplication.dsAlgo.GraphAdjList;
import com.example.myapplication.dsAlgo.Pair;
import com.example.myapplication.dsAlgo.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GooglePrep {
    public static void main(String[] args) {
//        maximizeTransactions(new int[]{1, -3, 5, -2, 1}, 1);
//        combineStrings(new String[]{"werty", "uiopa", "sdfgh", "jklzx", "cvbnm", "aasdg", "sdfjk", "lzxcv", "bnmgh"});
//        fleet(new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}, 12);
//        bfsGraph(new GraphAdjList().undirectedAdjList(), 6);
//        dfsGraph(new GraphAdjList().undirectedAdjList(), 6);
//        int[][] rotten = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
//        rottenOranges(rotten);
//
//        char[][] grid = {{'0', '1'}, {'1', '0'}, {'1', '1'}, {'1', '0'}};
//        System.out.println(numIslands(grid));

//        System.out.println(rotatedArraySearch(new int[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 2, 3}, 8));

//        nextGreaterElement(new int[]{6, 8, 0, 1, 3});
//        nextSmallerElement(new int[]{6, 8, 0, 1, 3});
//        nextSmallerElement(new ArrayList<>(Arrays.asList(2, 1, 4, 3)));
//
//        int ans = minSubsetSumDifference(new int[]{1, 2, 3, 4}, 4);
//        System.out.println(ans);

//        System.out.println(uniquePaths(1, 2));
//        System.out.println(rremove("aaaaaaaaa"));
//        System.out.println(removeDuplicates("maaani"));
        ArrayList<Integer> ans = countSmaller(new int[]{5, 2, 6, 1});
        Utility.printArrayList(ans, "");
    }

    public static ArrayList<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < nums.length - 1; i++) {
            boolean added = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    added = true;
                    ans.add(nums[j]);
                    break;
                }
            }
            if(!added){
                ans.add(0);
            }
        }
        ans.add(0);
        return ans;
    }

    public static String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String rremove(String s) {
        return rremoveUtil(s);
    }

    static String rremoveUtil(String s) {

        boolean[] repeat = new boolean[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                repeat[i - 1] = true;
                repeat[i] = true;
            }
        }

        StringBuilder rem = new StringBuilder();

        for (int i = 0; i < repeat.length; i++) {
            if (!repeat[i]) {
                rem.append(s.charAt(i));
            }
        }
        Utility.printArray(repeat);
        System.out.println("s = " + s);
        System.out.println("rem = " + rem);
        System.out.println("s size = " + s.length() + " rem size = " + rem.length());
//        if(rem.length() == 0 ){
//            return String.valueOf(s.charAt(0));
//        }
        if (s.length() == rem.length()) {
            System.out.println("found length same, returning");
            return rem.toString();
        }
        return rremoveUtil(rem.toString());
    }

    public static int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        int ans = dpUtil(arr, m - 1, n - 1);
        Utility.print2DArray(arr);
        return ans;
    }

    private static int dpUtil(int[][] arr, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i == 0 || j == 0) {
            return 1;
        }
        if (arr[i][j] != 0) {
            return arr[i][j];
        }
        return arr[i][j] = dpUtil(arr, i - 1, j) + dpUtil(arr, i, j - 1);
    }

    public static int minSubsetSumDifference(int[] nums, int n) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        int[][] dp = new int[nums.length][sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
        }
        if (nums[0] <= sum) {
            dp[0][nums[0]] = 1;
        }

        possibleSum(nums, dp, nums.length - 1, sum);

//
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 1; j <= sum; j++) {
//                boolean notTake = dp[i - 1][j] == 1;
//                boolean take = false;
////                if (i == 1 && j == 2) {
////                    System.out.println("dp[i - 1][sum - nums[i]] = " + dp[i - 1][sum - nums[i]]);
////                    System.out.println("[i - 1] = " + (i - 1) + " [sum - nums[i] " + (sum - nums[i]));
////                }
//                if (nums[i] <= j) {
//                    take = dp[i - 1][j - nums[i]] == 1;
//                }
//                boolean last = take || notTake;
////                if (i == 1 && j == 2) {
////                    System.out.println("take = " + take + " notTake = " + notTake);
////                }
//                dp[i][j] = last ? 1 : 0;
//            }
//        }


        Utility.print2DArray(dp);

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (dp[i][j] == 1) {
                    ans = Math.min(ans, Math.abs((sum - j) - j));
                }
            }
        }
        return ans;
    }

    private static boolean possibleSum(int[] nums, int[][] dp, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return nums[index] == target;
        }
        if (dp[index][target] != -1) {
            return dp[index][target] == 0 ? false : true;
        }
        boolean notTake = possibleSum(nums, dp, index - 1, target);
        boolean take = false;
        if (nums[index] <= target) {
            take = possibleSum(nums, dp, index - 1, target - nums[index]);
        }
        dp[index][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }

    private static void nextSmallerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                if (arr[i] > stack.peek()) {
                    ans[i] = stack.peek();
                } else {
                    while (!stack.isEmpty() && arr[i] <= stack.peek()) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        ans[i] = -1;
                    } else {
                        ans[i] = stack.peek();
                    }
                }
            }
            stack.add(arr[i]);
        }
        Utility.printArray(ans);
    }

    private static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<Integer>();

        for (int i = arr.size() - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ans.add(-1);
            } else {
                if (arr.get(i) > stack.peek()) {
                    ans.add(stack.peek());
                } else {
                    while (!stack.isEmpty() && arr.get(i) <= stack.peek()) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        ans.add(-1);
                    } else {
                        ans.add(stack.peek());
                    }
                }
            }
            stack.add(arr.get(i));
        }
        Utility.printArrayList(ans, "");
        Collections.reverse(ans);
        Utility.printArrayList(ans, "");
        return ans;
    }

    private static void nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                if (arr[i] < stack.peek()) {
                    ans[i] = stack.peek();
                } else {
                    while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        ans[i] = -1;
                    } else {
                        ans[i] = stack.peek();
                    }
                }
            }
            stack.add(arr[i]);
        }
        Utility.printArray(ans);
    }

    private static int rotatedArraySearch(int[] arr, int target) {
        int pivot = findPivot(arr);
        System.out.println("Pivot = " + pivot);
        if (pivot == -1) {
            return binarySearch(arr, 0, arr.length - 1, target);
        }
        if (arr[pivot] == target) {
            return pivot;
        }
        if (arr[0] <= target) {
            return binarySearch(arr, 0, pivot - 1, target);
        }
        return binarySearch(arr, pivot, arr.length - 1, target);
    }

    private static int findPivot(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (right == left)
                return left;
            int mid = (left + right) / 2;
            if (mid < right && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > left && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[left] < arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    Utility.print2DArray(grid);
                    bfs(i, j, grid);
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void bfs(int row, int col, char[][] grid) {
        grid[row][col] = '0';
        Queue<Pair> q = new LinkedList<>();
        int[] rowCord = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] colCord = {1, 1, 0, -1, -1, -1, 0, 1};
        q.add(new Pair(row, col));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int cRow = curr.a;
            int cCol = curr.b;
            System.out.println("cRow = " + cRow + " cCol = " + cCol);
            for (int i = 0; i < 8; i++) {
                int nRow = cRow + rowCord[i];
                int nCol = cCol + colCord[i];
                System.out.println("nRow = " + nRow + " nCol = " + nCol);
                if (isValid(nRow, nCol, grid)) {
                    System.out.println("Valid = " + "nRow = " + nRow + " nCol = " + nCol);
                    q.add(new Pair(nRow, nCol));
                    grid[nRow][nCol] = '0';
                }
            }
        }
    }

    private static boolean isValid(int r, int c, char[][] grid) {
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1') {
            return true;
        }
        return false;
    }

    private static int rottenOranges(int[][] rotten) {
        Queue<Pair> queue = new LinkedList<>();
        int m = rotten.length;
        int n = rotten[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rotten[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }
        int t = 0;
        int[] row = {0, 1, 0, -1};
        int[] col = {1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int size = queue.size();
            t++;
            for (int i = 0; i < size; i++) {
                Pair curr = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nRow = curr.a + row[j];
                    int nCol = curr.b + col[j];
                    if (isValidCoord(nRow, nCol, m, n) && rotten[nRow][nCol] == 1) {
                        queue.add(new Pair(nRow, nCol));
                        rotten[nRow][nCol] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rotten[i][j] == 1) {
                    return -1;
                }
            }
        }
        return t;
    }

    private static boolean isValidCoord(int nRow, int nCol, int m, int n) {
        if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n) {
            return true;
        }
        return false;
    }

    private static void dfsGraph(ArrayList<ArrayList<Integer>> arrayLists, int start) {
        int[] visited = new int[arrayLists.size() + 1];
        ArrayList<Integer> ans = new ArrayList<>();
        dfsGraphUtil(arrayLists, visited, ans, start);
        Utility.printArrayList(ans, "");
    }

    private static void dfsGraphUtil(ArrayList<ArrayList<Integer>> arrayLists, int[] visited, ArrayList<Integer> ans, int index) {
        visited[index] = 1;
        ans.add(index);
        ArrayList<Integer> curr = arrayLists.get(index - 1);
        for (int i = 0; i < curr.size(); i++) {
            if (visited[curr.get(i)] == 0) {
                dfsGraphUtil(arrayLists, visited, ans, curr.get(i));
            }
        }
    }

    private static void bfsGraph(ArrayList<ArrayList<Integer>> adjList, int start) {
        int[] visited = new int[adjList.size() + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            ans.add(curr);
            ArrayList<Integer> currList = adjList.get(curr - 1);
            for (int i = 0; i < currList.size(); i++) {
                if (visited[currList.get(i)] == 0) {
                    visited[currList.get(i)] = 1;
                    queue.add(currList.get(i));
                }
            }
        }
        Utility.printArrayList(ans, "");
    }

    private static void fleet(int[] position, int[] speed, int target) {
        double[] timeArr = new double[target];
        for (int i = 0; i < position.length; i++) {
            timeArr[position[i]] = (double) (target - position[i]) / speed[i];
        }
        int res = 0;
        double prev = 0.0;
        Utility.printArray(position);
        Utility.printArray(speed);
        Utility.printArray(timeArr);
        for (int i = target - 1; i >= 0; i--) {
            double cur = timeArr[i];
            if (cur > prev) {
                prev = cur;
                res++;
            }
        }
        System.out.println(res);
    }


    private static void combineStrings(String[] strings) {
        int[] arr = new int[26];
    }

    // two pointer
    //https://leetcode.com/discuss/interview-question/4874329/Google-onsite-Interview-question
    private static void maximizeTransactions(int[] arr, int startSum) {
        int i = 0;
        int j = 0;
        int sum = startSum;
        int ans = 0;
        while (j < arr.length) {
            sum = sum + arr[j];
            if (sum >= 0) {
                ans = Math.max(ans, j - i + 1);
            } else {
                while (sum < 0 && i <= j) {
                    sum = sum - arr[i];
                    i++;
                }
            }
            j++;
        }
        System.out.println(ans);
    }

}
