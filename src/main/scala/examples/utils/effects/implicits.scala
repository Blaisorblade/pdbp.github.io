package examples.utils.effects

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

  private def readIntFromConsoleEffectWithMessage(message: String): BigInt =
    effectfulReadIntFromConsoleFunction(message)(())

  private def writeLineToConsoleEffectWithMessage[Z](
      message: String): Z => ToConsole = { z =>
    ToConsole({ _ =>
      effectfulWriteLineToConsoleFunction(message)(z)
    })
  }

  private def writeToConsoleEffectWithMessage[Z](
      message: String): Z => ToConsole = { z =>
    ToConsole({ _ =>
      effectfulWriteToConsoleFunction(message)(z)
    })
  }

  implicit lazy val readIntFromConsoleEffect: BigInt =
    readIntFromConsoleEffectWithMessage("please type an integer to read")

  implicit lazy val writeFactorialOfIntToConsoleEffect: BigInt => ToConsole =
    writeLineToConsoleEffectWithMessage(
      "the factorial value of the integer is"
    )

  implicit lazy val writeFactorialOfIntReadFromConsoleToConsoleEffect
    : BigInt => ToConsole =
    writeLineToConsoleEffectWithMessage(
      "the factorial value of the integer read is"
    )

  implicit lazy val writeToConsoleEffect: String => ToConsole =
    writeToConsoleEffectWithMessage("")

}
