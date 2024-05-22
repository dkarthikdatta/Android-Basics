package com.example.myapplication.kotlin;


import com.example.myapplication.dsAlgo.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


class Solution {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(4,
//                new TreeNode(2,
//                        new TreeNode(1),
//                        new TreeNode(3)),
//                new TreeNode(7,
//                        new TreeNode(6),
//                        new TreeNode(9)));

        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3, null, null));
//        invertTree(root);
        System.out.println(findSpiral(root));
    }

    static ArrayList<Integer> findSpiral(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        boolean reverse = false;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int size = 0;
        q.add(root);

        while (q.size() != 0) {
            size = q.size();
            ArrayList<Integer> tempAns = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                tempAns.add(temp.val);

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

            if (reverse) {
                Collections.reverse(tempAns);
            }
            ans.addAll(tempAns);
            reverse = !reverse;

        }
        return ans;
    }

    public static TreeNode invertTree(TreeNode root) {
        printLevelOrder(root);
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        if (left != null) System.out.println("left node val = " + left.val);

        if (right != null) System.out.println("right node val = " + right.val);

        root.right = left;
        root.left = right;

        return root;
    }

    static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {

            // poll() removes the present head.
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.val + " ");

            // Enqueue left child
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            // Enqueue right child
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        System.out.println();
    }
}


