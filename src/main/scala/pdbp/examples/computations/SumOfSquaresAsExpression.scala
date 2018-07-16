package pdbp.examples.computations

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

import examples.utils.functionUtils._

class SumOfSquaresAsExpression[C[+ _]: Resulting] {

  import implicitly._

  type `=>C` = [-Z, +Y] => Z => C[Y]

  val sumOfSquaresFunction: Double && Double => Double = { (z, y) =>
    sumFunction(squareFunction(z), squareFunction(y))
  }

  val sumOfSquares: (Double && Double) `=>C` Double =
    sumOfSquaresFunction andThen result

}

// object resultingImplicits {

//   implicit object identityResulting extends Resulting[[+Z] => Z] {

//     override def result[Z]: Z => Z = identity

//   }

// }

// object SumOfSquaresAsExpressionMain {

//   import resultingImplicits.identityResulting

//   object sumOfSquaresAsExpression extends SumOfSquaresAsExpression[[+Z] => Z]

//   import sumOfSquaresAsExpression.sumOfSquares

//   def main(args: Array[String]): Unit = {

//     println(sumOfSquares(3.0, 4.0))

//   }

// }
