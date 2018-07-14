package examples.programs

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

import pdbp.types.product.productType._

import examples.utils.functionUtils._

import pdbp.program.Function

class FactorialAsFunction[>-->[- _, + _]: Function] {

  import implicitly._

  val factorialFunction: BigInt => BigInt = { i =>
    if (isZeroFunction(i)) {
      oneFunction(i)
    } else {
      multiplyFunction(i, (subtractOneFunction andThen factorialFunction)(i))
    }
  }

  val factorial: BigInt >--> BigInt = function(factorialFunction)

}

object functionImplicits {

  implicit object functionFunction extends Function[[-Z, +Y] => (Z => Y)] {

    override def function[Z, Y]: (Z => Y) => (Z => Y) = identity

  }

}

object FactorialAsFunctionMain {

  import functionImplicits.functionFunction

  object factorialAsFunction extends FactorialAsFunction[[-Z, +Y] => (Z => Y)]

  def main(args: Array[String]): Unit = {

    import factorialAsFunction.factorial

    println(factorial(10))

  }

}
