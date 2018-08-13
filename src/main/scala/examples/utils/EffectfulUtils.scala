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

import pdbp.program.Program

import pdbp.utils.effectfulUtils._

class EffectfulUtils[>-->[- _, + _]: Program] {

  import implicitly._

  private def effectfulReadIntFromConsoleWithMessage(
      message: String): Unit >--> BigInt =
    function(effectfulReadIntFromConsoleFunction(message))

  private def effectfulWriteLineToConsoleWithMessage[Y](
      message: String): Y >--> Unit =
    function[Y, Unit](effectfulWriteLineToConsoleFunction(message))

  lazy val effectfulReadIntFromConsole: Unit >--> BigInt =
    effectfulReadIntFromConsoleWithMessage("please type an integer")

  lazy val effectfulWriteFactorialOfIntToConsole: BigInt >--> Unit =
    effectfulWriteLineToConsoleWithMessage(
      "the factorial value of the integer is")

  lazy val effectfulWriteFactorialOfIntReadToConsole: BigInt >--> Unit =
    effectfulWriteLineToConsoleWithMessage(
      "the factorial value of the integer read is")

  lazy val effectfulWriteFactorialOfIntMultipliedByIntReadToConsole
    : BigInt >--> Unit =
    effectfulWriteLineToConsoleWithMessage(
      "the factorial value of the integer multiplied by the integer read is")

}
