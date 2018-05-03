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

import pdbp.utils.productUtils._

import pdbp.program.Program
import pdbp.program.compositionOperator._

class FactorialTopDown[>-->[- _, + _]: Program] {

  import implicitly._

  val factorial: BigInt >--> BigInt =
    `if`(isZero) {
      one
    } `else` {
      factorialOfNonZero
    }

  val isZero: BigInt >--> Boolean =
    function(isZeroFunction)

  val isZeroFunction: BigInt => Boolean = { i =>
    i == 0
  }

  def one[Z]: Z >--> BigInt =
    function(oneFunction)

  def oneFunction[Z]: Z => BigInt = { z =>
    1
  }

  val factorialOfNonZero: BigInt >--> BigInt =
    `let` {
      subtractOneAndThenFactorial
    } `in` {
      multiply
    }

  val multiply: (BigInt && BigInt) >--> BigInt =
    function(multiplyFunction)

  val multiplyFunction: (BigInt && BigInt) => BigInt = { (i, j) =>
    i * j
  }

  val subtractOneAndThenFactorial: BigInt >--> BigInt =
    subtractOne >-->
      factorial

  val subtractOne: BigInt >--> BigInt =
    function(subtractOneFunction)

  val subtractOneFunction: BigInt => BigInt = { i =>
    i - 1
  }

}
