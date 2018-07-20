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

import pdbp.types.effect.console.consoleTypes._

import pdbp.utils.effectfulUtils._

object implicits {

  implicit def readIntFromConsoleEffect: ReadFromConsoleEffect[BigInt] = 
    effectfulReadIntFromConsoleFunction("please type an integer to read")(())

  // def writeToConsoleEffect[Y](
  //     message: String): WriteToConsoleEffect[Y] = { y =>
  //   _ =>
  //     writeToConsole(message)(y)
  // }

}