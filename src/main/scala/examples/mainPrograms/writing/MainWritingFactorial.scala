package examples.mainPrograms.writing

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

import pdbp.writable.Writable

import pdbp.program.Program
import pdbp.program.writing.Writing

import pdbp.program.compositionOperator._

import examples.programs.writing.WritingFactorial

trait MainWritingFactorial[
    W: Writable,
    >-->[- _, + _]: Program
                  : [>-->[- _, + _]] => Writing[W, >-->]] {

  private object writingFactorialObject extends WritingFactorial[W, >-->]

  import writingFactorialObject.writingFactorial

  val producer: Unit >--> BigInt

  val consumer: BigInt >--> Unit

  lazy val mainWritingFactorial: (String => W) `I=>` Unit >--> Unit = {
    producer >-->
      writingFactorial >-->
      consumer
  }

}
