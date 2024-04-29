package com.example.myapplication.dsAlgo.ds.Strings;

import com.example.myapplication.dsAlgo.Utility;

import java.util.ArrayList;

// TC -> 0(n2)
public class SubStrings {
    public static void main(String[] args) {
        String s = "Geeky";
        ArrayList<String> ans = new ArrayList<>();
        substring(s, ans);
        Utility.printArrayListString(ans);
    }

    private static void substring(String s, ArrayList<String> ans) {
        int left = 0;
        for (int i = left; i < s.length(); i++) {
            int right = i;
            for (int j = right; j < s.length(); j++) {
                ans.add(s.substring(i, j + 1));
            }
        }
    }
}
