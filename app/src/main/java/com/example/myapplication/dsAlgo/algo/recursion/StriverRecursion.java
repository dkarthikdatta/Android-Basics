package com.example.myapplication.dsAlgo.algo.recursion;

import com.example.myapplication.dsAlgo.Utility;

import java.util.ArrayList;
import java.util.Arrays;

public class StriverRecursion {

    public static void main(String[] args) {

        //pick and not pick method
        //subsequence - non contigious following order - 2^n sub sequence

//        printAllSubsequences(new int[]{3, 1, 2,4});
//        printSubsequenceWhoseSumK(new int[]{3, 1, 2, 4, 1}, 2);

        printAllSubArrays(new int[]{3, 1, 2, 4, 1});
    }

    private static void printAllSubArrays(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                printArray(arr, i, j);
            }
        }
    }

    private static void printArray(int[] arr, int i, int j) {
        if (i < arr.length && j < arr.length) {
            while (i<j){
                System.out.print(arr[i] + " ");
                i++;
            }
        }
        System.out.println();
    }

    private static void printAllSubArraysUtil(int[] arr, ArrayList<Integer> temp, int index, boolean breakList) {
        if (index == arr.length || !breakList) {
            Utility.printArrayListInt(temp);
        }
        temp.add(index);
        printAllSubArraysUtil(arr, temp, index + 1, false);
        temp.remove(index);


    }

    private static void printSubsequenceWhoseSumK(int[] arr, int k) {
        ArrayList<Integer> temp = new ArrayList<>();
        int sum = 0;
//        printSubsequenceWhoseSumKUtil(arr, k, 0, sum, temp);
//        printOneSubsequenceWhoseSumKUtil(arr, k, 0, sum, temp);
        System.out.println(printCountOfSubsequenceWhoseSumKUtil(arr, k, 0, sum));   //no need to maintain temp as we are not printing values
    }

    private static int printCountOfSubsequenceWhoseSumKUtil(int[] arr, int k, int index, int sum) {
        if (index == arr.length) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }

        sum = sum + arr[index];
        int left = printCountOfSubsequenceWhoseSumKUtil(arr, k, index + 1, sum);
        sum = sum - arr[index];
        int right = printCountOfSubsequenceWhoseSumKUtil(arr, k, index + 1, sum);
        return left + right;
    }

    private static void printSubsequenceWhoseSumKUtil(int[] arr, int k, int index, int sum, ArrayList<Integer> temp) {

        if (index == arr.length) {
            if (sum == k) {
                Utility.printArrayListInt(temp);
                return;
            }
            return;
        }
        //pick
        temp.add(arr[index]);
        sum = sum + arr[index];
        printSubsequenceWhoseSumKUtil(arr, k, index + 1, sum, temp);

        //don't pick
        sum = sum - arr[index];
        temp.remove(temp.size() - 1);
        printSubsequenceWhoseSumKUtil(arr, k, index + 1, sum, temp);

    }

    private static boolean printOneSubsequenceWhoseSumKUtil(int[] arr, int k, int index, int sum, ArrayList<Integer> temp) {

        if (index == arr.length) {
            if (sum == k) {
                Utility.printArrayListInt(temp);
                return true;
            }
            return false;
        }
        //pick
        temp.add(arr[index]);
        sum = sum + arr[index];
        if (printOneSubsequenceWhoseSumKUtil(arr, k, index + 1, sum, temp)) {
            return true;
        }

        //don't pick
        sum = sum - arr[index];
        temp.remove(temp.size() - 1);
        if (
                printOneSubsequenceWhoseSumKUtil(arr, k, index + 1, sum, temp)) {
            return true;
        }
        return false;
    }

    private static void printAllSubsequences(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        findAllSubsequencesUtil(arr, ans, 0, temp);
        Utility.printArrayLists(ans);
    }

    private static void findAllSubsequencesUtil(int[] arr, ArrayList<ArrayList<Integer>> ans, int index, ArrayList<Integer> temp) {
        if (index == arr.length) {
            ans.add(new ArrayList<>(temp));
//            System.out.println("in base case");
//            Utility.printArrayListInt(temp);
            return;
        }
        temp.add(arr[index]); //pick
        findAllSubsequencesUtil(arr, ans, index + 1, temp);
        temp.remove(temp.size() - 1); // don't pick
        findAllSubsequencesUtil(arr, ans, index + 1, temp);
    }


}
