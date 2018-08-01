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

import examples.programs.writing.WritingFactorial

class MainFactorialOfIntReadWritingToConsoleWrittenToConsole[
    >-->[- _, + _]: Program
                  : [>-->[- _, + _]] => Reading[BigInt, >-->]
                  : [>-->[- _, + _]] => Writing[ToConsole, >-->]] {

  private val implicitIntReading = implicitly[Reading[BigInt, >-->]]

  private val implicitToConsoleWriting = implicitly[Writing[ToConsole, >-->]]

  import implicitIntReading._

  import implicitToConsoleWriting._

  private object writingFactorialObject
      extends WritingFactorial[ToConsole, >-->]

  import writingFactorialObject.factorial

  val factorialMain
    : (String => ToConsole) `I=>` ((BigInt => ToConsole) `I=>` Unit >--> Unit) =
    read >-->
      factorial >-->
      write

}
