package com.example.myapplication.kotlin;

import java.util.Arrays;
import java.util.List;

public class NumeralSorter {

    private static final List<String> NUMERALS = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    public static String sortNumerals(String input) {
        // Check for null or empty input
        if (input == null || input.isEmpty()) {
            return "";
        }

        // Split the input string into individual numerals
        String[] numeralArray = input.split(" ");

        // Sort the numerals using the predefined list order
//        Arrays.sort(numeralArray, NUMERALS::indexOf);

        // Join the sorted numerals back into a string
        return String.join(" ", numeralArray);
    }

    public static void main(String[] args) {
        // Example usage
        String input = "five one nine four three zero";
        String sortedNumerals = sortNumerals(input);
        System.out.println("Sorted Numerals: " + sortedNumerals);
    }
}