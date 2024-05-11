package com.example.myapplication.java;

import java.util.Arrays;

public class FinalClass {


    // a final variable
    // direct initialize
    final int THRESHOLD = 5;

    // non direct initialized variables need to be initiazed in construcor or initializer block
    // a blank final variable
    final int CAPACITY;

    // another blank final variable
    final int MINIMUM;

    // a final static variable PI
    // direct initialize
    static final double PI = 3.141592653589793;

    // a  blank final static  variable
    static final double EULERCONSTANT;

    // instance initializer block for
    // initializing CAPACITY
    {
        CAPACITY = 25;
    }

    // static initializer block for
    // initializing EULERCONSTANT
    static {
        EULERCONSTANT = 2.3;
    }

    // constructor for initializing MINIMUM
    // Note that if there are more than one
    // constructor, you must initialize MINIMUM
    // in them also
    public FinalClass() {
        MINIMUM = -1;
    }


    /**
     * When a final variable is a reference to an object, then this final variable is called the reference final variable.
     * For example, a final StringBuffer variable looks defined below as follows:
     */

    public static void main(String[] args) {
        // Creating an object of StringBuilder class
        // Final reference variable
        final StringBuilder sb = new StringBuilder("Geeks");

        // Printing the element in StringBuilder object
        System.out.println(sb);

        // changing internal state of object reference by
        //  final reference variable sb
        sb.append("ForGeeks");  // content can be changed for final object

        // Again printing the element in StringBuilder
        // object after appending above element in it
        System.out.println(sb);

        final int[] arr = {1,2,3};
        System.out.println(Arrays.toString(arr));
        arr[2] = 100;    // content can be changed for final object as array is object
        System.out.println(Arrays.toString(arr));
    }
}

