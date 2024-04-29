package com.example.myapplication.dsAlgo.ds.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Pair {
    int a;
    char b;

    public Pair(int a, char b) {
        this.a = a;
        this.b = b;
    }
}

class PairInt {
    int a;
    int b;

    public PairInt(int a, int b) {
        this.a = a;
        this.b = b;
    }

}

public class GreedyArrays {
    public static void main(String[] args) {
//        String[] arr = {"3", "30", "34", "5", "9"};
//        largestNumberFormed(arr);

//        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
//        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};
//        minimumPlatforms(arrival, departure);

        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        NMeetingsInARoom(start, end);
    }

    private static void largestNumberFormed(String[] arr) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr, (x, y) -> {
            String xy = x + y;
            String yx = y + x;
            return yx.compareTo(xy);
        });
        for (String s : arr) {
            sb.append(s);
        }
        System.out.println(sb);
    }

    private static void minimumPlatforms(int[] arr, int[] dep) {
        ArrayList<Pair> arrayList = new ArrayList<>();

        // add all times, arrival and departures in list with pair data
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(new Pair(arr[i], 'a'));
            arrayList.add(new Pair(dep[i], 'd'));
        }

        Collections.sort(arrayList, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.a == o2.a) {
                    return Character.compare(o1.b, o2.b);   // if both arrival departure are same, give pref to arrival
                }
                return o1.a - o2.a;
            }
        });

        int currPlatforms = 0;
        int maxPlatforms = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            Pair curr = arrayList.get(i);
            if (curr.b == 'a') {
                currPlatforms++;
                maxPlatforms = Math.max(currPlatforms, maxPlatforms);
            } else {
                currPlatforms--;
            }
        }

        System.out.println(maxPlatforms);

    }

    private static void NMeetingsInARoom(int start[], int end[]) {
        if (start.length == 1) {
            // ans is 1
            return;
        }
        PairInt[] pairInts = new PairInt[start.length];
        for (int i = 0; i < start.length; i++) {
            pairInts[i] = new PairInt(start[i], end[i]);
        }

        Arrays.sort(pairInts, new Comparator<PairInt>() {
            @Override
            public int compare(PairInt o1, PairInt o2) {
                return o1.b - o2.b;
            }
        });
        int count = 1;  //start with 1
        int left = 0;
        int right = 1;

        while (right < pairInts.length) {
            if (pairInts[left].b < pairInts[right].a) {
                count++;
                left = right; // update left to right after meeting of left ends
                right++;
            } else {
                right++;
            }
        }
        System.out.println(count);
    }

    private static String largestNumberPossible(int N, int S) {
        if (S == 0 && N == 1) {
            return "0";
        } else if (S == 0) {
            return "-1";
        }
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        StringBuilder sb = new StringBuilder();
        int multipler = 1;
        while (N > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (S >= nums[i]) {
                    S = S - nums[i];
                    sb.append(nums[i]);
                    break;
                }
            }
            N--;
        }
        return (S == 0) ? sb.toString() : "-1";
    }
}
