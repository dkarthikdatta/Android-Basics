package com.example.myapplication.dsAlgo.ds.Strings;

import com.example.myapplication.dsAlgo.Utility;

import java.util.ArrayList;

public class PermuteString {

    public static void main(String[] args) {
        String string = "ABB";
        permute(string);
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
}
