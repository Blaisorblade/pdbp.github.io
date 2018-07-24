package examples.mainPrograms.reading.int.effectfulWriting

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

import examples.utils.EffectfulUtils

import examples.programs.Factorial

class MainFactorialOfIntRead[>-->[- _, + _]: Program: [>-->[- _, + _]] => Reading[BigInt, >-->]]
    extends EffectfulUtils[>-->]() {

  private val implicitProgram = implicitly[Program[>-->]]

  private val implicitIntReading = implicitly[Reading[BigInt, >-->]]

  import implicitProgram._

  import implicitIntReading._

  private object factorialObject extends Factorial[>-->]

  import factorialObject.factorial

  val factorialMain: Unit >--> Unit =
    read >-->
      factorial >-->
      factorialOfIntConsumer

}
