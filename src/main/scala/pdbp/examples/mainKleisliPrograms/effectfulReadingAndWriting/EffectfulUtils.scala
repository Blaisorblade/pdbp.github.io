package pdbp.examples.mainKleisliPrograms.effectfulReadingAndWriting

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

  private def effectfulReadTwoDoublesFromConsole(
      message: String): Unit `=>C` (Double && Double) = { _ =>
    result(effectfulReadTwoDoublesFromConsoleFunction(message)(()))
  }

  private def effectfulWriteToConsole[Y](message: String): Y `=>C` Unit = { y =>
    result(effectfulWriteToConsoleFunction(message)(y))
  }

  val producer: Unit `=>C` (Double && Double) =
    effectfulReadTwoDoublesFromConsole("please type a double")

  val consumer: Double `=>C` Unit =
    effectfulWriteToConsole("the sum of the squares of the doubles is")

}
