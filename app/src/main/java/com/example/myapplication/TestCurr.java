package com.example.myapplication;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Properties;

public class TestCurr {
    public static void main(String[] args) {
//        System.out.println(minOperations(new int[]{3, 7, 9, 7}));

        int ans = minIncrementForUnique(new int[]{1, 2, 2});
        System.out.println(ans);
    }

    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 1;
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
        }
        while(k>0){
            int curr = pq.poll();
            curr++;
            pq.add(curr);
            k--;
        }

        while(!pq.isEmpty()){
            ans = ans * pq.poll();
        }
        return ans;
    }
    public static int minIncrementForUnique(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!hs.contains(nums[i])) {
                hs.add(nums[i]);
            } else {
                int curr = nums[i];
                while (hs.contains(curr)) {
                    curr++;
                    ans++;
                }
                hs.add(curr);
            }
        }
        return ans;
    }

    private static int minOperations(int[] arr) {
        Arrays.sort(arr);
        int track = 0;
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            track = Math.max(track, arr[i]);
            ans = ans + track - arr[i];
            track++;
        }
        return ans;
    }
}
