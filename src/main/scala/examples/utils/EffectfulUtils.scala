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

  private def effectfulReadIntFromConsole(message: String): Unit >--> BigInt =
    function(effectfulReadIntFromConsoleFunction(message))

  private def effectfulWriteLineToConsole[Y](message: String): Y >--> Unit =
    function(effectfulWriteLineToConsoleFunction(message))

  val intProducer: Unit >--> BigInt =
    effectfulReadIntFromConsole("please type an integer")

  def factorialOfIntConsumer: BigInt >--> Unit =
    effectfulWriteLineToConsole("the factorial value of the integer is")

  def factorialOfIntMultipliedByIntReadConsumer: BigInt >--> Unit =
    effectfulWriteLineToConsole("the factorial value of the integer multiplied by the integer read is")

}