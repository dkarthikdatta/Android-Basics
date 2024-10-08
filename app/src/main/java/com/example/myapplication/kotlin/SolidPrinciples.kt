package com.example.myapplication.kotlin


class SolidPrinciples {

    // 1. Single Responsibility Principle


    // 2. Open-Close Principle

    // 3. Liskov Substitution Principle
    // Subclasses can be used in place of their superclasses without affecting the program's behavior.


    // bad example - ostrich cant fly. If we are using Bird in some of my code, if i want to replace it with Ostrich, it fails because in Ostrich, fly method would be overrided with no definition
    open class Bird {
        open fun fly() {}
    }
    class Duck : Bird()
    class Ostrich : Bird()


    // good example - if we are using MyBird, MyOstrich can be replaced inplace of MyBird. same with MyFlyingBird and MyDuck
    open class MyBird{
    }
    open class MyFlyingBird : MyBird() {
        fun fly() {}
    }
    class MyDuck : MyFlyingBird()
    class MyOstrich : MyBird()

    // 4. Interface segregation - there should not be do nothing functions when implementing interface. Just use smaller / separate interfaces

    // 5. Dependency Inversion - sending the objects as dependency rather than creating inside class

}
