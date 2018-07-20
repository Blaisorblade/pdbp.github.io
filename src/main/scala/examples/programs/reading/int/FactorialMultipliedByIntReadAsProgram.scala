package examples.programs.reading.int

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
import pdbp.program.reading.Reading

import examples.programs.FactorialAsProgram

trait FactorialMultipliedByIntReadAsProgram[>-->[- _, + _]: Program: [>-->[- _, + _]] => Reading[BigInt, >-->]]
    extends FactorialAsProgram[>-->] {

  private val implicitProgram = implicitly[Program[>-->]]

  import implicitProgram._

  private val implicitIntReading = implicitly[Reading[BigInt, >-->]]

  import implicitIntReading._

  import pdbp.program.compositionOperator._
  import pdbp.program.constructionOperators._

  val factorialMultipliedByIntRead: BigInt >--> BigInt =
      (factorial & read) >--> multiply

  // override def effectfulWriteToConsole[Z]: Z >--> Unit =
  //   function(writeToConsole(
  //     s"the factorial value of the integer multiplied by the integer read is"))

  // val factorialMultipliedByIntReadMain: Unit >--> Unit =
  //   effectfulReadIntFromConsole >-->
  //     factorialMultipliedByIntRead >-->
  //     effectfulWriteToConsole

}