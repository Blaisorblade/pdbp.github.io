package demo

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

import demo.resulting._
import demo.bindingOperator._

object SumOfSquaresAsExpression {

  def sumOfSquares01(z: Double, y: Double) =
    result(z * z + y * y)

  def sumOfSquares02(z: Double, y: Double) =
    z * z bind { zSquare =>
      y * y bind { ySquare =>
        result(zSquare + ySquare)
      }
    }

  def sumOfSquares03(z: Double, y: Double) =
    z * z bind { zSquare =>
      y * y bind { ySquare =>
        zSquare + ySquare bind { zSquare_plus_ySquare =>
          result(zSquare_plus_ySquare)
        }
      }
    }

  def main(args: Array[String]): Unit = {
    println(sumOfSquares01(3.0, 4.0))
    println(sumOfSquares02(3.0, 4.0))
    println(sumOfSquares03(3.0, 4.0))

  }

}
