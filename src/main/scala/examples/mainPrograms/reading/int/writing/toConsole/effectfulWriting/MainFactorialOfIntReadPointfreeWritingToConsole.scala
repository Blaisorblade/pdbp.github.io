package examples.mainPrograms.reading.int.writing.toConsole.effectfulWriting

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

import pdbp.types.implicitFunctionType._

import pdbp.types.effect.toConsole.ToConsole

import pdbp.program.Program

import pdbp.program.reading.Reading

import pdbp.program.writing.Writing

import pdbp.program.compositionOperator._

import pdbp.writable.implicits.toConsole.implicits.toConsoleWritable

import examples.utils.EffectfulUtils

import examples.utils.EffectfulUtils

import examples.programs.writing.PointfreeWritingFactorial

class MainFactorialOfIntReadPointfreeWritingToConsole[
  >-->[- _, + _]: Program
                : [>-->[- _, + _]] => Reading[BigInt, >-->]
                : [>-->[- _, + _]] => Writing[ToConsole, >-->]] extends EffectfulUtils[>-->]() {
  
  private val implicitProgram = implicitly[Program[>-->]]

  private val implicitIntReading = implicitly[Reading[BigInt, >-->]]

  //private val implicitToConsoleWriting = implicitly[Writing[ToConsole, >-->]]

  import implicitProgram._

  import implicitIntReading._

  //import implicitToConsoleWriting._

  private object pointfreeWritingFactorialObject extends PointfreeWritingFactorial[ToConsole, >-->]

  import pointfreeWritingFactorialObject.factorial

  val factorialMain: (String => ToConsole) `I=>` Unit >--> Unit =
    read >-->
      factorial >-->
      factorialOfIntConsumer

}
