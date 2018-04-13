package demo

//       _______         __    __        _______
//      / ___  /\       / /\  / /\      / ___  /\
//     / /__/ / / _____/ / / / /_/__   / /__/ / /
//    / _____/ / / ___  / / / ___  /\ /____  / /
//   / /\____\/ / /__/ / / / /__/ / / \___/ / /
//  /_/ /      /______/ / /______/ /     /_/ /
//  \_\/       \______\/  \______\/      \_\/
//                                           v1.0
//  Program Description Based Programming Library
//  author        Luc Duponcheel        2017-2018

import scala.math.{sqrt => squareRoot}

object FunctionsAndExpressions {

  val z = 3.0
  val y = 4.0

  val square: Double => Double =
    z => z * z

  type &&[+Z, +Y] = Tuple2[Z, Y]

  val sum: Double && Double => Double =
    (z, y) => z + y

  val squares: Double && Double => Double && Double =
    (z, y) => (square(z), square(y))

  def main(args: Array[String]): Unit = {

    val result01: Double = squareRoot(z * z + y * y)
    val result02: Double = squareRoot(square(z) + square(y))
    val result03: Double = squareRoot(sum(square(z), square(y)))
    val result04: Double = squareRoot(sum(squares(z, y)))

    val result05: Double = (squares andThen sum andThen squareRoot)(z, y)
    val result06: Double = (squares andThen sum andThen squareRoot) apply (z, y)

    import bindingOperator.BindingOperator

    val result07: Double = (z, y) bind (squares andThen sum andThen squareRoot)

    println(result01)
    println(result02)
    println(result03)
    println(result04)
 
    println(result05)
    println(result06)

    println(result07)

  }

}
