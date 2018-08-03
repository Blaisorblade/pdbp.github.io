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

import pdbp.computation.Computation

import pdbp.computation.bindingOperator._

class FactorialAsComputation[C[+ _]: Computation]
    extends AtomicKleisliPrograms[C]()
    with HelperKleisliPrograms[C]() {

  import implicitly._

  val factorial: BigInt `=>C` BigInt = { z =>
    isZero(z) bind { b =>
      if (b) {
        one(z)
      } else {
        subtractOne(z) bind { y =>
          factorial(y) bind { x =>
            multiply((z, x))
          }
        }
      }
    }
  }

}
