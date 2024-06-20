package com.example.myapplication.dsAlgo.ds.Arrays;

import com.example.myapplication.dsAlgo.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCMedium {

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        threeSum(nums);

        System.out.println(search(new int[]{3, 5, 1}, 1));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            String newSorted = new String(sorted);
            if (!hashMap.containsKey(newSorted)) {
                hashMap.put(newSorted, new ArrayList<>());
            }
            hashMap.get(newSorted).add(strs[i]);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int currSum = nums[i] + nums[j] + nums[k];
                if (currSum == 0) {
                    ArrayList<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    curr.add(nums[k]);
                    ans.add(curr);
                    System.out.println("i = " + i + "j = " + j + " k = " + k);
                    j++;
                    k--;
                } else if (currSum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        Utility.print2DArrayListInt(ans);
        return ans;
    }
//
//    public static void search(int[] nums, int target) {
//
//        int pivot = 0;
//        int i=0;
//        int j = nums.length;
//        while(i<j){
//            int mid = (i+j)/2;
//            if(nums[mid]>nums[mid+1] || nums[mid]<nums[mid-1]){
//                pivot = mid;
//                break;
//            } else if(nums[i]<nums[mid]){
//                i = mid +1;
//            } else {
//                j = mid -1;
//            }
//        }
//
//        System.out.println("pivot = " + pivot);
//    }

    public static int search(int[] nums, int target) {

        int pivot = 0;
        int i = 0;
        int j = nums.length;
        while (i < j) {
            int mid = (i + j) / 2;
            if ((mid < nums.length - 1 && nums[mid] > nums[mid + 1]) || (mid > 0 && nums[mid] < nums[mid - 1])) {
                pivot = mid;
                break;
            } else if (nums[i] < nums[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        int firstStart = 0;
        int firstEnd = pivot;

        int secondStart = pivot;
        int secondEnd = nums.length - 1;

        System.out.println("firstStart = " + firstStart);
        System.out.println("firstEnd = " + firstEnd);

        while (firstStart <= firstEnd) {
            int mid = (firstStart + firstEnd) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                firstStart = mid + 1;
            } else {
                firstEnd = mid - 1;
            }
        }
        System.out.println("secondStart = " + secondStart);
        System.out.println("secondEnd = " + secondEnd);

        while (secondStart <= secondEnd) {
            int mid = (secondStart + secondEnd) / 2;
            System.out.println("mid = " + mid);
            System.out.println("target = " + target);
            if (nums[mid] == target) {
                System.out.println("ans = " + mid);
                return mid;
            } else if (target < nums[mid]) {
                System.out.println("target = " + target);
                System.out.println("less condition " + nums[mid]);
                secondEnd = mid - 1;
            } else {
                System.out.println("target = " + target);
                System.out.println("greater condition " + nums[mid]);
                secondStart = mid + 1;
            }
            System.out.println("secondStart = " + secondStart);
            System.out.println("secondEnd = " + secondEnd);
        }

        System.out.println("pivot = " + pivot);

        return -1;
    }
}
