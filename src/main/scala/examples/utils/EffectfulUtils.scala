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

import pdbp.program.Function

import pdbp.utils.effectfulUtils._

trait EffectfulUtils[>-->[- _, + _]: Function] {

  import implicitly._

  private def effectfulReadIntFromConsoleWithMessage(
      message: String): Unit >--> BigInt =
    function(effectfulReadIntFromConsoleFunction(message))

  private def effectfulWriteLineToConsoleWithMessage[Y](
      message: String): Y >--> Unit =
    function(effectfulWriteLineToConsoleFunction(message))

  val effectfulReadIntFromConsole: Unit >--> BigInt =
    effectfulReadIntFromConsoleWithMessage("please type an integer")

  val effectfulWriteFactorialOfIntToConsole: BigInt >--> Unit =
    effectfulWriteLineToConsoleWithMessage(
      "the factorial value of the integer is")

}
