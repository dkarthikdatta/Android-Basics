package com.example.myapplication.dsAlgo.ds.LinkedList;

import com.example.myapplication.dsAlgo.LinkedListNode;
import com.example.myapplication.dsAlgo.Utility;

import java.util.ArrayList;
import java.util.HashSet;

public class LinkedListSums {

    public static void main(String[] args) {
        LinkedListNode nodeClas = new LinkedListNode();
        LinkedListNode root = new LinkedListNode().getLinkedList();
//        Utility.printNode(root);

//        findMiddle(root);
//        reverseLinkedList(root);

//        int[] arr1 = {50, 114, 37, 66, 102, 11, 59, 92, 70, 84, 95, 106, 44, 57, 3, 38, 36, 23, 76, 112, 67, 17, 33, 22, 69, 74, 61, 53, 30, 9, 78, 86, 81, 12, 21, 100, 40, 98, 110};
//        int[] arr2 = {11, 20, 10, 37, 2, 24, 39, 40, 1, 4, 21, 22, 44, 17, 33};
//        LinkedListNode node1 = new LinkedListNode().getLinkedList(arr1);
//        LinkedListNode node2 = new LinkedListNode().getLinkedList(arr2);
//        findIntersection(node1, node2);

        int[] addArray1 = {0, 1, 2, 2, 9, 2, 3};
        int[] addArray2 = {6, 4, 5, 5, 2, 5, 7, 4, 7, 9};
        addTwoLists(nodeClas.getLinkedList(addArray1), nodeClas.getLinkedList(addArray2));
    }

    private static void findMiddle(LinkedListNode root) {
        LinkedListNode temp = root;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        for (int i = 0; i < (size / 2) - 1; i++) {
            root = root.next;
        }
        System.out.println(root.data);
    }

    private static void reverseLinkedList(LinkedListNode root) {
        LinkedListNode prev = null;
        LinkedListNode curr;
        while (root != null) {
            curr = root.next;
            root.next = prev;
            prev = root;
            root = curr;
        }
        Utility.printLinkedListNode(prev);
    }

    private static void findIntersection(LinkedListNode head1, LinkedListNode head2) {
        {
            HashSet<Integer> hs = new HashSet();
            LinkedListNode dup = head2;
            while (dup != null) {
                hs.add(dup.data);
                dup = dup.next;
            }
            LinkedListNode tail = new LinkedListNode(0);
            LinkedListNode ans = tail;


            while (head1 != null) {
                if (hs.contains(head1.data)) {
                    tail.next = new LinkedListNode(head1.data);
                    tail = tail.next;
                }
                head1 = head1.next;
            }
            tail.next = null;

            Utility.printLinkedListNode(ans.next);
        }
    }

    private static void addTwoLists(LinkedListNode num1, LinkedListNode num2) {
        LinkedListNode dup1 = num1;
        LinkedListNode dup2 = num2;


        int size1 = 0;
        int size2 = 0;

        while (dup1 != null) {
            size1++;
            dup1 = dup1.next;
        }
        while (dup2 != null) {
            size2++;
            dup2 = dup2.next;
        }

        int m1 = 1;
        int m2 = 1;

        size1--;
        size2--;
        while (size1 != 0) {
            m1 = m1 * 10;
            size1--;
        }

        while (size2 != 0) {
            m2 = m2 * 10;
            size2--;
        }

        long number1 = 0;
        long number2 = 0;

        while (num1 != null) {
            number1 = number1 + ((long) num1.data * m1);
            num1 = num1.next;
            m1 = m1 / 10;
        }

        while (num2 != null) {
            number2 = number2 + ((long) num2.data * m2);
            num2 = num2.next;
            m2 = m2 / 10;
        }

//        System.out.println(number1);
//        System.out.println(number2);

        long net = number1 + number2;
//        System.out.println(net);
        LinkedListNode ans = new LinkedListNode(0);
        LinkedListNode dup = ans;
//        ans.next = null;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while (net != 0) {
            arr.add((int) (net % 10));
            net = net / 10;
        }
        if (arr.size() > 0) {
            ans.data = arr.get(arr.size() - 1);
        }
        for (int i = arr.size() - 2; i >= 0; i--) {
            ans.next = new LinkedListNode(arr.get(i));
            ans = ans.next;
        }
        ans.next = null;

        Utility.printLinkedListNode(dup);
    }
}
