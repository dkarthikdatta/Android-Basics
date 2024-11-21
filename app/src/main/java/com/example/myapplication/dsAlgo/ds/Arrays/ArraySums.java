package com.example.myapplication.dsAlgo.ds.Arrays;

import com.example.myapplication.dsAlgo.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ArraySums {
    public static void main(String[] args) {
//        int[] sort012Array = {0, 2, 2, 1, 1, 0, 1, 0, 2};
//        sort012(sort012Array, 9);
//
//        int[] binaryEven = {10, 11, 12, 14, 16, 17, 18, 22, 25, 26}; //even
//        int[] binaryOdd = {10, 11, 12, 14, 16, 17, 18, 22, 25, 26, 28}; //odd
//
//        binarySearch(binaryEven, 14);
//        binarySearch(binaryOdd, 17);
//
//        int[] maxSubArray = {1, 2, 3, -2, 5};
//        maxSubArraySum(maxSubArray);
//
//        long[] mergeSortedArr1 = {13, 17, 18, 19, 20, 22, 22, 27, 36, 39, 46, 48, 50};
//        long[] mergeSortedArr2 = {4, 12, 45};
//        mergeWithoutExtraSpace(mergeSortedArr1, mergeSortedArr2);
//
////        int[] subArraySum = {1,2,3,7,5};
//        int[] subArraySum = {0};
//        Utility.printArrayList(subarraySum(subArraySum, 1, 0), "");
////        System.out.println(subarraySum(subArraySum, 1, 0));
//
//        System.out.println(maximumEnergy(new int[]{5, 2, -10, -5, 1}, 3));
//        System.out.println(maximumEnergy(new int[]{-9,-2,-6,-5,-8,3,0}, 1));
//        System.out.println(findKthSmallest(new int[]{6, 5}, 1435065516));
        System.out.println(minMeetingRooms(new int[]{1,10,7}, new int[]{4,15,10}));
    }
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        Collections.sort(arrayList, (a, b) -> {
            if(hm.get(a) == hm.get(b)){
                return a-b;
            }
            return hm.get(b) - hm.get(a);
        });

        if (n == 1) {
            if (arr[0] == s) {
                return new ArrayList<>(Arrays.asList(1, 1));
            } else {
                return new ArrayList<>();
            }
        }

        int left = 0;
        int right = 1;
        int currSum = arr[0] + arr[1];
        ArrayList<Integer> ans = new ArrayList<>();
        while (left<right){
            if(currSum == s){
                ans.add(left+1);
                ans.add(right+1);
                break;
            } else if (currSum < s) {
                right++;
                currSum = currSum + arr[right];
            } else {
                currSum = currSum - arr[left];
                left++;
            }
        }
        // System.out.println(ans);
        return ans;
    }
    public static long findKthSmallest(int[] coins, int k) {
        ArrayList<Long> nums = new ArrayList<Long>();
        Arrays.sort(coins);
        long maxVal = coins[0] * (k+1);

        for(int i=0; i<coins.length; i++){
            long multiplier = 1;
            while((multiplier * coins[i]) <= maxVal){
                nums.add(multiplier * coins[i]);
                multiplier++;
            }
        }
        nums = (ArrayList<Long>) nums.stream().distinct().collect(Collectors.toList());
        Collections.sort(nums);
        Utility.printArrayListLong(nums);
        return nums.get(k-1);
    }

    public static int maximumEnergy(int[] energy, int k) {
        int length = energy.length;
        int[] dp = new int[length];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            dp[i] = energy[i];
            int iterator = i + k;
            while (iterator < length) {
                dp[i] = dp[i] + energy[iterator];
                iterator = iterator + k;
            }
            ans = Math.max(dp[i], ans);
        }

        for (int i = 0; i < length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();


        for (int i = k; i < length-k; i++) {
            if(dp[i]<0){
                dp[i] = dp[i - k] + energy[i];
            } else {
                dp[i] = dp[i - k] - energy[i];
            }
            ans = Math.max(dp[i], ans);
        }
        System.out.println();

        for(int i=length-k; i<length; i++){
            dp[i] = energy[i];
            ans = Math.max(dp[i], ans);
        }

        for (int i = 0; i < length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return ans;
    }

    /**
     * for binary search, array should be sorted
     *
     * @param arr
     * @param target
     */
    private static void binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) {
                System.out.println(mid);
                return;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println("not found");
    }


    /**
     * <a href="https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1">link</a>
     * Find Indexes of a subarray with given sum
     */

    static ArrayList<Integer> subarraySum2(int[] arr, int n, int s) {

        if (n == 1) {
            if (arr[0] == s) {
                return new ArrayList<Integer>(Arrays.asList(arr[0], arr[0]));
            } else {
                return new ArrayList<>();
            }
        }
        int left = 0;
        int right = 1;
        int currSum = arr[0] + arr[1];
        ArrayList<Integer> ans = new ArrayList<>();
        while (left < right) {
            if (currSum == s) {
                ans.add(left + 1);
                ans.add(right + 1);
                break;
            } else if (currSum < s) {
                right++;
                currSum = currSum + arr[right];
            } else {
                currSum = currSum - arr[left];
                left++;
            }
        }
        return ans;
    }

    private static void sort012(int a[], int n) {
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while (mid <= high) {
            if (a[mid] == 0) {
                int temp = a[low];
                a[low] = a[mid];
                a[mid] = temp;
                low++;
                mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else {
                int temp2 = a[high];
                a[high] = a[mid];
                a[mid] = temp2;
                high--;
            }
        }
        Utility.printArray(a);
    }

    private static void maxSubArraySum(int[] arr) {
        int currMax = arr[0];
        int globalMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max((currMax + arr[i]), arr[i]);    // accounting either if current is max or (currMax + arr[i]) is max (if there is negative in prev summation)
            globalMax = Math.max(globalMax, currMax);
        }
        System.out.println(globalMax);
    }

    private static void mergeWithoutExtraSpace(long[] arr1, long[] arr2) {
        // arr1 and arr2 are sorted; sort overall in place arr1 and arr2. arr1 contains all small integers
        //n = 4, arr1[] = [1 3 5 7]
        //m = 5, arr2[] = [0 2 6 8 9]

        int pr2 = arr2.length - 1;
        int pl2 = 0;
        int pr1 = arr1.length - 1;

        while (pr2 >= 0 && pr1 >= 0) {
            if (arr2[pr2] > arr1[pr1]) {
                pr2--;
            } else if (arr2[pr2] <= arr1[pr1] && pl2 <= pr2) {
                long temp = arr1[pr1];
                arr1[pr1] = arr2[pl2];
                arr2[pl2] = temp;
                pl2++;
                pr1--;
            }
        }
        Utility.printLongArray(arr1);
        Utility.printLongArray(arr2);

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        Utility.printLongArray(arr1);
        Utility.printLongArray(arr2);
    }

    static class Pair {
        int time;
        char type;

        Pair(int time, char type){
            this.time = time;
            this.type = type;
        }
    }

    public static int minMeetingRooms(int[] start, int[] end) {
        Pair[] meets = new Pair[start.length*2];

        for(int i=0; i<start.length; i++){
            meets[i] = new Pair(start[i], 's');
        }

        for(int i=0; i<start.length; i++){
            meets[i+start.length] = new Pair(end[i], 'e');
        }

        int rooms = 0;
        Arrays.sort(meets, new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.time == o2.time){
                    return o1.type - o2.type;
                }
                return o1.time-o2.time;
            }
        });

        int max = Integer.MIN_VALUE;
        for(int i=0; i<meets.length; i++){
            if(meets[i].type == 's'){
                rooms++;
            } else {
                rooms--;
            }
            max = Math.max(max, rooms);
        }

        return max;

    }
}
