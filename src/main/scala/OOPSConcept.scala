package com.practice.scalapractice

object OOPSConcept extends App {

  class Animal{
    val age:Int = 20

    def eat(): Unit = println("I am Eating")

  }

  val animal = new Animal

  // inheritance

  class DogAnimal(val name: String) extends Animal // constructor definition

  val aDog = new DogAnimal(name = "Test")

  aDog.name

  //subtype polymorphism
  val aDeclaredAnimal: Animal = new DogAnimal("Test2")

  //abstract class

  abstract class WalkingAnimal {
    val hasLegs = true // default public

    private val privateVariable: Int = 20

    protected val protectedVaribale: Int = 10

    def walk(): Unit

  }

  // interface  = ultimate abstract class

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosper {
    def ?!(thought: String): Unit // valid method name
  }

  // single class inheritance and multi-traits "mixing"
  class Crocodile extends Animal with Carnivore with Philosper {
    override def eat(animal: Animal): Unit = println("I am eating animal")

    override def ?!(thought: String): Unit = println(s"I was thinking about $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation = object method argument (used which have one argument)
  aCroc ?! "What is this?"

  // operators in scala are actually methods
  val basicMath = 10 + 2
  val anotherBasicMath = 1.+(2)

  // anonymous classes
  val dinnsour = new Carnivore {
    override def eat(animal: Animal): Unit = println("I can eat anything")
  }

  /**
   *What you tell the compiler
   *
   * class Carnivore_Anonymous_12345 extends Carnivore {
   * override def eat(animal: Animal): Unit = println("I can eat anything")
   * }
   *
   * val dinnsour = new Carnivore_Anonymous_12345
   */

  // singleton object
  object MySingleton {
    val mySpecialValue = 100
    def mySpecialMethod():Unit = println("Test")

    def apply(x:Int) = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent to MySingleton.apply(65)

  object Animal { //companions - companion object
    // companions can access each other's private fields/methods
    //single Animal and instances of Animal are different things
    val canLiveIndefinately = false
  }

  val animalCanLiveForever = Animal.canLiveIndefinately // static fields/methods

  /**
   *
   * case classes = lightweight data structures with some boilerplate
   * - sensible equals and hash code
   * - serialization
   * - companion with apply
   * - pattern matching
   */

  case class Person(name:String, age:Int)

  // maybe constructed without "new"
  val bob = Person("bob",54)  // Person.apply("Bob",54)

  // exceptions
  try {
    val x:String =  null
    x.length
  } catch {
    case e: Exception => "some faulty error message"
  } finally {
    // execute code no matter what
  }

  // generics
  abstract class MyList[T] {
    def head: T
    def tail : MyList[T]
  }

  // using generic with a concrete type
  val aList = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head // int
  val rest = aList.tail

  val aStringList = List("hello","aman")
  val firstString = aStringList.head //string
  println(firstString)

  // Point 1: In scala we usually operate with IMMUTABLE  values/objects.
  //Any modification to an object must return ANOTHER object
  /**
   *
   * benefits:
   * 1. Work miracles in multithreaded/distributed env
   * 2. Help making sense of the code ("reasoning about")
   */
  val aReverseList = aList.reverse // return a new list

  // Point 2: Scala is closest to the Object Orientation level

}
