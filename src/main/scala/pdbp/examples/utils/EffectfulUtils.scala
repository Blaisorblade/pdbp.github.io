package pdbp.examples.utils

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

import pdbp.utils.effectfulUtils._

import pdbp.computation.Resulting

trait EffectfulUtils[C[+ _]: Resulting] {

  import implicitly._

  type `=>C` = [-Z, +Y] => Z => C[Y]

  private def effectfulReadIntFromConsoleWithMessage(
      message: String): Unit `=>C` BigInt = { _ =>
    result(effectfulReadIntFromConsoleFunction(message)(()))
  }

  private def effectfulReadTwoDoublesFromConsoleWithMessage(
      message: String): Unit `=>C` (Double && Double) = { _ =>
    result(effectfulReadTwoDoublesFromConsoleFunction(message)(()))
  }

  private def effectfulWriteLineToConsoleWithMessage[Y](message: String): Y `=>C` Unit = {
    y =>
      result(effectfulWriteLineToConsoleFunction(message)(y))
  }

  val effectfulReadIntFromConsole: Unit `=>C` BigInt =
    effectfulReadIntFromConsoleWithMessage("please type an integer")  

  val twoDoublesProducer: Unit `=>C` (Double && Double) =
    effectfulReadTwoDoublesFromConsoleWithMessage("please type a double")

  val effectfulWriteFactorialOfIntToConsole: BigInt `=>C` Unit =
    effectfulWriteLineToConsoleWithMessage(
      "the factorial value of the integer is")

  val sumOfSquaresOfTwoDoublesConsumer: Double `=>C` Unit =
    effectfulWriteLineToConsoleWithMessage("the sum of the squares of the doubles is")

}
