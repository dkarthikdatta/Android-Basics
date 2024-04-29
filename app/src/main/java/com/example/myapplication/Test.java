package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Test {

    public static void main(String[] args) {

//        minPartition(43);
        rremove("abbc");
    }

    static String rremove(String s) {
        if(s.isEmpty()) return s;
        StringBuilder ans = new StringBuilder();
        helper(ans, s);
        return ans.toString();
    }

    static void helper(StringBuilder sb, String s){
        boolean [] adjacentFlag = new boolean[s.length()];
        //tag adjacent as true;
        for(int i = 1; i<s.length(); i++){
            if(s.charAt(i -1) == s.charAt(i)){
                adjacentFlag[i] = adjacentFlag[i - 1] =true;
            }
        }
        System.out.println("Adjacent Flag");
        for(int i =0; i<s.length(); i++){
            System.out.print(adjacentFlag[i] + " ");
        }
        System.out.println();

        StringBuilder rem = new StringBuilder();
        //find remaing elements not tagged as true
        for(int i =0 ;i< adjacentFlag.length; i++){
            if(!adjacentFlag[i]) rem.append(s.charAt(i));
        }

        //0 Adjacent element(s) exist, return!
        if(rem.length() == s.length()){
            sb.append(s);
            return;
        }
        helper(sb, rem.toString());
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
