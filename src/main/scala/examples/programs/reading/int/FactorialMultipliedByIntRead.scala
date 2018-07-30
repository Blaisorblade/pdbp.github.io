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

import pdbp.program.compositionOperator._
import pdbp.program.constructionOperators._

import examples.programs.Factorial

class FactorialMultipliedByIntRead[
    >-->[- _, + _]: Program
                  : [>-->[- _, + _]] => Reading[BigInt, >-->]]
    extends Factorial[>-->] {

  private val implicitProgram = implicitly[Program[>-->]]

  import implicitProgram._

  private val implicitIntReading = implicitly[Reading[BigInt, >-->]]

  import implicitIntReading._

  val factorialMultipliedByIntRead: BigInt >--> BigInt =
    (factorial & read) >--> multiply

}
