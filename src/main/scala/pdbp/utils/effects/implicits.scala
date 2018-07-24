package pdbp.utils.effects

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

import pdbp.types.effect.toConsole.ToConsole

import pdbp.utils.effectfulUtils._

object implicits {

  implicit val readIntFromConsoleEffect: BigInt = 
    effectfulReadIntFromConsoleFunction("please type an integer to read")(())

  def writeToConsoleEffect[Y](message: String): Y => ToConsole = { y =>
    ToConsole( { _ =>
      effectfulWriteToConsoleFunction(message)(y)
      } )
  }

  implicit val writeFactorialOfIntReadToConsoleEffect: BigInt => ToConsole =
    writeToConsoleEffect[BigInt]("the factorial value of the integer read is")

}