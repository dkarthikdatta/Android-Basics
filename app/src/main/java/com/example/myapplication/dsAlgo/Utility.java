package com.example.myapplication.dsAlgo;

import com.example.myapplication.machinecoding.chess.Pieces.Piece;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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

    static public void print2DArray(boolean[][] image) {
        System.out.println("Printing 2DArray");
        for (boolean[] ints : image) {
            for (boolean anInt : ints) {
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

    static public void print2DArray(Piece[][] pieces) {
        System.out.println("Printing 2DArray");
        for (Piece[] ints : pieces) {
            for (Piece anInt : ints) {
                if (anInt == null) {
                    System.out.print("XX" + " ");
                } else {
                    System.out.print("" + anInt.getColor() + anInt.getType() + " ");
                }
            }
            System.out.println();
        }
    }

    static public String[][] covertPiecesToArray(Piece[][] pieces) {
        String[][] array = new String[pieces.length][pieces.length];
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces.length; j++) {
                if (pieces[i][j] == null) {
                    array[i][j] = "    ";
                } else {
                    array[i][j] = "" + pieces[i][j].getColor() + pieces[i][j].getType();
                }

            }
        }
        return array;
    }

    static public void printArray(int[] arr) {
        System.out.println("Printing Array");
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    static public void printArray(boolean[] arr) {
        System.out.println("Printing Array");
        for (boolean n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void printArray(double[] arr) {
        System.out.println("Printing Array");
        for (double n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();

    }

    static public void printArray(ArrayList<?> objectArrayList, Type type) {

        for (int i = 0; i < objectArrayList.size(); i++) {
            System.out.println((objectArrayList.get(i)));
        }
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

    static public void printArrayListInt(ArrayList<Integer> arrayList) {
//        System.out.println("Printing Long ArrayList");
        for (Integer s : arrayList) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    static public void print2DArrayListInt(List<List<Integer>> arrayList) {
//        System.out.println("Printing Long ArrayList");
        for (List<Integer> list : arrayList) {
            for (Integer s : list) {
                System.out.print(s + " ");
            }
            System.out.println();

        }
    }

    static public void printArrayListLong(ArrayList<Long> arrayList) {
//        System.out.println("Printing Long ArrayList");
        for (Long s : arrayList) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    static public void printArrayLists(ArrayList<ArrayList<Integer>> arrayLists) {
        System.out.println("Printing String ArrayLists");
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer i : arrayList) {
                System.out.print(i + " ");
            }
            System.out.println();
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
