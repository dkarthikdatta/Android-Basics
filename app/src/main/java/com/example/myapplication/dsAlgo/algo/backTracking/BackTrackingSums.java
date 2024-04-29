package com.example.myapplication.dsAlgo.algo.backTracking;

import com.example.myapplication.dsAlgo.Utility;

import java.util.ArrayList;

public class BackTrackingSums {
    public static void main(String[] args) {
        Utility.printArrayListString(restoreIpAddresses("25525511135"));
    }

    private static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<Long> curr = new ArrayList<>();
        restoreIpAddressesUtil(s, ans, curr);
        return ans;
    }

    //todo
    private static void restoreIpAddressesUtil(String s, ArrayList<String> ans, ArrayList<Long> curr) {
//        if (curr.size() == 4 && curr.get(0) <= 255 && curr.get(1) <= 255 && curr.get(2) <= 255 && curr.get(3) <= 255) {
//            ans.add(curr.get(0).toString() + "." + curr.get(1).toString() + "." + curr.get(2).toString() + "." + curr.get(3).toString() + ".");
//        }
        int stringSize = s.length();
        for (int i = 0; i < stringSize - 3; i++) {
            for (int j = i + 1; j < stringSize - 2; j++) {
                for (int k = j + 1; k < stringSize - 1; k++) {
                    String s1 = s.substring(0, i + 1);
                    String s2 = s.substring(i + 1, j + 1);
                    String s3 = s.substring(j + 1, k + 1);
                    String s4 = s.substring(k + 1, stringSize);
                    if (s1.charAt(0) == '0' || s2.charAt(0) == '0' || s3.charAt(0) == '0' || s4.charAt(0) == '0') {
                        continue;
                    }
                    curr.add(Long.valueOf(s.substring(0, i + 1)));
                    curr.add(Long.valueOf(s.substring(i + 1, j + 1)));
                    curr.add(Long.valueOf(s.substring(j + 1, k + 1)));
                    curr.add(Long.valueOf(s.substring(k + 1, stringSize)));
                    Utility.printArrayList(curr);
                    if (curr.size() == 4 && curr.get(0) <= 255 && curr.get(1) <= 255 && curr.get(2) <= 255 && curr.get(3) <= 255) {
                        ans.add(curr.get(0).toString() + "." + curr.get(1).toString() + "." + curr.get(2).toString() + "." + curr.get(3).toString());
                    }
                    curr = new ArrayList<>();
                }
            }
        }
    }

    private static void nQueens(int n) {
        int[][] arr = new int[n][n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        nQueensUtil(arr, ans, 0, 0);
    }

    private static void nQueensUtil(int[][] arr, ArrayList<ArrayList<Integer>> ans, int i, int j) {
        if (j == arr.length - 1 && canPutQueen(arr, j)) {
            ans.add(getValidIndexes(arr));
        }
        for (int hor = 0; hor < arr.length; hor++) {
            for (int ver = 0; ver < arr.length; ver++) {
                if (canPutQueen(arr, ver)) {
                    fillBoard(arr, hor, ver);
                }
            }
        }
    }

    private static void fillBoard(int[][] arr, int hor, int ver) {
        for (int i = 0; i < arr.length; i++) {
            arr[hor][i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i][ver] = 1;
        }
        int i = hor;
        int j = ver;
        while (i - 1 >= 0 && j - 1 >= 0) {
            arr[i - 1][j - 1] = 1;
            i--;
            j--;
        }
        int k = hor;
        int l = ver;
        while (i - 1 >= 0 && j + 1 < arr.length) {
            arr[i - 1][j + 1] = 1;
            i--;
            j++;
        }
    }

    private static ArrayList<Integer> getValidIndexes(int[][] arr) {
        ArrayList<Integer> validIndexes = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][j] == 1) {
                    validIndexes.add(i);
                }
            }
        }

        return validIndexes;
    }

    private static boolean canPutQueen(int[][] arr, int j) {
        for (int hr = 0; hr < arr.length; hr++) {
            if (arr[hr][j] == 0) {
                return true;
            }
        }
        return false;
    }
}
