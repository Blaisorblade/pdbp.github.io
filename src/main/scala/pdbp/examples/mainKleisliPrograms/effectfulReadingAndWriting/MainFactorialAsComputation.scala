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

import pdbp.examples.kleisliPrograms.FactorialAsComputation

class MainFactorialAsComputation[C[+ _]: Computation]
    extends EffectfulUtils[C]() {

  private object factorialAsComputation extends FactorialAsComputation[C]

  import factorialAsComputation.factorial

  val factorialMain: Unit `=>C` Unit = { u =>
    effectfulReadIntFromConsole(u) bind { z =>
      factorial(z) bind { y =>
        effectfulWriteFactorialOfIntToConsole(y)
      }
    }
  }

}
