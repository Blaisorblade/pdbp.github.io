package pdbp.program.meaning.ofActiveIntReading.activeIntReading

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

import pdbp.types.active.activeTypes._
import pdbp.types.active.reading.activeReadingTypes._

import pdbp.program.implicits.active.implicits.activeProgram

import pdbp.computation.meaning.ComputationMeaning

import pdbp.program.meaning.ProgramMeaning

import pdbp.computation.meaning.reading.ReadingTransformedMeaning

import pdbp.program.meaning.ofActive.active.implicits.activeMeaningOfActive

object implicits {

  import pdbp.program.implicits.active.reading.int.implicits.activeIntReadingProgram

  implicit object activeIntReadingMeaningOfActiveIntReading
      extends ReadingTransformedMeaning[BigInt, Active, Active]()
      with ComputationMeaning[ActiveReading[BigInt], ActiveReading[BigInt]]()
      with ProgramMeaning[`=>AR`[BigInt], `=>AR`[BigInt]]()
}
