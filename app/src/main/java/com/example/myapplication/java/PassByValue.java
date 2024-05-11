package com.example.myapplication.java;

class NormalPerson {
    String name;
    int age;

    public NormalPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class PassByValue {
    public static void main(String[] args) {
        NormalPerson person1 = new NormalPerson("Karthik", 24);
        System.out.println("Age = " + person1.age);
        increaseAge(person1);   // this does not mean that we are passing reference, we are passing the value of reference variable i.e., address
        System.out.println("Age = " + person1.age);

        int a = 1;
        System.out.println("Age of a = " + a);
        System.out.println("Age of copy when passed in method argument  = " + increaseAge(a));
        System.out.println("Age of a = " + a); // here the age of a is still 1. even though we are passing a in the method, the method copies the value of a to variable age in parameter of method. since these are primitives, the value of a is copied, not the address. hence there is no question of reference variables in primitives

        int b;
        b = a;
        b = increaseAge(b);
        System.out.println("Age of b = " + b);
        System.out.println("Age of a = " + a);  // here the age of a is still 1. even though we have made b=a in line 23. since these are primitives, the value of a is copied, not the address. hence there is no question of reference variables in primitives

    }

    private static void increaseAge(NormalPerson person1) {
        person1.age = person1.age + 1;
    }
    private static int increaseAge(int age) {
        age = age + 1;
        return age;
    }

}
