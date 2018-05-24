package examples.mainPrograms.effectfulReadingAndWriting

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

import pdbp.program.compositionOperator._

import pdbp.utils.effectfulUtils._

import examples.programs.Factorial

trait MainFactorial[>-->[- _, + _]: Program] {

  import implicitly._

  private def effectfulReadIntFromConsole(message: String): Unit >--> BigInt =
    function(effectfulReadIntFromConsoleFunction(message))

  private def effectfulWriteToConsole[Y](message: String): Y >--> Unit =
    function(effectfulWriteToConsoleFunction(message))

  private val producer: Unit >--> BigInt =
    effectfulReadIntFromConsole("please type an integer")

  private val consumer: BigInt >--> Unit =
    effectfulWriteToConsole("the factorial value of the integer is")

  private object factorialObject extends Factorial[>-->]

  import factorialObject.factorial

  val factorialMain: Unit >--> Unit =
    producer >-->
      factorial >-->
      consumer

}