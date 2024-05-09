package com.example.myapplication.java;


import androidx.annotation.Nullable;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class SuperPerson {
    String name;
    int age;

    public SuperPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        SuperPerson anotherPerson = (SuperPerson) obj;
        if (anotherPerson != null && anotherPerson.name.equals(this.name) && anotherPerson.age == this.age) {
            return true;
        }
        return super.equals(obj);
    }
}

public class Equals {
    public static void main(String[] args) {
        Person karthik = new Person("Karthik", 24);
        Person karthik2 = new Person("Karthik", 24);

        System.out.println(karthik == karthik2); // false since == compares the object address
        System.out.println(karthik.equals(karthik2)); // false since we haven't override equals method. By default, equals method compares object address same as ==

        String karString = new String("Karthik");
        String karString2 = new String("Karthik");

        System.out.println(karString == karString2); // false since we are directly comparing the addresses of karString and karString2
        System.out.println(karString.equals(karString2)); // true since String class by default overrides equals method to check the content

        SuperPerson superKarthik = new SuperPerson("Karthik", 24);
        SuperPerson superKarthik2 = new SuperPerson("Karthik", 24);
        System.out.println(superKarthik == superKarthik2); // false since == is address comparison. nothing to do with content
        System.out.println(superKarthik.equals(superKarthik2)); // true since we have override equals to check the content

        String kar = "Karthik";
        String kar2 = "Karthik";
        System.out.println(kar == kar2); // true since new objects are not created. just string literals. Java maintains a "string pool". If the content of the string is the same as an existing string literal in the pool, Java will refer to the same object in memory rather than creating a new one.
        System.out.println(kar.equals(kar2)); // true. no explanation needed
    }

}
