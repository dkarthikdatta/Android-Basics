package com.example.myapplication.dsAlgo.ds.Tree;

import com.example.myapplication.dsAlgo.TreeNode;
import com.example.myapplication.dsAlgo.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1
 * 2      3
 * 4  5    6  7
 */
public class BoundaryViews {

    public static void main(String[] args) {
        TreeNode root = new TreeNode().getRoot();
//        levelOrderTraversal(root);
//        levelOrderTraversalSpiral(root);
//        leftView(root);
//        rightView(root);

        bottomView(new TreeNode().deSerialize(new ArrayList<>(Arrays.asList(20, 8, 22, 5, 3, null, 25, null, null, 10, 14, null, null, null, null, null, null))));
//        System.out.println(checkForBST(root));
//        System.out.println(checkForBST(new TreeNode().getBSTRoot()));
//        System.out.println(checkForBST(new TreeNode().getBSTRoot2()));

//        System.out.println(twoTreesAreIdentical(root, root)); // true
//        System.out.println(twoTreesAreIdentical(root, new TreeNode().getBSTRoot())); // false

//        System.out.println(symmetricTree(new TreeNode().getSymmetricTree())); // true
//        System.out.println(symmetricTree(root)); // false

//        pathToNode(root, 5); // 125
//        pathToNode(root, 6); // 136

//        pathBetweenTwoNodes(new TreeNode().getRootBig(), 10, 13);

//        ArrayList<Integer> treeNodeList = new ArrayList<>();
//        serialize(root, treeNodeList);
//        TreeNode root2 = deSerialize(treeNodeList);
//        System.out.println(twoTreesAreIdentical(root, root2));

//        System.out.println("In Order");
//        inOrder(root);
//        System.out.println();
//        System.out.println("Pre Order");
//        preOrder(root);
//        System.out.println();
//        System.out.println("Post Order");
//        postOrder(root);

//        Utility.printDLLFromTreeNode(bToDLL(root));
//        countLeafNodes(root);
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    private static void levelOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (q.size() != 0) {
            int currSize = q.size();

            for (int i = 0; i < currSize; i++) {
                TreeNode temp = q.poll();
                ans.add(temp.val);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

        }
        Utility.printArrayList(ans, "LevelOrderTraversal");
    }

    private static void levelOrderTraversalSpiral(TreeNode root) {
        if (root == null)
            return;
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean reverse = false;

        while (q.size() != 0) {
            int currSize = q.size();
            ArrayList<Integer> tempList = new ArrayList<>();

            for (int i = 0; i < currSize; i++) {
                TreeNode temp = q.poll();
                tempList.add(temp.val);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            if (reverse) {
                Collections.reverse(tempList);
            }
            ans.addAll(tempList);
            reverse = !reverse;
        }
        Utility.printArrayList(ans, "LevelOrderTraversalSpiral");
    }

    private static void leftView(TreeNode root) {
        if (root == null)
            return;
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (q.size() != 0) {
            int currSize = q.size();

            ans.add(q.peek().val);  // first value in the q in every iteration

            for (int i = 0; i < currSize; i++) {
                TreeNode temp = q.poll();
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

        }
        Utility.printArrayList(ans, "LeftView");
    }

    private static void rightView(TreeNode root) {
        if (root == null)
            return;
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (q.size() != 0) {
            int currSize = q.size();

            for (int i = 0; i < currSize; i++) {

                TreeNode temp = q.poll();

                if (i == currSize - 1) {
                    ans.add(temp.val);
                }

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

        }
        Utility.printArrayList(ans, "RightView");
    }

    private static void bottomView(TreeNode root) {
        HashMap<Integer, TreeNode> hm = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int minHd = Integer.MAX_VALUE;
        int maxHd = Integer.MIN_VALUE;
        while (q.size() != 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    curr.left.hd = curr.hd - 1;
                    q.add(curr.left);
                    hm.put(curr.left.hd, curr.left);
                    minHd = Math.min(minHd, curr.left.hd);
                }
                if (curr.right != null) {
                    curr.right.hd = curr.hd + 1;
                    q.add(curr.right);
                    hm.put(curr.right.hd, curr.right);
                    maxHd = Math.max(maxHd, curr.right.hd);
                }
            }
        }
        for (int i = minHd; i <= maxHd; i++) {
            System.out.print(hm.get(i).val + " ");
        }
    }

    private static boolean checkForBST(TreeNode node) {
        return checkForBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkForBSTUtil(TreeNode node, int left, int right) {
        if (node == null) {
            return true;
        }

        if (node.val < left || node.val > right) {
            return false;
        }
        return checkForBSTUtil(node.left, left, node.val - 1) && checkForBSTUtil(node.right, node.val + 1, right);
    }

    private static boolean twoTreesAreIdentical(TreeNode node1, TreeNode node2) {
        return twoTreesAreIdenticalUtil(node1, node2);
    }

    private static boolean twoTreesAreIdenticalUtil(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || (node1.val != node2.val)) {
            return false;
        }
        return twoTreesAreIdenticalUtil(node1.left, node2.left) && twoTreesAreIdenticalUtil(node1.right, node2.right);
    }

    private static boolean symmetricTree(TreeNode node) {
        return symmetricTreeUtil(node, node);
    }

    private static boolean symmetricTreeUtil(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || (node1.val != node2.val)) {
            return false;
        }
        return twoTreesAreIdenticalUtil(node1.left, node2.right) && twoTreesAreIdenticalUtil(node1.right, node2.left);
    }

    private static void pathToNode(TreeNode node, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        pathToNodeUtil(node, target, ans);
        Utility.printArrayList(ans, "pathToNode");
    }

    private static boolean pathToNodeUtil(TreeNode node, int target, ArrayList<Integer> ans) {
        if (node == null) {
            return false;
        }
        ans.add(node.val);

        if (node.val == target) {
            return true;
        }

        if (pathToNodeUtil(node.left, target, ans) || pathToNodeUtil(node.right, target, ans)) {
            return true;
        }

        ans.remove(ans.size() - 1);
        return false;
    }

    // find path to two nodes separately. remove the common path between 2 paths. just keep 1 intersection point
    private static void pathBetweenTwoNodes(TreeNode node, int x, int y) {
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();
        pathToNodeUtil(node, x, path1);
        pathToNodeUtil(node, y, path2);

        int s1 = path1.size();
        int s2 = path2.size();

        int i = 0;
        int j = 0;

        int intersection = -1;
        while (i < s1 && j < s2) {
            if ((i == j) && (path1.get(i) == path2.get(j))) {
                i++;
                j++;
            } else {
                intersection = j - 1;
                break;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        //reverse of remaining path 1
        for (int a = s1 - 1; a > intersection; a--) {
            ans.add(path1.get(a));
        }

        for (int a = intersection; a < s2; a++) {
            ans.add(path2.get(a));
        }
        Utility.printArrayList(ans, "pathBetween2Nodes");
    }

    private static void LCA(TreeNode node, int x, int y) {
        // to do
    }

    // converting tree into ArrayList.
    // Level order traversal, by adding nulls too
    private static void serialize(TreeNode root, ArrayList<Integer> A) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while (q.size() != 0) {
            int currSize = q.size();
            for (int i = 0; i < currSize; i++) {
                TreeNode temp = q.poll();
                if (temp != null) {
                    q.add(temp.left);   // adding temp.left even if temp.left is null
                    q.add(temp.right);  // adding temp.right even if temp.right is null
                    A.add(temp.val);
                } else {
                    A.add(null);    // Ans Array contains numbers and null (for leaf nodes)
                }
            }
        }
        Utility.printArrayList(A, "Serialize Tree");
    }

    private static TreeNode deSerialize(ArrayList<Integer> A) {
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

    static TreeNode head;

    //Binary tree to Doubly Linked List

    private static TreeNode bToDLL(TreeNode root) {
        if (root == null) {
            return null;
        }

        //reverse inorder
        bToDLL(root.right);

        //add root to left side of head and shift head to left

        root.right = head;

        if (head != null) {
            head.left = root;
        }

        //shift head to left
        head = root;

        //reverse inorder
        bToDLL(root.left);

        return head;
    }

    // Count no of leaf nodes

    private static void countLeafNodes(TreeNode root) {
        System.out.println("Number of leaf Nodes: " + countLeafNodesUtil(root));
    }

    private static int countLeafNodesUtil(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeafNodesUtil(root.left) + countLeafNodesUtil(root.right);
    }

}
