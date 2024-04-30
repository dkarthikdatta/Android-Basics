package com.example.myapplication.dsAlgo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;

public class Utility {
    static public void printArrayList(ArrayList<Integer> arrayList, String metaData) {
        System.out.println("Printing ArrayList" + metaData);
        for (Integer i : arrayList) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static public void print2DArray(int[][] image) {
        System.out.println("Printing 2DArray");
        for (int[] ints : image) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    static public void print2DArray(char[][] image) {
        System.out.println("Printing 2DArray");
        for (char[] ints : image) {
            for (char anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    static public void printArray(int[] arr) {
        System.out.println("Printing Array");
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    static public void printLongArray(long[] arr) {
        System.out.println("Printing Array");
        for (long n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    static public void printLinkedListNode(LinkedListNode linkedListNode) {
        LinkedListNode dup = linkedListNode;
        while (dup != null) {
            System.out.print(dup.data + " ");
            dup = dup.next;
        }
        System.out.println();
    }

    static public void printCharacterArrayList(ArrayList<Character> characterArrayList) {
        System.out.println("Printing Character ArrayList");
        for (char c : characterArrayList) {
            System.out.print(c);
        }
        System.out.println();
    }

    static public void printArrayListString(ArrayList<String> stringArrayList) {
        System.out.println("Printing String ArrayList");
        for (String s : stringArrayList) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    static public void printArrayList(ArrayList<Long> arrayList) {
//        System.out.println("Printing Long ArrayList");
        for (Long s : arrayList) {
            System.out.print(s + " ");
        }
        System.out.println();
    }


    static public void printHashSetIntegers(HashSet<Integer> hs) {
        System.out.println("Printing Hashset values");
        for (int n : hs) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

//    static public void delimiter(){
//        String s = "50 114 37 66 102 11 59 92 70 84 95 106 44 57 3 38 36 23 76 112 67 17 33 22 69 74 61 53 30 9 78 86 81 12 21 100 40 98 110";
//        s.
//    }

    static public void printQueue(Queue<Pair> queue) {
        System.out.println("Printing queue");
        for (Pair ele : queue) {
            System.out.print("(" + ele.a + ", " + ele.b + ")");
        }
        System.out.println();
    }

    public static void printDLLFromTreeNode(TreeNode treeNode) {
        System.out.println("Printing Doubly Linked List from TreeNode: ");
        while (treeNode != null) {
            System.out.print(treeNode.val + " ");
            treeNode = treeNode.right;
        }
    }
}
