package com.example.myapplication.test;

import java.util.Stack;

class Decode {
    public static void main(String[] args) {
        System.out.println(decodedString("3[b2[ca]]"));
    }
    static String decodedString(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']') {
                st.push(c);
            } else {
                System.out.println("Start of else");
                printStack(st);
                StringBuilder sb = new StringBuilder();
                while (st.size() != 0 && st.peek() != '[') {
                    sb.append(st.pop());
                }
                sb.toString();
//                System.out.println(sb);
                if (st.size() != 0 && st.peek() == '[') {
                    st.pop();
                }
                System.out.println("after [");

                int count = 0;
                int multiplier = 1;

                while (st.size() != 0 && Character.isDigit(st.peek())) {
                    count = count + (multiplier * (st.pop() - '0'));
                    multiplier = multiplier * 10;
                }

                System.out.println("count: " + count);
                while (count > 0) {
                    for (int j = sb.length()-1; j >=0; j--) {
                        st.push(sb.charAt(j));
                    }
                    count--;
                }
                System.out.println("End of else");
                printStack(st);
            }
        }
        int size = st.size();
        char[] charArray = new char[size];

        while(st.size()!=0){
            charArray[size-1] = st.pop();
            size--;
        }
        return String.valueOf(charArray);
    }

    static private void printStack(Stack<Character> stack){
        Stack<Character> newStack = new Stack<>();
        newStack.addAll(stack);
        while (newStack.size()!=0){
            System.out.print(newStack.pop()+" ");
        }
        System.out.println();
    }
}