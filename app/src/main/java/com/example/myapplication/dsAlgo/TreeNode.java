package com.example.myapplication.dsAlgo;

/**
 * TreeNode root = new TreeNode(1,
 * new TreeNode(2, null, null),
 * new TreeNode(3, null, null));
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

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

}

