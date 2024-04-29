package com.example.myapplication.dsAlgo.ds.Strings;

import java.util.HashSet;

public class StringSums {

    public static void main(String[] args) {
//        lengthOfLongestSubstring("geeksforgeeks");
//        removeAdjacentDup("geekseeforgeek");
        isRotated("rh", "hr");
    }

    private static void removeAdjacentDup(String s) {
        // create a adjacency duplicity array
        boolean[] adjDup = new boolean[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                adjDup[i - 1] = true;
                adjDup[i] = true;
            }
        }

        StringBuilder rem = new StringBuilder();

        for (int i = 0; i < adjDup.length; i++) {
            if (!adjDup[i]) {
                rem.append(s.charAt(i));
            }
        }

        // if remaining string length is same as original, return
        if (rem.length() == s.length()) {
            System.out.println("Non repeating character = " + rem);
            return;
        }

        removeAdjacentDup(rem.toString());


    }

    /**
     * Longest Distinct characters in string
     * <a href="https://www.geeksforgeeks.org/problems/longest-distinct-characters-in-string5848/1">Link</a>
     */
    private static void lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return;
        }

        int max = 0;
        HashSet<Character> hs = new HashSet<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (!hs.contains(ch)) {
                max = Math.max(max, right - left + 1);
                hs.add(ch);
            } else {
                while (s.charAt(left) != s.charAt(right)) {
                    hs.remove(s.charAt(left));
                    left++;
                }
                hs.remove(s.charAt(left));
                hs.add(s.charAt(right));
                left++;
            }
        }
        System.out.println(max);
    }


    /**
     * <a href="https://www.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places-1587115620/1">Link</a>
     * isRotated by 2 characters
     */
    private static boolean isRotated(String str1, String str2) {
        if (str1.length() != str2.length()) {
            System.out.println("is Rotated = " + false);
            return false;
        }
        int size = str1.length();

        if (size <= 2) {
            System.out.println("is Rotated = " + true);
            return str1.equals(str2);
        }
        boolean isRotated = (isRotatedUtil(str1, str2) || isRotatedUtil(str2, str1));
        System.out.println("is Rotated = " + isRotated);
        return isRotated;
    }

    private static boolean isRotatedUtil(String str1, String str2) {
        boolean isSame = false;
        int size = str1.length();
        for (int i = 2; i < size; i++) {
            isSame = str1.charAt(i) == str2.charAt(i - 2);
        }
        if (isSame) {
            isSame = str1.charAt(0) == str2.charAt(size - 2);
        }
        if (isSame) {
            isSame = str1.charAt(1) == str2.charAt(size - 1);
        }
        return isSame;
    }
}

