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

import pdbp.computation.Computation

import examples.utils.functionUtils._

class SumOfSquaresAsComputation[C[+ _]: Computation] {

  import implicitly._

  def sumOfSquares(z: Double, y: Double) =
    bind(
      result(squareFunction(z)), { zSquare =>
        bind(result(squareFunction(y)), { ySquare =>
          bind(result(sumFunction(zSquare, ySquare)), { zSquare_plus_ySquare =>
            result(zSquare_plus_ySquare)
          })
        })
      }
    )

}

// object computationImplicits {

//   implicit object identityComputation extends Computation[[+Z] => Z] {

//     override def result[Z]: Z => Z = identity

//     override def bind[Z, Y](z: Z, `z=>y`: => Z => Y): Y = `z=>y`(z)

//   }

// }

// object SumOfSquaresAsComputationMain {

//   import computationImplicits.identityComputation

//   object sumOfSquaresAsComputation extends SumOfSquaresAsComputation[[+Z] => Z]

//   import sumOfSquaresAsComputation.sumOfSquares

//   def main(args: Array[String]): Unit = {

//     println(sumOfSquares(3.0, 4.0))

//   }

// }
