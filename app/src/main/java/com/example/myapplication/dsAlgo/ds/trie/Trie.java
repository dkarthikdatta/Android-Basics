package com.example.myapplication.dsAlgo.ds.trie;


class Node {
    /**
     * every node contains array of 26 (or any number here example for alphabets) nodes
     * if the search index node is null, create new Node (links of 26) and add that node in that index
     * doesn't not actually store any data like character x. just if links[x-'a'] is not null,
     * it means that character exists
     */
    Node[] links = new Node[26];
    boolean isLast = false;

    public Node() {

    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    boolean containsKey(char ch) {
        if (links[ch - 'a'] == null) {
            return false;
        }
        return true;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

}

public class Trie {
    static Node root = new Node();

    public static void main(String[] args) {
        insert("abcc");
        System.out.println(search("abc"));
        System.out.println(startWith("abc"));

    }


    public static void insert(String string) {
        Node node = root;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.isLast = true;
    }

    public static boolean search(String string) {
        Node node = root;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return false;
            }
        }

        if (node.isLast) {
            return true;
        }
        return false;
    }

    public static boolean startWith(String string) {
        Node node = root;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return false;
            }
        }
        return true;
    }

}
