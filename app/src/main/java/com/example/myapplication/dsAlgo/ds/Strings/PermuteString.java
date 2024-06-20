package com.example.myapplication.dsAlgo.ds.Strings;

import com.example.myapplication.dsAlgo.Utility;

import java.util.ArrayList;

public class PermuteString {

    public static void main(String[] args) {
        String string = "ABC";
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
            System.out.println("Adding permutation = " + stringBuilder.toString());
            return;
        }

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            System.out.println("Char = " + c + " at i = " + i);
            Utility.printArray(booleanArray);
            // selecting only unselected values
            if (booleanArray[i] == false) {
                booleanArray[i] = true;
                stringBuilder.append(c);
                System.out.println("Recursing at char = " + c + " i = " + i);
                permuteUtil(string, stringBuilder, booleanArray, ans);

                System.out.println("backtracing at char = " + c + " i = " + i + " deleting char = " + stringBuilder.charAt(stringBuilder.length() - 1));

                // deselect the selected value
                booleanArray[i] = false;
                //remove the initial selected value
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }
}
