package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Test {

    public static void main(String[] args) {

        minPartition(43);
    }

    static void minPartition(int N)
    {
        int[] arr = new int[]{1,2,5,10,20,50,100,200,500,2000};
        HashSet<Integer> hs = new HashSet<>(Arrays.asList(1,2,5,10,20,50,100,200,500,2000));
        ArrayList<Integer> ans = new ArrayList<Integer>();
        util(N, hs, ans, arr);
        System.out.println(ans);
    }

    static void util(int N, HashSet<Integer> hs, ArrayList<Integer> ans, int[] arr){
        System.out.println(N);
        if(N==0){
            return;
        }
        int index = arr.length-1;
        while(index>=0){
            if(arr[index]<=N){
                ans.add(arr[index]);
                util(N-arr[index], hs, ans, arr);
                break;
            } else {
                index--;
            }
        }
    }
}
