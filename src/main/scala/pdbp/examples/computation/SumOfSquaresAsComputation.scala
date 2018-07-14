package pdbp.examples.computation

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
        bind(result(squareFunction(z)), { ySquare =>
          bind(result(sumFunction(zSquare, ySquare)), { zSquare_plus_ySquare =>
            result(zSquare_plus_ySquare)
          })
        })
      }
    )

}

object computationImplicits {

  type I[+Z] = Z

  implicit object identityComputation extends Computation[I] {

    override def result[Z]: Z => I[Z] = identity

    override def bind[Z, Y](iz: I[Z], `z=>iy`: => Z => I[Y]): I[Y] = `z=>iy`(iz)

  }

}

object SumOfSquaresAsComputationMain {

  import computationImplicits.I
  import computationImplicits.identityComputation

  object sumOfSquaresAsComputation extends SumOfSquaresAsComputation[I]

  def main(args: Array[String]): Unit = {
    import sumOfSquaresAsComputation.sumOfSquares
    println(sumOfSquares(3.0, 4.0))
  }

}
