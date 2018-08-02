package pdbp.program.meaning.ofActiveToConsoleWriting.active

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
import pdbp.types.active.writing.activeWritingTypes._

import pdbp.program.meaning.ProgramMeaning

import pdbp.computation.meaning.ComputationMeaning

import pdbp.computation.meaning.writing.toConsole.WritingToConsoleTransformedMeaning

import pdbp.program.implicits.active.implicits.activeProgram
import pdbp.program.implicits.active.writing.toConsole.implicits.activeWritingToConsoleProgram

object implicits {

  import pdbp.program.meaning.ofActive.active.implicits.activeMeaningOfActive

  implicit object activeMeaningOfActiveWritingToConsole
      extends WritingToConsoleTransformedMeaning[Active, Active]()
      with ComputationMeaning[ActiveWriting[ToConsole], Active]()
      with ProgramMeaning[`=>AW`[ToConsole], `=>A`]()
}