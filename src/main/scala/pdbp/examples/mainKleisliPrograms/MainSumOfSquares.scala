package pdbp.examples.mainKleisliPrograms

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

import pdbp.computation.Computation

import pdbp.examples.kleisliPrograms.SumOfSquares

trait MainSumOfSquares[C[+ _]: Computation] {

  import pdbp.computation.bindingOperator._

  private object sumOfSquaresObject extends SumOfSquares[C]

  import sumOfSquaresObject.sumOfSquares

  type `=>C` = [-Z, +Y] => Z => C[Y]

  val producer: Unit `=>C` (Double && Double)

  val consumer: Double `=>C` Unit

  lazy val mainSumOfSquares: Unit `=>C` Unit = { u =>
    producer(u) bind { (z, y) =>
      sumOfSquares(z, y) bind { x =>
        consumer(x)
      }
    }
  }

}
