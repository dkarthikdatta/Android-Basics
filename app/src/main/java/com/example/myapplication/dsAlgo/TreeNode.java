package com.example.myapplication.dsAlgo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * TreeNode root = new TreeNode(1,
 * new TreeNode(2, null, null),
 * new TreeNode(3, null, null));
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public int hd = 0;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**'
     *
     * /\
     * /
     *          1
     *      2      3
     *    4  5    6  7
     */
    public TreeNode getRoot() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, null, null),
                        new TreeNode(5, null, null)),
                new TreeNode(3,
                        new TreeNode(6, null, null),
                        new TreeNode(7, null, null)));
        return root;
    }

    public TreeNode getRootBig() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4
                                , new TreeNode(8, null, null),
                                new TreeNode(9, null, null)),
                        new TreeNode(5,
                                new TreeNode(10, null, null),
                                new TreeNode(11, null, null))),
                new TreeNode(3,
                        new TreeNode(6,
                                new TreeNode(12, null, null),
                                new TreeNode(13, null, null)),
                        new TreeNode(7,
                                new TreeNode(14, null, null),
                                new TreeNode(15, null, null))));
        return root;
    }

    public TreeNode getBSTRoot() {
        TreeNode root = new TreeNode(7,
                new TreeNode(5,
                        new TreeNode(2, null, null),
                        new TreeNode(6, null, null)),
                new TreeNode(9,
                        new TreeNode(8, null, null),
                        new TreeNode(10, null, null)));
        return root;
    }

    public TreeNode getBSTRoot2() {
        TreeNode root = new TreeNode(2,
                new TreeNode(1, null, null),
                new TreeNode(3, null, null));
        return root;
    }

    public TreeNode getSymmetricTree() {
        TreeNode root = new TreeNode(7,
                new TreeNode(5,
                        new TreeNode(2, null, null),
                        new TreeNode(6, null, null)),
                new TreeNode(5,
                        new TreeNode(2, null, null),
                        new TreeNode(6, null, null)));
        return root;
    }

    public TreeNode deSerialize(ArrayList<Integer> A) {
        if (A.size() == 0) {
            return new TreeNode(0);
        }

        int helper = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(A.get(0));
        q.add(root);
        while (q.size() != 0) {
            helper++;
            TreeNode parent = q.poll();
            if (A.get(helper) != null) {
                TreeNode temp = new TreeNode(A.get(helper));
                parent.left = temp;
                q.add(temp);    //add only non null nodes.only those nodes requires children
            }
            helper++;
            if (A.get(helper) != null) {
                TreeNode temp2 = new TreeNode(A.get(helper));
                parent.right = temp2;
                q.add(temp2);
            }
        }
        return root;
    }
}

