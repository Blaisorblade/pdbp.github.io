package examples.mainPrograms.writing.toConsole

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
import pdbp.program.writing.Writing

import pdbp.program.compositionOperator._

import examples.programs.writing.WritingFactorial

import pdbp.writable.implicits.toConsole.implicits.toConsoleWritable

import pdbp.program.implicits.active.writing.toConsole.implicits.activeWritingToConsoleProgram

trait MainFactorialWritingToConsole[
    >-->[- _, + _]: Program
                  : [>-->[- _, + _]] => Writing[ToConsole, >-->]] {

  private object writingFactorialObject extends WritingFactorial[ToConsole, >-->]

  import writingFactorialObject.writingFactorial

  val producer: Unit >--> BigInt
  
  val consumer: BigInt >--> Unit

  lazy val writingFactorialMain: (String => ToConsole) `I=>` Unit >--> Unit = {
    producer >-->
      writingFactorial >-->
      consumer
  } 
  
}