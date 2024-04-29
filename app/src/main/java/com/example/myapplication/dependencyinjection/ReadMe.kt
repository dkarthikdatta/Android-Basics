package com.example.myapplication.dependencyinjection


/**
 * constructor injection
 * field injection
 *
 * Dagger2 -> compile time dependency injection framework
 * annotation based
 *
 * consumer -> @inject
 * producer -> @Module, @Provides, @Binds
 * connector -> @Component
 */
class ReadMe {
    public lateinit var engine: Engine // field injection
}

class Engine(){

}