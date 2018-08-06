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

class SumOfSquares[C[+ _]: Computation]
    extends AtomicKleisliPrograms[C]()
    with HelperKleisliPrograms[C]() {

  import implicitly._

  val sumOfSquares: (Double && Double) `=>C` Double = { (z, y) =>
    square(z) bind { zSquare =>
      square(y) bind { ySquare =>
        sum(zSquare, ySquare) bind { zSquare_plus_ySquare =>
          result(zSquare_plus_ySquare)
        }
      }
    }
  }

}
