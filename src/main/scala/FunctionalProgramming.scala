package com.practice.scalapractice

object FunctionalProgramming extends App {

  // Scala is a Object oriented language
  class Person(name:String) {
    def apply(age:Int): Unit = println(s"My age is $age")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // invoking  bob as a functional === bob.apply(43)

  /**
   * Scala runs on the JVM
   * Functional Programming:
   *  - compose function
   *  - pass function as args
   *  - return function as results
   *
   *  Conclusion: FunctionX = Function1,Function2,...................,Function22
   *
   */

  val incrementor = new Function[Int,Int] {
    override def apply(v1: Int): Int = v1 + 1
  }
  incrementor.apply(23)  //24
  incrementor(23)  //24
  // defined a function !

  //All Scala functions are instances of these FUNCTIONS_X Types

  //Function with 2 arguments and String return type
  val stringConcator = new Function2[String,String,String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  stringConcator.apply("A","B")  //AB
  stringConcator("A","B")  //AB


  // Syntax Sugars
  val doubler:Function1[Int,Int] = (x:Int) => 2*x
  doubler(4) // 8

  /**
   * Equivalent to much longer
   * new Function[Int,Int] {
   *  override def apply(v1: Int): Int = 2*v1
   * }
   *
   */

  val double: Int => Int = (x:Int) => 2*x

  /**
   * Equivalent to much longer
   *
   * val doubler:Function1[Int,Int] = (x:Int) => 2*x
   *
   */


  // Higher Order Functions: take function as argument/return functions as result
  val aMappedList = List(1,2,3).map(X => X+1)
  // map() higher order function
  println(aMappedList)

  val aFlatMappedList = List(1,2,3).flatMap(x => List(x, 2*x))
  println(aFlatMappedList)

  val aFilteredList = List(1,2,3,5,6,4).filter(x => x <= 3)
  val aFilteredList2 = List(1,2,3,5,6,4).filter(_ <= 3) // equivalent to x => x <= 3
  println(aFilteredList)
  println(aFilteredList2)

  // all the pairs between the number 1,2,3 and the letters 'a','b','c'
  val aResult = List(1,2,3).flatMap(x => List('a','b','c').map(str => s"$x $str"))
  println(aResult)

}
