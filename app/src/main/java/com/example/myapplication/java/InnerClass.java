package com.example.myapplication.java;


class OuterClass {
    int a;

    void display(){
        System.out.println("In outer display");
    }

    // purpose of InnerClass is only with OuterClass. then use InnerClass
    class InnerClass {
        void display2(){
            System.out.println("In non static inner display");
        }
    }

    static class InnerStaticClass {
        void display3(){
            System.out.println("In static inner display");
        }
    }
}

public class InnerClass {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.display();
        OuterClass.InnerClass innerClass = outerClass. new InnerClass(); // non static inner class
        innerClass.display2();

        OuterClass.InnerStaticClass innerStaticClass = new OuterClass.InnerStaticClass(); // static inner class
        innerStaticClass.display3();

        //anonymous class
        OuterClass outerClass2 = new OuterClass(){
            @Override
            void display() {
                System.out.println("overriding the method by anonymous class");
            }
        };
        outerClass2.display();
    }
}
