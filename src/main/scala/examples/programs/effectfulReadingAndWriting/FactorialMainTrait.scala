package examples.programs.effectfulReadingAndWriting

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

import pdbp.program.Program

import pdbp.program.compositionOperator._

import pdbp.utils.effectfulUtils._

import examples.utils.functionUtils._

import examples.programs.FactorialTrait

trait FactorialMainTrait[>-->[- _, + _]: Program] extends FactorialTrait[>-->] {

  import implicitly._

  private def effectfulReadIntFromConsole(message: String): Unit >--> BigInt =
    function(effectfulReadIntFromConsoleFunction(message))

  private def effectfulWriteToConsole[Y](message: String): Y >--> Unit =
    function(effectfulWriteToConsoleFunction(message))

  private val producer: Unit >--> BigInt =
    effectfulReadIntFromConsole("please type an integer")

  private val consumer: BigInt >--> Unit =
    effectfulWriteToConsole("the factorial value of the integer is")

  val factorialMain: Unit >--> Unit =
    producer >-->
      factorial >-->
      consumer

}