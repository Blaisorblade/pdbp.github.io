package examples.program

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

import pdbp.program.Program

import pdbp.program.compositionOperator._

import pdbp.utils.effectfulUtils._

import examples.utils.functionUtils._

class Factorial[>-->[- _, + _]: Program] {

  import implicitly._

  val factorial: BigInt >--> BigInt =
    `if`(isZero) {
      one
    } `else` {
      `let` {
        subtractOne >-->
          factorial
      } `in` {
        multiply
      }
    }

  val isZero: BigInt >--> Boolean =
    function(isZeroFunction)

  val subtractOne: BigInt >--> BigInt =
    function(subtractOneFunction)

  val multiply: (BigInt && BigInt) >--> BigInt =
    function(multiplyFunction)

  def one[Z]: Z >--> BigInt =
    function(oneFunction)

  def effectfulReadIntFromConsole(message: String): Unit >--> BigInt =
    function(effectfulReadIntFromConsoleFunction(message))

  def effectfulWriteToConsole[Y](message: String): Y >--> Unit =
    function(effectfulWriteToConsoleFunction(message))

  val producer: Unit >--> BigInt =
    effectfulReadIntFromConsole("please type an integer")

  val consumer: BigInt >--> Unit =
    effectfulWriteToConsole("the factorial value of the integer is")

  val factorialMain: Unit >--> Unit =
    producer >-->
      factorial >-->
      consumer

}
