package pdbp.utils

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

import scala.io.StdIn.{readInt, readDouble}

import pdbp.types.product.productType._

object effectfulUtils {

  def effectfulReadIntFromConsoleFunction(message: String): Unit => BigInt = {
    _ =>
      println(s"$message")
      val i = BigInt(readInt())
      i
  }

   def effectfulReadTwoDoublesFromConsoleFunction(message: String): Unit => (Double && Double) = {
    _ =>
      println(s"$message")
      val d1 = readDouble()
      println(s"$message")
      val d2 = readDouble()     
      (d1, d2)
  } 

  def effectfulWriteToConsoleFunction[Y](message: String): Y => Unit = { y =>
    println(s"$message")
    val u = println(s"$y")
    u
  }

}
