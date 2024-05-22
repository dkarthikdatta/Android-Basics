package com.example.myapplication;

import com.example.myapplication.dsAlgo.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;

public class Test {

    final int num = 10;

    public void display() {
        int num = 15;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                int num = 25;
                System.out.println(num);
            }
        };
        r.run();
    }


    public static void main(String[] args) {

//        Test test = new Test();
//        test.display();
//        minPartition(43);
//        rremove("abbc");

//        long curr = Long.parseLong("0011101011011011", 2);
//        long curr2 = Long.parseLong("10101101101111", 2);
//        String curr01 = "0011101011011011".replaceFirst("^0+(?!$)", "");
//        String curr02 = "10101101101111".replaceFirst("^0+(?!$)", "");
//        int comp = curr02.compareTo(curr01);
//        System.out.println(curr);
//        System.out.println(curr2);
//        System.out.println(comp);
//
//        long curr = Long.parseLong("100011", 2);
//        long curr2 = Long.parseLong("11001", 2);
//        String curr01 = "100011";
//        String curr02 = "11001";
//        int comp = curr02.compareTo(curr01);
//        System.out.println(curr);
//        System.out.println(curr2);
//        System.out.println(comp);
//
//
//
//        String ans = shortestBeautifulSubstring("100011001", 3);
//        System.out.println("ans = " + ans);

//        int com = "0011101011011011".compareTo("10101101101111");
//        System.out.println(com);
//        String ans = String.valueOf(Long.MAX_VALUE);
//        System.out.println(ans);
        int[] ans = findIndices(new int[]{5, 1, 4, 1}, 2, 4);
        Utility.printArray(ans);
    }


    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        TreeMap<Integer, HashSet<Integer>> tm = new TreeMap();
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        for (int i = 0; i < nums.length; i++) {
            if (tm.get(nums[i]) == null) {
                HashSet<Integer> hs = new HashSet<>();
                hs.add(i);
                tm.put(nums[i], hs);
            } else {
                HashSet<Integer> currHs = tm.get(nums[i]);
                currHs.add(i);
                tm.put(nums[i], currHs);
            }
        }

        for (int i = 0; i < nums.length - indexDifference; i++) {
            int k = i;
            while (k < indexDifference) {
                System.out.println("removing = " + nums[k]);
                tm.remove(nums[k]);
                k++;
            }

            int min = tm.firstKey();
            int max = tm.lastKey();
            System.out.println("min = " + min);
            System.out.println("max " + max);
            int minDiff = Math.abs(nums[i] - min);
            int maxDiff = Math.abs(nums[i] - max);

            if (minDiff >= valueDifference) {
                for (Integer index : tm.get(min)) {
                    if (Math.abs(i - index) >= indexDifference) {
                        ans[0] = i;
                        ans[1] = index;
                        return ans;
                    }
                }
            }
            if (maxDiff >= valueDifference) {
                for (Integer index : tm.get(max)) {
                    if (Math.abs(i - index) >= indexDifference) {
                        ans[0] = i;
                        ans[1] = index;
                        return ans;
                    }
                }
            }
        }
        return ans;
    }

    public static String shortestBeautifulSubstring(String s, int k) {
        if (s.length() < k) {
            return "";
        }
        String ans = String.valueOf(Long.MAX_VALUE);
        long min = Long.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            int endIndex = 0;
            boolean found = false;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    count++;
                }
                if (count == k) {
                    endIndex = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                String str = s.substring(i, endIndex + 1).replaceFirst("^0+(?!$)", "");
                int comp = str.compareTo(ans);
                System.out.println("curr ans = " + ans + " curr str= " + str + " comp =" + comp);
                if (comp <= 0 && str.length() <= ans.length()) {
                    ans = str;
                }
            }
        }
        if (ans.equals(String.valueOf(Long.MAX_VALUE))) {
            return "";
        }
        return ans.replaceFirst("^0+(?!$)", "");
    }

    static String rremove(String s) {
        if (s.isEmpty()) return s;
        StringBuilder ans = new StringBuilder();
        helper(ans, s);
        return ans.toString();
    }

    static void helper(StringBuilder sb, String s) {
        boolean[] adjacentFlag = new boolean[s.length()];
        //tag adjacent as true;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                adjacentFlag[i] = adjacentFlag[i - 1] = true;
            }
        }
        System.out.println("Adjacent Flag");
        for (int i = 0; i < s.length(); i++) {
            System.out.print(adjacentFlag[i] + " ");
        }
        System.out.println();

        StringBuilder rem = new StringBuilder();
        //find remaing elements not tagged as true
        for (int i = 0; i < adjacentFlag.length; i++) {
            if (!adjacentFlag[i]) rem.append(s.charAt(i));
        }

        //0 Adjacent element(s) exist, return!
        if (rem.length() == s.length()) {
            sb.append(s);
            return;
        }
        helper(sb, rem.toString());
    }

    static void minPartition(int N) {
        int[] arr = new int[]{1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        HashSet<Integer> hs = new HashSet<>(Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200, 500, 2000));
        ArrayList<Integer> ans = new ArrayList<Integer>();
        util(N, hs, ans, arr);
        System.out.println(ans);
    }

    static void util(int N, HashSet<Integer> hs, ArrayList<Integer> ans, int[] arr) {
        System.out.println(N);
        if (N == 0) {
            return;
        }
        int index = arr.length - 1;
        while (index >= 0) {
            if (arr[index] <= N) {
                ans.add(arr[index]);
                util(N - arr[index], hs, ans, arr);
                break;
            } else {
                index--;
            }
        }
    }
}
