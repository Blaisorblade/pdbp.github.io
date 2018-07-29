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

  val isZeroFunction: BigInt => Boolean = { i =>
    Thread.sleep(10)
    i == 0
  }

  val subtractOneFunction: BigInt => BigInt = { i =>
    Thread.sleep(10)
    i - 1
  }

  val multiplyFunction: (BigInt && BigInt) => BigInt = { (i, j) =>
    Thread.sleep(10)
    i * j
  }

  def oneFunction[Z]: Z => BigInt = { z =>
    Thread.sleep(10)
    1
  }

  val squareFunction: Double => Double = { z =>
    z * z
  }

  val sumFunction: Double && Double => Double = { (z, y) =>
    z + y
  }  

}
