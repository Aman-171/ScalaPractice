package com.practice.scalapractice

object Basic extends App {
  // Defining a value
  val aMeaning: Int = 42 //work as const

  val aBoolean = false // type of optional

  // Types of DataType:
  /*
  * 1. Int
  * 2. String
  * 3. Char
  * 4. Float
  * 5. Double
  * 6. Unit
  * 7. Boolean
  * */

  // String and String Operation
  val aString = "Aman"
  val aComposed = "A" + 'M' + "A" + "N"
  val aInterpolated = s"My name is $aString"

  // expression
  val aExpression = 2 + 3

  // if else
  val aIfElse = {
    if (aMeaning > 50) 20
    else if (aMeaning < 0) -2
    else 0
  }

  // code block
  val aCodeBlock = {
    val aLocal = 3

    aLocal + 3 // last expression used as return
  }

  // Defining a function

  def myFunc(x: Int, y: String): String = {
    y + " " + x
  }

  // In scala, we don't use loop and iteration, we have recursion

  // Unit -> void()
  println()   // type of Unit

  println(myFunc(2, "3"))

  println(aIfElse)
  println(aMeaning)
}
