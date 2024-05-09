package com.example.myapplication.dsAlgo.ds.Stacks;

import com.example.myapplication.dsAlgo.Pair;
import com.example.myapplication.dsAlgo.Utility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackSums {
    public static void main(String[] args) {
//        String parenthisis = "[()]{}{[()()]()}";
//        String parenthisis = "[(])";
//        String parenthisis = "(";
//        parenthesisChecker(parenthisis);


//        long[] nextGreaterArray = {6, 8, 0, 1, 3};
//        long[] nextGreaterArray = {1, 3, 2, 4};
//        nextGreaterElement(nextGreaterArray);
    }

    /**
     * <a href="https://www.geeksforgeeks.org/problems/parenthesis-checker2744/1">Parenthesis Checker</a>
     * Parenthesis Checker
     *
     * @param s
     */

    private static void parenthesisChecker(String s) {
        Stack<Character> stack = new Stack<>();
        boolean isValid = true;

        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                stack.add(c);
            } else {
                if (stack.size() == 0) {
                    isValid = false;
                    break;
                }
                char pop = stack.pop();
                if ((c == ']' && pop == '[') || (c == ')' && pop == '(') || (c == '}' && pop == '{')) {
                    continue;
                } else {
                    isValid = false;
                    break;
                }
            }
        }

        System.out.println("is Valid Parenthesis: " + (stack.size() == 0 ? isValid : false));

    }

    /**
     * https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
     *
     * @param arr
     */
    private static void nextGreaterElement(long[] arr) {
        // iterate from end. if stack is empty, -1.
        // else, if curr is < st.peek(), ans = st.peek(), add(curr).
        // else, while(curr>st.peek()) st.pop. if st.size == 0, -1 else st.peek

        Stack<Long> stack = new Stack<>();
        long[] ans = new long[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                if (arr[i] <= stack.peek()) {
                    ans[i] = stack.peek();
                } else {
                    while (stack.size() != 0 && arr[i] > stack.peek()) {
                        stack.pop();
                    }
                    if (stack.size() == 0) {
                        ans[i] = -1;
                    } else {
                        ans[i] = stack.peek();
                    }
                }
            }
            stack.add(arr[i]);
        }
        System.out.println("Next greater element = " + Arrays.toString(ans));
    }
}


