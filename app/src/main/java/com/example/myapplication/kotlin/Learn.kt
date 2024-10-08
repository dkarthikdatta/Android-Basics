package com.example.myapplication.kotlin
//
//import androidx.navigation.Navigator
//import androidx.resourceinspection.annotation.Attribute.IntMap
//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.PrimaryKey
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.EntryPoint
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.async
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//import java.util.concurrent.Flow
//import javax.inject.Named
//import javax.inject.Singleton

// constructor val var, inline, equals and ==



//
//val TAG = "KOTLIN_LEARN "
////fun main(){
//////    val maruti = Car("Maruti", "Petrol", 1000)
//////    println(TAG+maruti.name)
////////    println(TAG+maruti.kms) // cant access kms as the arguments kms in the Car constructor is not declared as val. which means its not available publicly
//////    maruti.driveCar()
//////
//////    val person = Person("Karthik", 24, )
////
//////    val onePlus = OnePlus("One Plus")
//////    onePlus.display()
////
////    MyClass.g()
////    MyClass.AnotherObject.g()
////    MyClass.MyObject.f()
////}
//
///**
// * 1.
// * constructor properties and val key word -> public and private access of properties
// */
//class Car(val name: String, val type: String, kms: Int) { // properties. primary constructor
//    fun driveCar() {
//        println(TAG+name + " car is driving")
//    }
//
//    private fun interior(){
//        println(TAG+"car Interior")
//    }
//
//}
//
///**
// * 2.
// * Primary and secondary constructors
// */
//class Person(val name: String, val age: Int, val race: String){
//    init {
//        println(TAG + name)
//    }
//
//    //secondary constructor
//    constructor(nameParam: String, ageParam: Int) : this(nameParam, ageParam, "Indian")
//}
//
///**
// * 3.
// * setters and getters
// */
//class Person1(nameArgs: String, ageArgs: Int){
//
//    var name = nameArgs
//    var age = ageArgs
//        set(value) = if (value>0) field = value else {
//            println(TAG+"Age cant be negative")
//        }
//        get() {
//            return field + 1
//        }
//
//    // in getters and setters, props are modified using field variable
//}
//
//
///**
// * 4.
// * overriding
// *
// * IMP - Every kotlin class has ANY super class. toString, hascode all are open funcs in this ANY class
// * Parent class must have open keyword if it is to be inherited
// * class, properties, functions -> all must have open key word if they gonna be inherited
// */
//
//open class Mobile(){
//    open val name: String = ""
//    val memory: Int = 2
//    open fun display() = println(TAG+" Calling from Mobile class, Display name = " + name)
//    fun memorySize() = println(TAG+" Calling from Mobile class, Memory size = " + memory)
//}
//
//class OnePlus(val specificMame: String): Mobile(){
//    override val name = specificMame
//    override fun display() {
//        println(TAG+" Calling from OnePlus class, Display name = " + name)
//    }
//}
//
///**
// * 5.21-24 https://youtu.be/9LO0c05NSek?list=PLRKyZvuMYSIMW3-rSOGCkPlO1z_IYJy3G
// * Abstract and interface
// * LiskovPrinciple -> Polymorphism
// *
// */
//
//
///**
// * 6.
// * visibility modifiers
// * public, private, internal, protected
// * by default if not specified, its public (variables or methods or class)
// *
// * internal -> public only for that module. cant be accessed in diff module
// * protected -> accessible only for children (inherited classes)
// */
//
///**
// * 7.
// * object keyword (inner class, companion object)
// * object -> singleton
// * A.num
// * B.test()
// */
//
////object declaration
//object A{
//    val num: Int = 10
//}
//
//object B{
//    val name: String = "ABC"
//    fun test() = "test abc"
//}
//
////object expression
//// anonymous objects
//
//class ObjExpression{
//    // creates a class with props and functions
//    val testObj = object {
//        val x = 10
//        public fun method(){
//            println(TAG + "I am object expression")
//        }
//    }
//}
//
//open class Person3(val name: String){
//    open fun fullName() = println("Full name = " + name)
//}
//
//interface Person4{
//    fun displayName()
//    fun actionName()
//}
//class ObjExpression1{
//    val ob2 = object : Person3("Karthik"){
//        override fun fullName() {
//            println("Full name from overridedd method = "+name)
//        }
//    }
//    val obj3 = object : Person4{
//        override fun displayName() {
//            //
//        }
//        override fun actionName() {
//            //
//        }
//
//    }
//}
//
///**
// * 8.
// * companion object
// *
// */
//
//class MyClass{
//
//
//    //only one instance of MyObject in MyClass. (Just like static but not exactly)
//    //
//    object MyObject{
//        fun f(){
//            println("Hello I am Object associated to class. like static")
//        }
//    }
//
//    // companion object same as above but can be called directly from class without object name
//    // needed to use as MyClass.f()
//    // only one companion object is allowed per class
//    // to use in Java, use as MyClass.AnotherObject.g() -> hence Just like static but not exactly. need to create object
//    // else use @JVMStatic annotation to call directly as MyClass.g()
//    companion object AnotherObject{
//        @JvmStatic
//        fun g(){
//            println("Hello I am Object associated to class. like static, can call directy by class without object name")
//        }
//    }
//}
//
///**
// * Data Class
// * equals, toString, hashCode are automatically overrided
// * to store data. automatically setters and getters
// */
////
////fun main() {
////
////    val p1 = PersonNotData(1, "Karthik")
////    val p2 = PersonNotData(1, "Karthik")
////
////    println(p1)
////    println(p2)
////    println(p1 == p2) // false -> 2 diff objects
////
////    // above are normal classes. Hence p1 and p2 prints the class name ->by super class ANY toString Method
////
////    val p3 = PersonData(1, "Karthik")
////    val p4 = PersonData(1, "Karthik")
////    println(p3)
////    println(p4) // prints the data
////    println(p3 == p4) // true -> isEquals and == are overrided to check contents
////
////    // above are data classes..
////
////    val p5 = p3.copy(id=2) // copy method. override data if required
////    println(p5)
////    // destructuring of data class
////    val (id1, name1) = p3
////    println("id = " + id1 + " name = " + name1)
////
////}
//
//class PersonNotData(val id: Int, val name: String){
//}
//data class PersonData(
//    val id: Int,
//    val name: String
//)
//
///**
// * enum and sealed
// * enum -> only particular value from set of available data
// */
//
////fun main(){
////    val day = Day.WEDNESDAY
////    println(day)
////
////    // to define constructor param assosciated to each value
////    val dayCons = DayCons.THURSDAY
////    println(dayCons.name)
////    println(dayCons.num)
////
////    for(i in DayCons.values()){
////        println(i)
////    }
////
////    day.printDay()
////}
//
//enum class Day{
//    MONDAY,
//    TUESDAY,
//    WEDNESDAY,
//    THURSDAY,
//    FRIDAY,
//    SATURDAY,
//    SUNDAY;
//    fun printDay(){
//        println("Day is $this") // referenced to current enum value
//    }
//}
//
//enum class DayCons(val num: Int){
//    MONDAY(1),
//    TUESDAY(2),
//    WEDNESDAY(3),
//    THURSDAY(4),
//    FRIDAY(5),
//    SATURDAY(6),
//    SUNDAY(7)
//}
//
//
///**
// * sealed class
// * enum -> restricting the values
// * sealed classes -> restricting the types
// *
// * ex: tiles -> color types. but actual tiles are many with categorized into color types
// * Red -> Mushroom, strawberry
// * Blue -> Onion, Chilli
// */
//
//sealed class Tile
//class Red(val type: String, val points: Int): Tile()
//class Blue(val points: Int): Tile()
//
////fun main() {
////    val tile1: Tile = Red("Mushroom", 20)
////    val tile2 = Red("Strawberry", 30)
////    println("${tile2.type} - ${tile2.points}")
////
////    //usecase -> muliply 2 if red, 5 if bluw
////
////    val points = when(tile1){
////        is Red -> tile1.points *2
////        is Blue -> tile1.points *5
////    }
////    println(points)
////}
//
///**
// * mutable list vs immutable lis
// * by default list is immutable
// */
////fun main() {
////    val nums = listOf(1,2,3,4) //immutable
//////    nums[2] = 400 //not possible
////    val nums2 = mutableListOf(1,2,3,4,5)
////    nums2[4] = 400 // possiblr
////    println(nums2[4])
////    nums2.removeAt(0)
////    nums2.add(0, 200)
////    println(nums2)
////}
//
///**
// * Maps
// * mutable and immutable maps
// */
//
////fun main() {
////    val students = mutableMapOf<Int, String>()
////    students.put(1, "Karthik")
////    println(students[1])
////}
//
///**
// * Lambda functions
// * Higher order functions
// */
//
//// lambda functions variable f is called lambda
////fun main() {
////
////    var f: (a: Double, b: Double) -> Double = ::sum  //assigning functions to variable as object
////    println(f(2.0, 3.0))
////}
////fun sum(a: Double, b: Double): Double{
////    return a+b
////}
//
//// higher order function -> fn that accepts n as argument or return fn oor both
//
////fun main() {
////    println(calculator(3.0,2.0, ::sum))
////}
////fun sum(a: Double, b: Double): Double{
////    return a+b
////}
////
////fun calculator(a: Double, b: Double, gn: (Double, Double) -> Double) : Double{
////    var result = gn(a,b)
////    return result
////}
//
//
//// lambda expression -> single line functions
////fun main() {
////    val lambda1 = {x: Int, y: Int -> x+y}
////
////    val multiLineLambda = {
////        println("Hello Lambda")
////        val a = 2
////        "hellooo"
////    }
////    multiLineLambda()
////
////    val singleParamLambda = {x: Int -> x*x}
////    val singleParamLambda2: (Int) -> Int = {x-> x*x}
////}
////
////fun sum(a: Double, b: Double): Double{
////    return a+b
////}
//
//
///**
// * extension functions
// * extending / adding functions to class.
// * used to add additional functions to a particular class ex: String.formatCustom
// */
//
////fun main() {
////
////    val myStr = "Hello"
////    println(myStr.formatCustom())
////}
////
////fun String.formatCustom(): String{
////    return "Custom format " + this
////}
//
///**
// * inline functions
// * todo: check this
// */
//
//
///**
// * Scope functions
// *
// */
//
//
////fun main() {
////    val emp: Employee? = Employee()
////    emp?.name = "John"
////    emp?.age = 22
////
////    /**
////     * apply
////     * this -> object context
////     * returns the same object
////     */
////    val obj : Employee? = emp?.apply {
////        name = "John Modified"
////        age = 23
////        println(this)
////    }
////
////    /**
////     * let
////     * nullable check. runs only if non null object is availeble
////     * it -> object context
////     * returns the last line
////     */
////
////    val letLastLine = emp?.let {
////        println(it.name)
////        println(it.age)
////        "Returns Last line"
////    }
////
////    println(letLastLine)
////
////
////    /**
////     * with
////     * this -> object context
////     * returns last line
////     */
////    val emp2: Employee = Employee()
////    emp2.name = "Ram"
////    emp2.age = 5
////
////    val withLastLine = with(emp2){
////        name = "Rama"
////        println(age)
////        "Retuns with last line"
////    }
////    println(withLastLine)
////
////    /**
////     *
////     */
////
////    val runLastLine =  emp2.run {
////        age = 35
////        name = "Hello"
////        "Returns last line of run"
////    }
////
////    println(runLastLine)
////
////}
////
////fun main() {
////    val input = mutableListOf(
////        mutableListOf("ADD", "2"),
////        mutableListOf("ADD", "3"),
////        mutableListOf("ADD", "9"),
////        mutableListOf("REMOVE", "10"),
////        mutableListOf("REMOVE", "5"),
////        mutableListOf("REMOVE", "5"),
////        mutableListOf("REMOVE", "9"),
////        mutableListOf("REMOVE", "2"),
////        mutableListOf("REMOVE", "2"),
////        mutableListOf("REMOVE", "9"),
////        mutableListOf("EXISTS", "10"),
////        mutableListOf("EXISTS", "2"),
////        mutableListOf("EXISTS", "3"),
////        mutableListOf("EXISTS", "9"),
////        mutableListOf("ADD", "10"),
////        mutableListOf("EXISTS", "10")
////    )
////    println( solution(input))
////}
//
//fun solution(queries: MutableList<MutableList<String>>): MutableList<String> {
//    var ans: MutableList<String> = mutableListOf()
//    var hm: HashMap<String, Int> = hashMapOf()
//    for(i in 0 .. queries.size-1){
//        if(queries[i][0] == "ADD"){
//            if(hm.containsKey(queries[i][1])){
//                hm.put(queries[i][1], hm.get(queries[i][1])?.plus(1)?: 0 )
//            } else {
//                hm.put(queries[i][1], 1)
//            }
//            ans.add("")
//        } else if(queries[i][0] == "EXISTS"){
//            if(hm.containsKey(queries[i][1])){
//                hm.get(queries[i][1])?.let { it->
//                    if(it > 0){
//                        ans.add("true")
//                    } else {
//                        ans.add("false")
//                    }
//                } ?: ans.add("false")
//            } else {
//                ans.add("false")
//            }
//        } else if(queries[i][0] == "REMOVE"){
//            if(hm.containsKey(queries[i][1])){
//                hm.get(queries[i][1])?.let { it->
//                    if(it>0){
//                        hm.put(queries[i][1], it-1 )
//                        ans.add("true")
//                    } else {
//                        ans.add("false")
//                    }
//                }
//            }
//        }
//    }
//    return ans
//}
//
//
//fun main() {
//    val arr: Array<Int> = Array(3) {0}
////    println(arr.size)
//
//    val prices: IntArray = intArrayOf(7,1,5,3,6,4)
//
////    for (i in 0 .. prices.size-1){
////        println(prices[i])
////    }
//
//    val string: String = "Hello".lowercase().filter { it.isWhitespace() }.filter { it.isLetterOrDigit() }
//    string.length
//    println( maxProfit(prices))
//}
//
//fun maxProfit(prices: IntArray): Int {
//    val arr1: Array<Int> = Array(prices.size) {0}
//    val arr2: Array<Int> = Array(prices.size) {0}
//    var max: Int = Integer.MIN_VALUE
//    var min: Int = Integer.MAX_VALUE
//    var ans: Int = 0
//    for(i in 0 .. prices.size-1){
//        min = Math.min(min, prices[i])
//        arr1[i] = min;
//    }
//    for (i in 0 .. prices.size-1){
//        print(arr1[i])
//    }
//    println()
//    for(i in prices.size-1 downTo 0){
//        max = Math.max(max, prices[i])
//        arr2[i] = max;
//    }
//    for (i in 0 .. prices.size-1){
//        print(arr2[i])
//    }
//    println()
//    for(i in 0 .. prices.size-1){
//        ans = Math.max(ans, arr2[i]-arr1[i])
//    }
//
//    return ans
//}
//data class Employee(var name: String = "", var age: Int = 19)
//
//
//val producer: Flow<Int> = flow {
//    repeat(5){
//        emit(it)
//        kotlinx.coroutines.delay(100)
//    }
//}
//
//val job1 = GlobalScope.launch {
//    producer.collect{
//
//    }
//}
//h
//
//val job2 = GlobalScope.launch {
//    producer.collect{
//
//    }
//}
//
//
//val job = CoroutineScope(Dispatchers.IO).launch {
//    val result = async { fetchDatafromNetwork() }
//        withContext(Dispatchers.Main){
//            updateUI(result.await())
//        }
//}
//fun main() {package com.example.myapplication.kotlin
////
////import androidx.navigation.Navigator
////import androidx.resourceinspection.annotation.Attribute.IntMap
////import androidx.room.ColumnInfo
////import androidx.room.Entity
////import androidx.room.PrimaryKey
////import dagger.Module
////import dagger.Provides
////import dagger.hilt.EntryPoint
////import dagger.hilt.InstallIn
////import dagger.hilt.components.SingletonComponent
////import kotlinx.coroutines.CoroutineScope
////import kotlinx.coroutines.Dispatchers
////import kotlinx.coroutines.GlobalScope
////import kotlinx.coroutines.async
////import kotlinx.coroutines.delay
////import kotlinx.coroutines.flow.flow
////import kotlinx.coroutines.launch
////import kotlinx.coroutines.withContext
////import java.util.concurrent.Flow
////import javax.inject.Named
////import javax.inject.Singleton
////
////val TAG = "KOTLIN_LEARN "
//////fun main(){
////////    val maruti = Car("Maruti", "Petrol", 1000)
////////    println(TAG+maruti.name)
//////////    println(TAG+maruti.kms) // cant access kms as the arguments kms in the Car constructor is not declared as val. which means its not available publicly
////////    maruti.driveCar()
////////
////////    val person = Person("Karthik", 24, )
//////
////////    val onePlus = OnePlus("One Plus")
////////    onePlus.display()
//////
//////    MyClass.g()
//////    MyClass.AnotherObject.g()
//////    MyClass.MyObject.f()
//////}
////
/////**
//// * 1.
//// * constructor properties and val key word -> public and private access of properties
//// */
////class Car(val name: String, val type: String, kms: Int) { // properties. primary constructor
////    fun driveCar() {
////        println(TAG+name + " car is driving")
////    }
////
////    private fun interior(){
////        println(TAG+"car Interior")
////    }
////
////}
////
/////**
//// * 2.
//// * Primary and secondary constructors
//// */
////class Person(val name: String, val age: Int, val race: String){
////    init {
////        println(TAG + name)
////    }
////
////    //secondary constructor
////    constructor(nameParam: String, ageParam: Int) : this(nameParam, ageParam, "Indian")
////}
////
/////**
//// * 3.
//// * setters and getters
//// */
////class Person1(nameArgs: String, ageArgs: Int){
////
////    var name = nameArgs
////    var age = ageArgs
////        set(value) = if (value>0) field = value else {
////            println(TAG+"Age cant be negative")
////        }
////        get() {
////            return field + 1
////        }
////
////    // in getters and setters, props are modified using field variable
////}
////
////
/////**
//// * 4.
//// * overriding
//// *
//// * IMP - Every kotlin class has ANY super class. toString, hascode all are open funcs in this ANY class
//// * Parent class must have open keyword if it is to be inherited
//// * class, properties, functions -> all must have open key word if they gonna be inherited
//// */
////
////open class Mobile(){
////    open val name: String = ""
////    val memory: Int = 2
////    open fun display() = println(TAG+" Calling from Mobile class, Display name = " + name)
////    fun memorySize() = println(TAG+" Calling from Mobile class, Memory size = " + memory)
////}
////
////class OnePlus(val specificMame: String): Mobile(){
////    override val name = specificMame
////    override fun display() {
////        println(TAG+" Calling from OnePlus class, Display name = " + name)
////    }
////}
////
/////**
//// * 5.21-24 https://youtu.be/9LO0c05NSek?list=PLRKyZvuMYSIMW3-rSOGCkPlO1z_IYJy3G
//// * Abstract and interface
//// * LiskovPrinciple -> Polymorphism
//// *
//// */
////
////
/////**
//// * 6.
//// * visibility modifiers
//// * public, private, internal, protected
//// * by default if not specified, its public (variables or methods or class)
//// *
//// * internal -> public only for that module. cant be accessed in diff module
//// * protected -> accessible only for children (inherited classes)
//// */
////
/////**
//// * 7.
//// * object keyword (inner class, companion object)
//// * object -> singleton
//// * A.num
//// * B.test()
//// */
////
//////object declaration
////object A{
////    val num: Int = 10
////}
////
////object B{
////    val name: String = "ABC"
////    fun test() = "test abc"
////}
////
//////object expression
////// anonymous objects
////
////class ObjExpression{
////    // creates a class with props and functions
////    val testObj = object {
////        val x = 10
////        public fun method(){
////            println(TAG + "I am object expression")
////        }
////    }
////}
////
////open class Person3(val name: String){
////    open fun fullName() = println("Full name = " + name)
////}
////
////interface Person4{
////    fun displayName()
////    fun actionName()
////}
////class ObjExpression1{
////    val ob2 = object : Person3("Karthik"){
////        override fun fullName() {
////            println("Full name from overridedd method = "+name)
////        }
////    }
////    val obj3 = object : Person4{
////        override fun displayName() {
////            //
////        }
////        override fun actionName() {
////            //
////        }
////
////    }
////}
////
/////**
//// * 8.
//// * companion object
//// *
//// */
////
////class MyClass{
////
////
////    //only one instance of MyObject in MyClass. (Just like static but not exactly)
////    //
////    object MyObject{
////        fun f(){
////            println("Hello I am Object associated to class. like static")
////        }
////    }
////
////    // companion object same as above but can be called directly from class without object name
////    // needed to use as MyClass.f()
////    // only one companion object is allowed per class
////    // to use in Java, use as MyClass.AnotherObject.g() -> hence Just like static but not exactly. need to create object
////    // else use @JVMStatic annotation to call directly as MyClass.g()
////    companion object AnotherObject{
////        @JvmStatic
////        fun g(){
////            println("Hello I am Object associated to class. like static, can call directy by class without object name")
////        }
////    }
////}
////
/////**
//// * Data Class
//// * equals, toString, hashCode are automatically overrided
//// * to store data. automatically setters and getters
//// */
//////
//////fun main() {
//////
//////    val p1 = PersonNotData(1, "Karthik")
//////    val p2 = PersonNotData(1, "Karthik")
//////
//////    println(p1)
//////    println(p2)
//////    println(p1 == p2) // false -> 2 diff objects
//////
//////    // above are normal classes. Hence p1 and p2 prints the class name ->by super class ANY toString Method
//////
//////    val p3 = PersonData(1, "Karthik")
//////    val p4 = PersonData(1, "Karthik")
//////    println(p3)
//////    println(p4) // prints the data
//////    println(p3 == p4) // true -> isEquals and == are overrided to check contents
//////
//////    // above are data classes..
//////
//////    val p5 = p3.copy(id=2) // copy method. override data if required
//////    println(p5)
//////    // destructuring of data class
//////    val (id1, name1) = p3
//////    println("id = " + id1 + " name = " + name1)
//////
//////}
////
////class PersonNotData(val id: Int, val name: String){
////}
////data class PersonData(
////    val id: Int,
////    val name: String
////)
////
/////**
//// * enum and sealed
//// * enum -> only particular value from set of available data
//// */
////
//////fun main(){
//////    val day = Day.WEDNESDAY
//////    println(day)
//////
//////    // to define constructor param assosciated to each value
//////    val dayCons = DayCons.THURSDAY
//////    println(dayCons.name)
//////    println(dayCons.num)
//////
//////    for(i in DayCons.values()){
//////        println(i)
//////    }
//////
//////    day.printDay()
//////}
////
////enum class Day{
////    MONDAY,
////    TUESDAY,
////    WEDNESDAY,
////    THURSDAY,
////    FRIDAY,
////    SATURDAY,
////    SUNDAY;
////    fun printDay(){
////        println("Day is $this") // referenced to current enum value
////    }
////}
////
////enum class DayCons(val num: Int){
////    MONDAY(1),
////    TUESDAY(2),
////    WEDNESDAY(3),
////    THURSDAY(4),
////    FRIDAY(5),
////    SATURDAY(6),
////    SUNDAY(7)
////}
////
////
/////**
//// * sealed class
//// * enum -> restricting the values
//// * sealed classes -> restricting the types
//// *
//// * ex: tiles -> color types. but actual tiles are many with categorized into color types
//// * Red -> Mushroom, strawberry
//// * Blue -> Onion, Chilli
//// */
////
////sealed class Tile
////class Red(val type: String, val points: Int): Tile()
////class Blue(val points: Int): Tile()
////
//////fun main() {
//////    val tile1: Tile = Red("Mushroom", 20)
//////    val tile2 = Red("Strawberry", 30)
//////    println("${tile2.type} - ${tile2.points}")
//////
//////    //usecase -> muliply 2 if red, 5 if bluw
//////
//////    val points = when(tile1){
//////        is Red -> tile1.points *2
//////        is Blue -> tile1.points *5
//////    }
//////    println(points)
//////}
////
/////**
//// * mutable list vs immutable lis
//// * by default list is immutable
//// */
//////fun main() {
//////    val nums = listOf(1,2,3,4) //immutable
////////    nums[2] = 400 //not possible
//////    val nums2 = mutableListOf(1,2,3,4,5)
//////    nums2[4] = 400 // possiblr
//////    println(nums2[4])
//////    nums2.removeAt(0)
//////    nums2.add(0, 200)
//////    println(nums2)
//////}
////
/////**
//// * Maps
//// * mutable and immutable maps
//// */
////
//////fun main() {
//////    val students = mutableMapOf<Int, String>()
//////    students.put(1, "Karthik")
//////    println(students[1])
//////}
////
/////**
//// * Lambda functions
//// * Higher order functions
//// */
////
////// lambda functions variable f is called lambda
//////fun main() {
//////
//////    var f: (a: Double, b: Double) -> Double = ::sum  //assigning functions to variable as object
//////    println(f(2.0, 3.0))
//////}
//////fun sum(a: Double, b: Double): Double{
//////    return a+b
//////}
////
////// higher order function -> fn that accepts n as argument or return fn oor both
////
//////fun main() {
//////    println(calculator(3.0,2.0, ::sum))
//////}
//////fun sum(a: Double, b: Double): Double{
//////    return a+b
//////}
//////
//////fun calculator(a: Double, b: Double, gn: (Double, Double) -> Double) : Double{
//////    var result = gn(a,b)
//////    return result
//////}
////
////
////// lambda expression -> single line functions
//////fun main() {
//////    val lambda1 = {x: Int, y: Int -> x+y}
//////
//////    val multiLineLambda = {
//////        println("Hello Lambda")
//////        val a = 2
//////        "hellooo"
//////    }
//////    multiLineLambda()
//////
//////    val singleParamLambda = {x: Int -> x*x}
//////    val singleParamLambda2: (Int) -> Int = {x-> x*x}
//////}
//////
//////fun sum(a: Double, b: Double): Double{
//////    return a+b
//////}
////
////
/////**
//// * extension functions
//// * extending / adding functions to class.
//// * used to add additional functions to a particular class ex: String.formatCustom
//// */
////
//////fun main() {
//////
//////    val myStr = "Hello"
//////    println(myStr.formatCustom())
//////}
//////
//////fun String.formatCustom(): String{
//////    return "Custom format " + this
//////}
////
/////**
//// * inline functions
//// * todo: check this
//// */
////
////
/////**
//// * Scope functions
//// *
//// */
////
////
//////fun main() {
//////    val emp: Employee? = Employee()
//////    emp?.name = "John"
//////    emp?.age = 22
//////
//////    /**
//////     * apply
//////     * this -> object context
//////     * returns the same object
//////     */
//////    val obj : Employee? = emp?.apply {
//////        name = "John Modified"
//////        age = 23
//////        println(this)
//////    }
//////
//////    /**
//////     * let
//////     * nullable check. runs only if non null object is availeble
//////     * it -> object context
//////     * returns the last line
//////     */
//////
//////    val letLastLine = emp?.let {
//////        println(it.name)
//////        println(it.age)
//////        "Returns Last line"
//////    }
//////
//////    println(letLastLine)
//////
//////
//////    /**
//////     * with
//////     * this -> object context
//////     * returns last line
//////     */
//////    val emp2: Employee = Employee()
//////    emp2.name = "Ram"
//////    emp2.age = 5
//////
//////    val withLastLine = with(emp2){
//////        name = "Rama"
//////        println(age)
//////        "Retuns with last line"
//////    }
//////    println(withLastLine)
//////
//////    /**
//////     *
//////     */
//////
//////    val runLastLine =  emp2.run {
//////        age = 35
//////        name = "Hello"
//////        "Returns last line of run"
//////    }
//////
//////    println(runLastLine)
//////
//////}
//////
//////fun main() {
//////    val input = mutableListOf(
//////        mutableListOf("ADD", "2"),
//////        mutableListOf("ADD", "3"),
//////        mutableListOf("ADD", "9"),
//////        mutableListOf("REMOVE", "10"),
//////        mutableListOf("REMOVE", "5"),
//////        mutableListOf("REMOVE", "5"),
//////        mutableListOf("REMOVE", "9"),
//////        mutableListOf("REMOVE", "2"),
//////        mutableListOf("REMOVE", "2"),
//////        mutableListOf("REMOVE", "9"),
//////        mutableListOf("EXISTS", "10"),
//////        mutableListOf("EXISTS", "2"),
//////        mutableListOf("EXISTS", "3"),
//////        mutableListOf("EXISTS", "9"),
//////        mutableListOf("ADD", "10"),
//////        mutableListOf("EXISTS", "10")
//////    )
//////    println( solution(input))
//////}
////
////fun solution(queries: MutableList<MutableList<String>>): MutableList<String> {
////    var ans: MutableList<String> = mutableListOf()
////    var hm: HashMap<String, Int> = hashMapOf()
////    for(i in 0 .. queries.size-1){
////        if(queries[i][0] == "ADD"){
////            if(hm.containsKey(queries[i][1])){
////                hm.put(queries[i][1], hm.get(queries[i][1])?.plus(1)?: 0 )
////            } else {
////                hm.put(queries[i][1], 1)
////            }
////            ans.add("")
////        } else if(queries[i][0] == "EXISTS"){
////            if(hm.containsKey(queries[i][1])){
////                hm.get(queries[i][1])?.let { it->
////                    if(it > 0){
////                        ans.add("true")
////                    } else {
////                        ans.add("false")
////                    }
////                } ?: ans.add("false")
////            } else {
////                ans.add("false")
////            }
////        } else if(queries[i][0] == "REMOVE"){
////            if(hm.containsKey(queries[i][1])){
////                hm.get(queries[i][1])?.let { it->
////                    if(it>0){
////                        hm.put(queries[i][1], it-1 )
////                        ans.add("true")
////                    } else {
////                        ans.add("false")
////                    }
////                }
////            }
////        }
////    }
////    return ans
////}
////
////
////fun main() {
////    val arr: Array<Int> = Array(3) {0}
//////    println(arr.size)
////
////    val prices: IntArray = intArrayOf(7,1,5,3,6,4)
////
//////    for (i in 0 .. prices.size-1){
//////        println(prices[i])
//////    }
////
////    val string: String = "Hello".lowercase().filter { it.isWhitespace() }.filter { it.isLetterOrDigit() }
////    string.length
////    println( maxProfit(prices))
////}
////
////fun maxProfit(prices: IntArray): Int {
////    val arr1: Array<Int> = Array(prices.size) {0}
////    val arr2: Array<Int> = Array(prices.size) {0}
////    var max: Int = Integer.MIN_VALUE
////    var min: Int = Integer.MAX_VALUE
////    var ans: Int = 0
////    for(i in 0 .. prices.size-1){
////        min = Math.min(min, prices[i])
////        arr1[i] = min;
////    }
////    for (i in 0 .. prices.size-1){
////        print(arr1[i])
////    }
////    println()
////    for(i in prices.size-1 downTo 0){
////        max = Math.max(max, prices[i])
////        arr2[i] = max;
////    }
////    for (i in 0 .. prices.size-1){
////        print(arr2[i])
////    }
////    println()
////    for(i in 0 .. prices.size-1){
////        ans = Math.max(ans, arr2[i]-arr1[i])
////    }
////
////    return ans
////}
////data class Employee(var name: String = "", var age: Int = 19)
////
////
////val producer: Flow<Int> = flow {
////    repeat(5){
////        emit(it)
////        kotlinx.coroutines.delay(100)
////    }
////}
////
////val job1 = GlobalScope.launch {
////    producer.collect{
////
////    }
////}
////h
////
////val job2 = GlobalScope.launch {
////    producer.collect{
////
////    }
////}
////
////
////val job = CoroutineScope(Dispatchers.IO).launch {
////    val result = async { fetchDatafromNetwork() }
////        withContext(Dispatchers.Main){
////            updateUI(result.await())
////        }
////}
////fun main() {
////    val parentJob = CoroutineScope(Dispatchers.Default).launch {
////        val childJob1 = launch {
////
////        }
////
////        val childJob2 = launch {
////
////        }
////
////        delay(1000)
////    }
////
////    parentJob.join()
////}
////
////
////@EntryPoint
////@InstallIn(SingletonComponent::class)
////interface MyEntryPoint{
////    fun getMydependency(): Mydependency
////}
////
////
////@Module
////object MyModule{
////    @Provides
////    @Named("A")
////    fun provideDependencyA(): SomeDependency{
////        return SomeDependencyA()
////    }
////
////    @Provides
////    @Named("B")
////    fun provideDependencyB(): SomeDependency{
////        return SomeDependencyB()
////    }
////
////}
////
////@Entity(tableName = "db_user")
////data class User(
////    @PrimaryKey(autoGenerate = true)
////    @ColumnInfo(name = "id")
////    val id :Int,
////
////    @ColumnInfo(name = "_id")
////    val _id :Int,
////
////    @ColumnInfo(name = "name")
////    val name :String,
////
////    @ColumnInfo(name = "email")
////    val email :String
////
////    )
//    val parentJob = CoroutineScope(Dispatchers.Default).launch {
//        val childJob1 = launch {
//
//        }
//
//        val childJob2 = launch {
//
//        }
//
//        delay(1000)
//    }
//
//    parentJob.join()
//}
//
//
//@EntryPoint
//@InstallIn(SingletonComponent::class)
//interface MyEntryPoint{
//    fun getMydependency(): Mydependency
//}
//
//
//@Module
//object MyModule{
//    @Provides
//    @Named("A")
//    fun provideDependencyA(): SomeDependency{
//        return SomeDependencyA()
//    }
//
//    @Provides
//    @Named("B")
//    fun provideDependencyB(): SomeDependency{
//        return SomeDependencyB()
//    }
//
//}
//
//@Entity(tableName = "db_user")
//data class User(
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id")
//    val id :Int,
//
//    @ColumnInfo(name = "_id")
//    val _id :Int,
//
//    @ColumnInfo(name = "name")
//    val name :String,
//
//    @ColumnInfo(name = "email")
//    val email :String
//
//    )