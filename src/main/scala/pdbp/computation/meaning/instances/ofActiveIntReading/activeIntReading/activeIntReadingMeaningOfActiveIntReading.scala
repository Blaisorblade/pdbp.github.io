package pdbp.computation.meaning.instances.ofActiveIntReading.activeIntReading

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

import pdbp.program.implicits.active.implicits.implicitActiveProgram

import pdbp.program.implicits.active.reading.int.implicits.implicitActiveIntReadingProgram

import pdbp.computation.meaning.ComputationMeaning

import pdbp.program.meaning.ProgramMeaning

import pdbp.computation.meaning.reading.ReadingTransformedMeaning

import pdbp.computation.meaning.instances.ofActive.active.activeMeaningOfActive

object activeIntReadingMeaningOfActiveIntReading
    extends ReadingTransformedMeaning[BigInt, Active, Active](activeMeaningOfActive, None)
    with ComputationMeaning[ActiveReading[BigInt], ActiveReading[BigInt]]()
    with ProgramMeaning[`=>AR`[BigInt], `=>AR`[BigInt]]()