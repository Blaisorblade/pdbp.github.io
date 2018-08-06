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

import pdbp.computation.Computation

import pdbp.computation.bindingOperator._

import pdbp.examples.utils.EffectfulUtils

import pdbp.examples.kleisliPrograms.SumOfSquares

class MainSumOfSquares[C[+ _]: Computation]
    extends EffectfulUtils[C]() {

  private object sumOfSquaresObject extends SumOfSquares[C]

  import sumOfSquaresObject.sumOfSquares

  val sumOfSquaresMain: Unit `=>C` Unit = { u =>
    twoDoublesProducer(u) bind { (z, y) =>
      sumOfSquares(z, y) bind { x =>
        sumOfSquaresOfTwoDoublesConsumer(x)
      }
    }
  }

}
