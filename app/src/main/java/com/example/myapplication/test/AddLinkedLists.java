package com.example.myapplication.test;


import java.util.ArrayList;

import com.example.myapplication.dsAlgo.LinkedListNode;

class AddLinkedLists {
    //Function to add two numbers represented by linked list.

    public static void main(String[] args) {
        LinkedListNode n1 = new LinkedListNode(4);
        n1.next = new LinkedListNode(5);
        LinkedListNode n2 = new LinkedListNode(3);
        LinkedListNode dupN2 = n2;
        n2.next = new LinkedListNode(4);
        n2 = n2.next;
        n2.next = new LinkedListNode(5);

        printNode(addTwoLists(n1, dupN2));
    }

    static LinkedListNode addTwoLists(LinkedListNode num1, LinkedListNode num2) {
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

        int number1 = 0;
        int number2 = 0;

        while (num1 != null) {
            number1 = number1 + (num1.data * m1);
            num1 = num1.next;
            m1 = m1 / 10;
        }

        while (num2 != null) {
            number2 = number2 + (num2.data * m2);
            num2 = num2.next;
            m2 = m2 / 10;
        }

//        System.out.println(number1);
//        System.out.println(number2);
        int net = number1 + number2;
        LinkedListNode ans = new LinkedListNode(0);
        LinkedListNode dup = ans;
//        ans.next = null;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while (net != 0) {
            arr.add(net % 10);
            net = net / 10;
        }
        printArrayList(arr);
        if (arr.size() > 0) {
            ans.data = arr.get(arr.size() - 1);
        }
        for (int i = arr.size() - 2; i >= 0; i--) {
            ans.next = new LinkedListNode(arr.get(i));
            ans = ans.next;
        }
        ans.next = null;
        return dup;
    }

    static private void printNode(LinkedListNode linkedListNode) {
        LinkedListNode dup = linkedListNode;
        while (dup != null) {
            System.out.print(dup.data);
            dup = dup.next;
        }
        System.out.println();
    }

    static private void printArrayList(ArrayList<Integer> arrayList) {
        for (int i : arrayList) {
            System.out.print(i);
        }
        System.out.println();
    }
}