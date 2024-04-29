package com.example.myapplication.dsAlgo.ds.Graphs;

// Undirected graph
// directed graph

// Cyclic and Acyclic


import com.example.myapplication.dsAlgo.GraphAdjList;
import com.example.myapplication.dsAlgo.Pair;
import com.example.myapplication.dsAlgo.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class GraphSums {

    //Adjacency list

    /**
     *
     * Undirected - unweighted graph
     *
     *  1-------2-------5
     *  |       |
     *  |       |
     *  |       |
     *  3-------4
     *
     *  Representation in Adjacency List
     *  List of list of Integers
     *
     *  [{2,3},{1,4,5}, {1,4}, {2,3}, {2}]
     *
     * Undirected - weighted graph
     *
     *     9        7
     *  1-------2-------5
     *  |       |
     *  |13     |1
     *  |       |
     *  3-------4
     *      10
     *  Representation in Adjacency List
     *
     *  (node, weight)
     *  List of list of Pairs
     *  [{(2,9),(3,13)},
     *      {(1,9), (4,1), (5,7) },
     *      {(1,13),(4,10),
     *      {(2,1), (3,10)}
     *      {(2,5)}]
     */

    //BFS - Breadth for search

    /**
     *              1
     *            /   \
     *           2     6
     *          /\    / \
     *         3  4  7   8
     *             \/
     *             5
     *
     *   BFS from 1 -> 1,2,6,3,4,7,8,5
     *   BFS from 6 -> 6,1,7,8,2,5,3,4
     *
     *  DFS from 1 -> 1,2,3,4,5,7,6,8
     *  or
     *              -> 1,2,4,5,7,6,8,3
     *
     *  DFS from 6 -> 6,1,2,3,4,5,7,8
     *
     *  Topological sort
     */

    public static void main(String[] args) {
        GraphAdjList graphAdjList = new GraphAdjList();
        ArrayList<ArrayList<Integer>> adjList = graphAdjList.undirectedAdjList();
//        bfs(adjList, 6);
//        dfs(adjList, 6);
//
//
//        char[][] grid = {
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'},
//        };
//        numIslands(grid);

//        topologicalSort(graphAdjList.directedAcyclicGraph());
//        topologicalSort(graphAdjList.directedAcyclicGraph2());
//        cycleInUndirectedGraph(graphAdjList.unDirectedCyclicGraph());
        cycleInUndirectedGraph(graphAdjList.undirectedAdjList());
//        cycleInUndirectedGraph(graphAdjList.unDirectedAcyclicGraph());
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adjList, int n) {
        int[] vis = new int[adjList.size()+1];
        ArrayList<Integer> ans = new ArrayList<>();
        vis[n] = 1;
        dfsUtil(adjList, vis, ans, n);
        Utility.printArrayList(ans,"DFS of Graph");
    }

    private static void dfsUtil(ArrayList<ArrayList<Integer>> adjList, int[] vis, ArrayList<Integer> ans, int n) {
        vis[n] = 1;
        ans.add(n);
        ArrayList<Integer> currAdj = adjList.get(n-1);
        for(int i=0; i<currAdj.size(); i++){
            if(vis[currAdj.get(i)]==0){
                dfsUtil(adjList, vis, ans, currAdj.get(i));
            }
        }
    }


    private static void bfs(ArrayList<ArrayList<Integer>> adjList, int n) {
        int[] vis = new int[adjList.size()+1]; // since 1 based list
        vis[n] = 1;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        // store in q, pop q and add in ans. add popped int neighbours to q if not visited and mark them visited
        q.add(n);
        while (q.size()!=0){
            int size = q.size();
            int temp = q.poll();
            ans.add(temp);
            for(int i=0; i<size; i++){
                ArrayList<Integer> currAdj = adjList.get(temp-1);
                for (int j=0; j<currAdj.size(); j++){
                    if(vis[currAdj.get(j)] == 0){
                        vis[currAdj.get(j)] = 1;
                        q.add(currAdj.get(j));
                    }
                }
            }
        }

        Utility.printArrayList(ans, "Graph BFS");
    }

    // only Directed Acyclic graph
    private static void topologicalSort(ArrayList<ArrayList<Integer>> adjList) {
        int start = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[adjList.size()+1];

        for (int i = 1; i < adjList.size() + 1; i++) {
            if(vis[i] == false){
                topologicalSortUtil(adjList, vis, ans, i);
            }
        }
        Collections.reverse(ans);
        Utility.printArrayList(ans, "topological sort");
    }

    private static void topologicalSortUtil(ArrayList<ArrayList<Integer>> adjList, boolean[] vis, ArrayList<Integer> ans, int n) {
//        ans.add(n);
        vis[n] = true;
        ArrayList<Integer> curAdj = adjList.get(n-1);
        for(int i=0; i<curAdj.size(); i++){
            if(!vis[curAdj.get(i)]){
                topologicalSortUtil(adjList, vis, ans, curAdj.get(i));
            }
        }
        ans.add(n);
    }

    public static void numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
//                    Utility.print2DArray(grid);
                    islands++;
                    isLandDfs(grid, i, j);
                }
            }
        }

        System.out.println(islands);
    }

    private static void isLandDfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if (i < grid.length - 1 && grid[i + 1][j] == '1') {
            isLandDfs(grid, i + 1, j);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            isLandDfs(grid, i - 1, j);
        }
        if (j < grid[i].length - 1 && grid[i][j + 1] == '1') {
            isLandDfs(grid, i, j + 1);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            isLandDfs(grid, i, j - 1);
        }
    }

    private static void cycleInUndirectedGraph(ArrayList<ArrayList<Integer>> adjList) {
        // by bfs

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, -1));
        boolean[] vis = new boolean[adjList.size()+1];
        vis[1] = true;
        while (q.size() != 0) {

            for (int i = 0; i < q.size(); i++) {
                Utility.printQueue(q);
                Pair curr = q.poll();
                int currInt = curr.a;
                int parent = curr.b;
                for (int j = 0; j < adjList.get(currInt).size(); j++) {
                    int adjNode = adjList.get(currInt).get(j);
                    if(vis[adjNode] == false){
                        vis[adjNode] = true;
                        q.add(new Pair(adjNode, currInt));
                    } else if(parent != adjList.get(currInt).get(j)){
                        System.out.println("Circle Found");
                        return;
                    }
                }
            }
        }
        System.out.println("No circle found");
    }

}
