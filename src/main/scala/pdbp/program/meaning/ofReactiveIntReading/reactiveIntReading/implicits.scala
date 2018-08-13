package pdbp.program.meaning.ofReactiveIntReading.reactiveIntReading

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

import pdbp.types.reactive.reactiveTypes._
import pdbp.types.reactive.reading.reactiveReadingTypes._

import pdbp.program.reactive.implicits.reactiveProgram

import pdbp.computation.meaning.ComputationMeaning

import pdbp.program.meaning.ProgramMeaning

import pdbp.computation.meaning.reading.ReadingTransformedMeaning

import pdbp.program.meaning.ofReactive.reactive.implicits.reactiveMeaningOfReactive

object implicits {

  import pdbp.program.reactive.reading.int.implicits.reactiveIntReadingProgram

  implicit object reactiveIntReadingMeaningOfReactiveIntReading
      extends ReadingTransformedMeaning[BigInt, Reactive, Reactive]()
      with ComputationMeaning[ReactiveReading[BigInt], ReactiveReading[BigInt]]()
      with ProgramMeaning[`=>RR`[BigInt], `=>RR`[BigInt]]()
}
