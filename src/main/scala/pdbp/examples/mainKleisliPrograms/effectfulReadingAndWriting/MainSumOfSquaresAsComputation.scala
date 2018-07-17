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

import pdbp.examples.kleisliPrograms.SumOfSquaresAsComputation

class MainSumOfSquaresAsComputation[C[+ _]: Computation] extends EffectfulUtils[C]() {

  private object sumOfSquaresAsComputation extends SumOfSquaresAsComputation[C]

  import sumOfSquaresAsComputation.sumOfSquares

  val sumOfSquaresMain: Unit `=>C` Unit = { u =>
    producer(u) bind { (z, y) => 
      sumOfSquares(z, y) bind { x => 
        consumer(x) 
      }
    }  
  }

}