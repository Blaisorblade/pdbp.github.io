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

import examples.utils.functionUtils._

class Factorial[>-->[- _, + _]: Program] {

  val implicitProgram = implicitly[Program[>-->]]

  import implicitProgram._

  val isZero: BigInt >--> Boolean =
    function(isZeroFunction)

  val subtractOne: BigInt >--> BigInt =
    function(subtractOneFunction)

  val multiply: (BigInt && BigInt) >--> BigInt =
    function(multiplyFunction)

  def one[Z]: Z >--> BigInt =
    function(oneFunction)

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

}
