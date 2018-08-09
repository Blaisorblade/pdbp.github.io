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

import pdbp.computation.Computation

import pdbp.examples.kleisliPrograms.Factorial

trait MainFactorial[C[+ _]: Computation] {

  import pdbp.computation.bindingOperator._

  private object factorialObject extends Factorial[C]

  import factorialObject.factorial

  type `=>C` = [-Z, +Y] => Z => C[Y]

  val producer: Unit `=>C` BigInt

  val consumer: BigInt `=>C` Unit

  val factorialMain: Unit `=>C` Unit = { u =>
    producer(u) bind { z =>
      factorial(z) bind { y =>
        consumer(y)
      }
    }
  }

}
