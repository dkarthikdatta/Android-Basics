package com.example.myapplication.test;

import java.util.HashMap;
import java.util.Map;

public class LongestStringABC {

    public static void main(String[] args) {
        int freqAA = 0;
        int freqAB = 2;
        int freqBB = 0;
        String longestString = longestStringABC(freqAA, freqAB, freqBB);
        System.out.println("Longest string: " + longestString);
    }

    public static String longestStringABC(int freqAA, int freqAB, int freqBB) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> freqMap = new HashMap<>();
        freqMap.put("AA", freqAA);
        freqMap.put("AB", freqAB);
        freqMap.put("BB", freqBB);

        String prevString = "";

        while (true) {
            String nextString = getNextString(freqMap, prevString);
            if (nextString.equals("")) break;
            sb.append(nextString);
            freqMap.put(nextString, freqMap.get(nextString) - 1);
            prevString = nextString;
        }

        return sb.toString();
    }

    private static String getNextString(Map<String, Integer> freqMap, String prevString) {
        String nextString = "";
        int maxFreq = 0;

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            String str = entry.getKey();
            int freq = entry.getValue();

            if (freq > 0 && (prevString.isEmpty() || (!prevString.equals(str) && !(prevString.endsWith("AA") && str.equals("AB"))))) {
                if (freq > maxFreq) {
                    maxFreq = freq;
                    nextString = str;
                }
            }
        }

        return nextString;
    }


}