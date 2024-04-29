package com.example.myapplication.test;


import java.util.LinkedList;
import java.util.Queue;

public class TestJava {

    public static void main(String[] args) {
        Solution soln = new Solution();
        int[] w = new int[] {1,2,3,4,5,6,7,8,9,10};
//        System.out.println(soln.shipWithinDays(w, 5));
//        System.out.println(soln.shipWithinDays1(w, 5));

        int[][] arr = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0, 1, 1, 0},
                {1, 0, 1, 1, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 0, 1, 1, 0, 0},
                {1, 1, 1, 1, 0, 1, 1, 0}
        };
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.shortestDistance(11,8 , arr, 4, 0));
    }

}




// User function Template for Java
class Pair{
    int x;
    int y;
    int dist;
    Pair(int x , int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
class Solution1 {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        if(A[0][0] == 0){
            return 0;
        }

        int ans = -1;

        int[][] vis = new int[N][M];

        for(int i=0; i<vis.length; i++){
            for(int j=0; j<vis[i].length; j++){
                vis[i][j] = Integer.MAX_VALUE;
            }
        }
        print2DArray(vis);

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0, 0, 0));
        while(q.size()!=0){
            print2DArray(vis);

            Pair temp = q.poll();
            System.out.println("Polling q, row:  " + temp.x  + " col: " + temp.y+  " dist: " + temp.dist);
            int row = temp.x;
            int col = temp.y;
            int dist = temp.dist;

            int left = col-1;
            int right = col+1;
            int top = row-1;
            int down = row+1;

            if(row == X && col == Y){
                ans = dist;
                break;
            }

            if(left>=0){
                if(A[row][left] == 1 && vis[row][left]>dist){
                    vis[row][left] = dist + 1;
                    q.add(new Pair(row, left, dist + 1));
                }
            }
            if(right<M){
                if(A[row][right] == 1 && vis[row][right]>dist){
                    vis[row][right] = dist + 1;
                    q.add(new Pair(row, right, dist + 1));
                }
            }
            if(top>=0){
                if(A[top][col] == 1 && vis[top][col]>dist){
                    vis[top][col] = dist + 1;
                    q.add(new Pair(top, col, dist + 1));
                }
            }
            if(down<N){
                if(A[down][col] == 1 && vis[down][col]>dist){
                    vis[down][col] = dist + 1;
                    q.add(new Pair(down, col, dist + 1));
                }
            }

        }
        return ans;

    }

    public static void print2DArray(int[][] image) {
        System.out.println();
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
};

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = Integer.MIN_VALUE;
        int end = 0;

        for(int i=0; i<weights.length; i++){
            start = Math.max(weights[i], start);
            end = end+weights[i];
        }

        int mid = (start+end)/2;

        while(start<end){
//            mid = (start+end)/2;
             mid = start + (end-start)/2;
//            System.out.println("start = " + start + " end = "+ end);
            System.out.println("start end mid value is--"+start+" "+end+" "+mid);
            if(possible(weights, mid, days)){
//                System.out.println("mid: " + mid);
                end = mid;
                System.out.println("in if");
            } else {
//                System.out.println("mid: " + mid);
                start = mid+1;
//                mid = (start+end)/2;
                System.out.println("in else");
            }
        }
        return start;
    }

    boolean possible(int[] weights, int capacity, int days){
        int currDays = 1;
        int load = 0;
        for(int i=0; i<weights.length; i++){
            if(load + weights[i] > capacity){
                currDays = currDays + 1;
                load = weights[i];
            } else {
                load = load + weights[i];
            }
        }
        System.out.println("capaciity = " + capacity + "currDays = " + currDays);
        return currDays<=days;
    }

    public int shipWithinDays1(int[] weights, int D) {
        int left=Integer.MIN_VALUE, right=0;
        for(int w : weights) {
            left = Math.max(left , w);
            right += w;
        }

        while(left < right) {
            int mid = left + (right-left)/2;
            System.out.println("left right mid value is--"+left+" "+right+" "+mid);
            if(isValid(weights, mid) <= D) {
                right= mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
    private int isValid(int[] weights, int target) {
        int total = 0;
        int count = 1;
        for(int w : weights) {
            total+=w;
            if(total > target) {
                count++;
                total = w;
            }
        }
        return count;
    }
}