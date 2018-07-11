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

import pdbp.types.product.productType._

object FactorialFunction {

  val factorialFunction: BigInt => BigInt = { i =>
    if (isZeroFunction(i)) {
      oneFunction(i)
    } else {
      val subtractOneAndThenFactorial =
        subtractOneFunction andThen factorialFunction
      multiplyFunction(i, subtractOneAndThenFactorial(i))
    }
  }

  val isZeroFunction: BigInt => Boolean = { i =>
    i == 0
  }

  def oneFunction[Z]: Z => BigInt = { z =>
    1
  }

  val multiplyFunction: (BigInt && BigInt) => BigInt = { (i, j) =>
    i * j
  }

  val subtractOneFunction: BigInt => BigInt = { i =>
    i - 1
  }

}

import pdbp.program.Function

import FactorialFunction._

class FactorialAsFunction[>-->[- _, + _]: Function] {

  import implicitly._

  val factorial: BigInt >--> BigInt = function(factorialFunction)

}

object implicits {

  implicit object functionFunction extends Function[[-Z, +Y] => (Z => Y)] {

    override def function[Z, Y]: (Z => Y) => (Z => Y) = identity

  }

}

object FactorialAsFunctionMain {

  import implicits.functionFunction

  object factorialAsFunction extends FactorialAsFunction[[-Z, +Y] => (Z => Y)]  

  def main(args: Array[String]): Unit = {

    import factorialAsFunction.factorial

    println(factorial(10))

  }

}
