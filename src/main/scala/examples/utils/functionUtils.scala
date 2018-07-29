package examples.utils

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

object functionUtils {

  def sleep() = {} // Thread.sleep(1)

  val isZeroFunction: BigInt => Boolean = { i =>
    sleep()
    i == 0
  }

  val subtractOneFunction: BigInt => BigInt = { i =>
    sleep()
    i - 1
  }

  val multiplyFunction: (BigInt && BigInt) => BigInt = { (i, j) =>
    sleep()
    i * j
  }

  def oneFunction[Z]: Z => BigInt = { z =>
    sleep()
    1
  }

  val squareFunction: Double => Double = { z =>
    z * z
  }

  val sumFunction: Double && Double => Double = { (z, y) =>
    z + y
  }  

}
