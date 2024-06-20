package com.example.myapplication.dsAlgo.ds.LinkedList;

import static com.example.myapplication.test.AddLinkedLists.addTwoLists;

import com.example.myapplication.dsAlgo.LinkedListNode;
import com.example.myapplication.dsAlgo.Pair;
import com.example.myapplication.dsAlgo.Utility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
class LinkedPair {
    int val;
    LinkedListNode linkedListNode;
    public LinkedPair(int val, LinkedListNode linkedListNode){
        this.val = val;
        this.linkedListNode = linkedListNode;
    }
}

public class LinkedListSums {

    public static void main(String[] args) {
        LinkedListNode nodeClas = new LinkedListNode();
        LinkedListNode root = new LinkedListNode().getLinkedList();
//        Utility.printNode(root);

//        findMiddle(root);
//        reverseLinkedList(root);
//
//        rotateLinkedList(nodeClas.getLinkedList(new int[]{12, 26}), 1);
//        rotateRight(nodeClas.getLinkedList(new int[]{1,2,3,4,5}), 2);

//        int[] arr1 = {50, 114, 37, 66, 102, 11, 59, 92, 70, 84, 95, 106, 44, 57, 3, 38, 36, 23, 76, 112, 67, 17, 33, 22, 69, 74, 61, 53, 30, 9, 78, 86, 81, 12, 21, 100, 40, 98, 110};
//        int[] arr2 = {11, 20, 10, 37, 2, 24, 39, 40, 1, 4, 21, 22, 44, 17, 33};
//        LinkedListNode node1 = new LinkedListNode().getLinkedList(arr1);
//        LinkedListNode node2 = new LinkedListNode().getLinkedList(arr2);
//        findIntersection(node1, node2);


//        sortedMerge(nodeClas.getLinkedList(new int[]{5, 10, 15, 40}), nodeClas.getLinkedList(new int[]{2, 3, 20}));
        int[] addArray1 = {0, 1, 2, 2, 9, 2, 3};
        int[] addArray2 = {6, 4, 5, 5, 2, 5, 7, 4, 7, 9};
        addTwoLists(nodeClas.getLinkedList(addArray1), nodeClas.getLinkedList(addArray2));

        addTwoLinkedLists(nodeClas.getLinkedList(new int[]{4, 5}), nodeClas.getLinkedList(new int[]{3, 4, 5}));
    }

    LinkedListNode mergeKList(LinkedListNode[]arr,int K)
    {
        Comparator<LinkedPair> comparator = new Comparator<LinkedPair>() {
            @Override
            public int compare(LinkedPair o1, LinkedPair o2) {
                return o1.val-o2.val;
            }
        };
        PriorityQueue<LinkedPair> pq = new PriorityQueue<>(comparator);

        for(int i=0; i<arr.length; i++){
            pq.add(new LinkedPair(arr[i].data, arr[i]));
        }

        LinkedListNode dummy = new LinkedListNode(-1);
        LinkedListNode temp = dummy;

        while(pq.size()!=0){
            LinkedListNode curr = pq.poll().linkedListNode;
            temp.next = curr;
            if(curr.next!=null){
                pq.add(new LinkedPair(curr.next.data, curr.next));
            }
            temp = temp.next;
        }
        temp.next=null;
        return dummy.next;
    }

    static LinkedListNode sortedMerge1(LinkedListNode head1, LinkedListNode head2) {
        // This is a "method-only" submission.
        // You only need to complete this method

        LinkedListNode dummy = new LinkedListNode(-1);
        LinkedListNode ans = dummy;

        while(head1!=null && head2!=null){
            if(head1.data<head2.data){
                dummy.next=head1;
                head1=head1.next;
            } else {
                dummy.next=head2;
                head2=head2.next;
            }
            dummy = dummy.next;
        }

        if(head1!=null){
            dummy.next = head1;
        } else {
            dummy.next = head2;
        }
        return ans.next;

    }

    /**
     * https://www.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1
     *
     * @param root
     */

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

    /**
     * https://www.geeksforgeeks.org/problems/reverse-a-linked-list/1
     *
     * @param root
     * @return
     */

    private static LinkedListNode reverseLinkedList(LinkedListNode root) {
        LinkedListNode prev = null;
        LinkedListNode curr;
        while (root != null) {
            curr = root.next;
            root.next = prev;
            prev = root;
            root = curr;
        }
        Utility.printLinkedListNode(prev);
        return prev;
    }

    private static void rotateLinkedList(LinkedListNode root, int k) {
        int size = 0;
        LinkedListNode dup = root;
        while (dup.next != null) {
            size++;
            dup = dup.next;
        }
        dup.next = root;
        k = k % size;
        while (k > 0) {
            k--;
            dup = dup.next;
        }
        LinkedListNode curr = dup.next;
        dup.next = null;
        System.out.println("dup ll: ");
        Utility.printLinkedListNode(curr);
    }

    public static LinkedListNode rotateRight(LinkedListNode head, int k) {
        LinkedListNode dup = head;
        int size = 0;
        while(dup.next!=null){
            size++;
            dup = dup.next;
        }

        dup.next = head;

        k = k%size;

        int rotate = size-k;

        System.out.println("Size = " + size);
        System.out.println("k = " + k);
        System.out.println("rotate = " + rotate);

        while(rotate>0){
            dup = dup.next;
            rotate--;
        }
        LinkedListNode ans = dup.next;
        dup.next = null;
        System.out.println("dup ll: ");
        Utility.printLinkedListNode(ans);
        return ans;
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

    /**
     * https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
     *
     * @param num1
     * @param num2
     */
    private static void addTwoLinkedLists(LinkedListNode num1, LinkedListNode num2) {
        //reverse numbers and add. carry the extra and add.

        LinkedListNode reverse1 = reverseLinkedList(num1);
        LinkedListNode reverse2 = reverseLinkedList(num2);

//        Utility.printLinkedListNode(reverse1);
//        Utility.printLinkedListNode(reverse2);

        LinkedListNode ans = new LinkedListNode(0);
        LinkedListNode res = ans;
        int carry = 0;
        int sum = 0;
        while (reverse1 != null && reverse2 != null) {
            sum = carry + reverse1.data;
            sum = sum + reverse2.data;
            reverse1 = reverse1.next;
            reverse2 = reverse2.next;
            carry = sum / 10;
            sum = sum % 10;
            LinkedListNode curr = new LinkedListNode(sum);
            ans.next = curr;
            ans = curr;
        }
        if (reverse1 != null) {
            while (reverse1 != null) {
                sum = carry + reverse1.data;
                reverse1 = reverse1.next;
                carry = sum / 10;
                sum = sum % 10;
                LinkedListNode curr = new LinkedListNode(sum);
                ans.next = curr;
                ans = curr;
            }
        } else {
            while (reverse2 != null) {
                sum = carry + reverse2.data;
                reverse2 = reverse2.next;
                carry = sum / 10;
                sum = sum % 10;
                LinkedListNode curr = new LinkedListNode(sum);
                ans.next = curr;
                ans = curr;
            }
        }

        if (carry > 0) {
            LinkedListNode curr = new LinkedListNode(carry);
            ans.next = curr;
            ans = curr;
        }

        LinkedListNode result = reverseLinkedList(res.next);
        while (result.data == 0 && result.next != null) {
            result = result.next;
        }
        Utility.printLinkedListNode(reverseLinkedList(res.next));
    }

    private static void sortedMerge(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode ans = new LinkedListNode(0);

        LinkedListNode tail = ans;

        while (true) {
            if (head1 == null) {
                tail.next = head2;
                break;
            }
            if (head2 == null) {
                tail.next = head1;
                break;
            }

            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        Utility.printLinkedListNode(ans.next);
    }
}
