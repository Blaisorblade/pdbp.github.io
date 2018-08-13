package pdbp.program.meaning.ofReactiveWritingToConsole.reactive

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
import pdbp.types.reactive.writing.reactiveWritingTypes._

import pdbp.program.meaning.ProgramMeaning

import pdbp.computation.meaning.ComputationMeaning

import pdbp.computation.meaning.writing.toConsole.WritingToConsoleTransformedMeaning

import pdbp.program.reactive.implicits.reactiveProgram
import pdbp.program.reactive.writing.toConsole.implicits.reactiveWritingToConsoleProgram

object implicits {

  import pdbp.program.meaning.ofReactive.reactive.implicits.reactiveMeaningOfReactive

  implicit object reactiveMeaningOfReactiveWritingToConsole
      extends WritingToConsoleTransformedMeaning[Reactive, Reactive]()
      with ComputationMeaning[ReactiveWriting[ToConsole], Reactive]()
      with ProgramMeaning[`=>RW`[ToConsole], `=>R`]()
      
}