package pdbp.examples.kleisliPrograms

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

import pdbp.computation.Resulting

import pdbp.examples.utils.functionUtils._

trait HelperKleisliPrograms[C[+ _]: Resulting] {

  import implicitly._

  type `=>C` = [-Z, +Y] => Z => C[Y]

  val squareHelper: Double `=>C` Double = squareFunction andThen result

  val sumHelper: (Double && Double) `=>C` Double = sumFunction andThen result

}