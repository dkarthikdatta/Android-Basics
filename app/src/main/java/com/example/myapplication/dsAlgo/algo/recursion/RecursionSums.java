package com.example.myapplication.dsAlgo.algo.recursion;

import com.example.myapplication.dsAlgo.Utility;

import java.util.ArrayList;

public class RecursionSums {

    public static void main(String[] args) {
//        String string = "ABB";
//        permute(string);
//        numberOfPaths(10, 10);
//        josephusProblem(8, 2);  //todo
        int[] arr = {7,8,9};
        subsequenceOfArray(arr);
    }

    // subsequence printing
    private static void subsequenceOfArray(int[] arr) {
        // at every index, take/not take. hence we get 2^n subsequences
        ArrayList<Integer> ans = new ArrayList<>();
        subsequenceOfArrayUtil(arr, ans, 0);
    }

    private static void subsequenceOfArrayUtil(int[] arr, ArrayList<Integer> ans, int index) {
//        System.out.println("At line 26, ans = " + ans);
        if (index == arr.length) {
            System.out.println("Found base case index = 3, printing ans = " + ans);
            return;
        }
        ans.add(arr[index]);

//        System.out.println("At line 33, ans = " + ans);
        subsequenceOfArrayUtil(arr, ans, index + 1);
        ans.remove(ans.size() - 1);

//        System.out.println("At line 37, ans = " + ans);
        subsequenceOfArrayUtil(arr, ans, index + 1);
    }

    private static void permute(String string) {

        // to keep track of selected index
        boolean[] boolArray = new boolean[string.length()];
        // to store the selected character
        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<String> ans = new ArrayList<>();
        permuteUtil(string, stringBuilder, boolArray, ans);
        Utility.printArrayListString(ans);
    }

    private static void permuteUtil(String string, StringBuilder stringBuilder, boolean[] booleanArray, ArrayList<String> ans) {

        // base case where ds size is equal to string size
        if (stringBuilder.length() == string.length() && !ans.contains(stringBuilder.toString())) {
            ans.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            // selecting only unselected values
            if (booleanArray[i] == false) {
                booleanArray[i] = true;
                stringBuilder.append(c);
                permuteUtil(string, stringBuilder, booleanArray, ans);

                // deselect the selected value
                booleanArray[i] = false;
                //remove the initial selected value
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }


    /**
     * The problem is to count all the possible paths from top left to bottom right of an MxN matrix
     * with the constraints that from each cell you can either move to right or down.
     */

    // this is naive/brute force approach. since recursion, 2^(M+N) is the time complexity
    // here we are calculating number of paths to M,N from every cell and doing summation
    // which is unnecessary as we can store net sums to each cell
    // This causes TLE for large M, N values
    // DP solution is discussed in DP section
    private static void numberOfPaths(int M, int N) {
        int noOfPaths = numberOfPathsUtil(M, N, 0, 0);
        System.out.println(noOfPaths);
    }

    private static int numberOfPathsUtil(long M, long N, long i, long j) {
        if (i >= M || j >= N) {
            return 0;
        }
        if (i == M - 1 && j == N - 1) {
            return 1;
        }
        return numberOfPathsUtil(M, N, i + 1, j) + numberOfPathsUtil(M, N, i, j + 1);
    }

    private static void josephusProblem(int n, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        System.out.println(josephusProblemUtil(arrayList, k, 0));
    }

    private static int josephusProblemUtil(ArrayList<Integer> arrayList, int k, int current) {
        Utility.printArrayList(arrayList, "josephus");
        if (arrayList.size() == 1) {
            return arrayList.get(0) + 1;
        }
        if (current + k - 1 < arrayList.size()) {
            current = current + k - 1;
        } else {
            int skip = 1;
            while (skip < k) {
                current++;
                skip++;
                if (current >= arrayList.size()) {
                    current = 0;
                }
            }
        }
        arrayList.remove(current);
        return josephusProblemUtil(arrayList, k, current);
    }
}
