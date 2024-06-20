package com.example.myapplication.dsAlgo.ds.Queue;

import com.example.myapplication.dsAlgo.Pair;
import com.example.myapplication.dsAlgo.Utility;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class QueueSums {

    public static void main(String[] args) {
        firstNonRepeating("wwpyedwrebkbvmvkvvesansqszwtrknvehhgdiqnhietykcgujlclwgyluryjfiaeelhefputiuxtbaedbtlzegpwhmiloosqefh");

        int[][] rotten = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
//        int[][] rotten = {{0, 2}};
        orangesRotting(rotten);
    }

    /**
     * https://www.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
     *
     * @param s
     */
    private static void firstNonRepeating(String s) {
        //add chars in q and set if not present in set. if present in hash, just remove from q.
        // append q start everytime if q is not null. else #
        HashSet<Character> hashSet = new HashSet<>();
        Queue<Character> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!hashSet.contains(c)) {
                hashSet.add(c);
                q.add(c);
            } else {
                q.remove(c);
            }
            ans.append(q.peek() == null ? '#' : q.peek());
        }
        System.out.println("First Non Repeating = " + ans);
    }

    /**
     * https://www.geeksforgeeks.org/problems/rotten-oranges2536/1
     *
     * @param grid
     */

    private static void orangesRotting(int[][] grid) {
        // BFS, queue
        Queue<Pair> rotten = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rotten.add(new Pair(i, j));
                }
            }
        }
        int time = 0;
        Utility.print2DArray(grid);

        if (allAreRotten(grid)) {
            System.out.println("Time taken to rot all = " + time);
            return;
        }

        while (rotten.size() != 0) {
            int size = rotten.size();
            for (int index = 0; index < size; index++) {
                Pair curr = rotten.poll();
                makeRotten(grid, curr, rotten);
            }
            Utility.print2DArray(grid);
            time++;
            if (allAreRotten(grid)) {
                System.out.println("Time taken to rot all = " + time);
                return;
            }
        }
        System.out.println("Time taken to rot all = " + "-1");
    }

    private static boolean allAreRotten(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void makeRotten(int[][] grid, Pair curr, Queue<Pair> rotten) {
        int i = curr.a;
        int j = curr.b;

        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            grid[i - 1][j] = 2;
            rotten.add(new Pair(i - 1, j));
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            grid[i + 1][j] = 2;
            rotten.add(new Pair(i + 1, j));
        }
        if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
            grid[i][j + 1] = 2;
            rotten.add(new Pair(i, j + 1));
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            grid[i][j - 1] = 2;
            rotten.add(new Pair(i, j - 1));
        }
    }
}
