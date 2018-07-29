package examples.mainPrograms.reading.int.writing.toConsole

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

import examples.programs.writing.PointfulWritingFactorial

class MainFactorialOfIntReadPointfulWritingToConsoleWrittenToConsole[
  >-->[- _, + _]: Program
                : [>-->[- _, + _]] => Reading[BigInt, >-->]
                : [>-->[- _, + _]] => Writing[ToConsole, >-->]] {
  
  private val implicitProgram = implicitly[Program[>-->]]

  private val implicitIntReading = implicitly[Reading[BigInt, >-->]]

  private val implicitToConsoleWriting = implicitly[Writing[ToConsole, >-->]]

  import implicitProgram._

  import implicitIntReading._

  import implicitToConsoleWriting._

  private object pointfulWritingFactorialObject extends PointfulWritingFactorial[ToConsole, >-->]

  import pointfulWritingFactorialObject.factorial

  val factorialMain: (BigInt => ToConsole) `I=>` ((String => ToConsole) `I=>` Unit >--> Unit) =
    read >-->
      factorial >-->
      write

}
