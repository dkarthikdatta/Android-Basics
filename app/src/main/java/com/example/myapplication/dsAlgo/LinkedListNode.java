package com.example.myapplication.dsAlgo;


/**
 * Node n1 = new Node(4);
 * n1.next = new Node(5);
 * Node n2 = new Node(3);
 * Node dupN2 = n2;
 * n2.next = new Node(4);
 * n2 = n2.next;
 * n2.next = new Node(5);
 */
public class LinkedListNode {
    public int data;
    public LinkedListNode next;

    public LinkedListNode() {

    }

    public LinkedListNode(int d) {
        data = d;
        next = null;
    }

    public LinkedListNode getLinkedList() {
        LinkedListNode root = new LinkedListNode(1);
        LinkedListNode two = new LinkedListNode(2);
        LinkedListNode three = new LinkedListNode(3);
        LinkedListNode four = new LinkedListNode(4);
        LinkedListNode five = new LinkedListNode(5);
        LinkedListNode six = new LinkedListNode(6);
        root.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = null;
        return root;
    }

    public LinkedListNode getLinkedList(int[] arr) {
        LinkedListNode node = new LinkedListNode(0);
        LinkedListNode ans = node;
        for (int d : arr) {
            node.next = new LinkedListNode(d);
            node = node.next;
        }
        node.next = null;
        return ans.next;
    }

}
