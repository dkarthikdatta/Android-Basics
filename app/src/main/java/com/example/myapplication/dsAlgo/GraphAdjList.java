package com.example.myapplication.dsAlgo;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphAdjList {

    public GraphAdjList() {

    }

    /**
     * 1
     * /   \
     * 2     6
     * /\    / \
     * 3  4  7   8
     * \/
     * 5
     * <p>
     * BFS from 1 -> 1,2,6,3,4,7,8,5
     * BFS from 6 -> 6,1,7,8,2,5,3,4
     */

    public ArrayList<ArrayList<Integer>> undirectedAdjList() {
        ArrayList<Integer> one = new ArrayList<>(Arrays.asList(2, 6));
        ArrayList<Integer> two = new ArrayList<>(Arrays.asList(3, 4));
        ArrayList<Integer> three = new ArrayList<>(Arrays.asList(2));
        ArrayList<Integer> four = new ArrayList<>(Arrays.asList(2, 5));
        ArrayList<Integer> five = new ArrayList<>(Arrays.asList(4, 7));
        ArrayList<Integer> six = new ArrayList<>(Arrays.asList(1, 7, 8));
        ArrayList<Integer> seven = new ArrayList<>(Arrays.asList(6, 5));
        ArrayList<Integer> eight = new ArrayList<>(Arrays.asList(6));

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(one);
        ans.add(two);
        ans.add(three);
        ans.add(four);
        ans.add(five);
        ans.add(six);
        ans.add(seven);
        ans.add(eight);
        return ans;
    }

    /**
     * Directed Acyclic Graph
     * <p>
     * 3->6->1->7->8
     * |  |^ |
     * v  |  V
     * 2  5  4
     * <p>
     * Topological sort for this -> 5,3,6,2,1,7,4,8
     */

    public ArrayList<ArrayList<Integer>> directedAcyclicGraph() {
        ArrayList<Integer> one = new ArrayList<>(Arrays.asList(7));
        ArrayList<Integer> two = new ArrayList<>();
        ArrayList<Integer> three = new ArrayList<>(Arrays.asList(6));
        ArrayList<Integer> four = new ArrayList<>();
        ArrayList<Integer> five = new ArrayList<>(Arrays.asList(1));
        ArrayList<Integer> six = new ArrayList<>(Arrays.asList(1));
        ArrayList<Integer> seven = new ArrayList<>(Arrays.asList(4, 8));
        ArrayList<Integer> eight = new ArrayList<>(Arrays.asList());

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(one);
        ans.add(two);
        ans.add(three);
        ans.add(four);
        ans.add(five);
        ans.add(six);
        ans.add(seven);
        ans.add(eight);
        return ans;
    }

    /**
     * 1->4<-3
     * ^
     * |
     * 2
     * 1,2,3,4
     */
    public ArrayList<ArrayList<Integer>> directedAcyclicGraph2() {

        ArrayList<Integer> one = new ArrayList<>(Arrays.asList(4));
        ArrayList<Integer> two = new ArrayList<>(Arrays.asList(4));
        ArrayList<Integer> three = new ArrayList<>(Arrays.asList(4));
        ArrayList<Integer> four = new ArrayList<>();

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(one);
        ans.add(two);
        ans.add(three);
        ans.add(four);
        return ans;
    }


    /**
     * 5
     * |
     * 1-------2
     * |       |
     * |       |
     * 3-------4
     */

    public ArrayList<ArrayList<Integer>> unDirectedCyclicGraph() {
        ArrayList<Integer> one = new ArrayList<>(Arrays.asList(2, 3, 5));
        ArrayList<Integer> two = new ArrayList<>(Arrays.asList(1, 4));
        ArrayList<Integer> three = new ArrayList<>(Arrays.asList(1, 4));
        ArrayList<Integer> four = new ArrayList<>(Arrays.asList(2, 3));
        ArrayList<Integer> five = new ArrayList<>(Arrays.asList(1));

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(one);
        ans.add(two);
        ans.add(three);
        ans.add(four);
        ans.add(five);
        return ans;

    }


    /**
     * 5
     * |
     * 1       2
     * |       |
     * |       |
     * 3-------4
     */
    public ArrayList<ArrayList<Integer>> unDirectedAcyclicGraph() {
        ArrayList<Integer> one = new ArrayList<>(Arrays.asList(3, 5));
        ArrayList<Integer> two = new ArrayList<>(Arrays.asList(4));
        ArrayList<Integer> three = new ArrayList<>(Arrays.asList(1, 4));
        ArrayList<Integer> four = new ArrayList<>(Arrays.asList(2, 3));
        ArrayList<Integer> five = new ArrayList<>(Arrays.asList(1));

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(one);
        ans.add(two);
        ans.add(three);
        ans.add(four);
        ans.add(five);
        return ans;
    }
}