package pdbp.program.meaning.ofReactiveIntReadingWithWritingToConsole.reactiveIntReading

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

import pdbp.types.reactive.reactiveTypes._
import pdbp.types.reactive.reading.reactiveReadingTypes._
import pdbp.types.reactive.writing.reactiveWritingTypes._
import pdbp.types.reactive.reading.writing.reactiveReadingWithWritingTypes._

import pdbp.program.meaning.ProgramMeaning

import pdbp.computation.meaning.ComputationMeaning

import pdbp.computation.meaning.reading.ReadingTransformedMeaning

import pdbp.program.reactive.implicits.reactiveProgram
import pdbp.program.reactive.writing.toConsole.implicits.reactiveWritingToConsoleProgram
import pdbp.program.reactive.reading.int.writing.toConsole.implicits.reactiveIntReadingWithWritingToConsoleProgram

object implicits {

  import pdbp.program.meaning.ofReactiveWritingToConsole.reactive.implicits.reactiveMeaningOfReactiveWritingToConsole

  implicit object reactiveIntReadingMeaningOfReactiveIntReadingWithWritingToConsole
      extends ReadingTransformedMeaning[BigInt,
                                        ReactiveWriting[ToConsole],
                                        Reactive]()
      with ComputationMeaning[ReactiveReadingWithWriting[BigInt, ToConsole],
                              ReactiveReading[BigInt]]()
      with ProgramMeaning[`=>RRW`[BigInt, ToConsole], `=>RR`[BigInt]]()

}
