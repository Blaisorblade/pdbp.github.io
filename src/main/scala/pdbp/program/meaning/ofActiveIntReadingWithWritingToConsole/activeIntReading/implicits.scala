package pdbp.program.meaning.ofActiveIntReadingWithWritingToConsole.activeIntReading

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

import pdbp.types.effect.toConsole.ToConsole

import pdbp.types.active.activeTypes._
import pdbp.types.active.reading.activeReadingTypes._
import pdbp.types.active.writing.activeWritingTypes._
import pdbp.types.active.reading.writing.activeReadingWithWritingTypes._

import pdbp.program.meaning.ProgramMeaning

import pdbp.computation.meaning.ComputationMeaning

import pdbp.computation.meaning.reading.ReadingTransformedMeaning

import pdbp.program.active.implicits.activeProgram
import pdbp.program.active.writing.toConsole.implicits.activeWritingToConsoleProgram
import pdbp.program.active.reading.int.writing.toConsole.implicits.activeIntReadingWithWritingToConsoleProgram

object implicits {

  import pdbp.program.meaning.ofActiveWritingToConsole.active.implicits.activeMeaningOfActiveWritingToConsole

  implicit object activeIntReadingMeaningOfActiveIntReadingWithWritingToConsole
      extends ReadingTransformedMeaning[BigInt,
                                        ActiveWriting[ToConsole],
                                        Active]()
      with ComputationMeaning[ActiveReadingWithWriting[BigInt, ToConsole],
                              ActiveReading[BigInt]]()
      with ProgramMeaning[`=>ARW`[BigInt, ToConsole], `=>AR`[BigInt]]()

}
