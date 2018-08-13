package pdbp.program.reactive.writing.toConsole

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

import pdbp.writable.implicits.toConsole.implicits.toConsoleWritable

import pdbp.program.Program

import pdbp.program.writing.Writing

import pdbp.program.reactive.writing.ReactiveWritingProgram
import pdbp.program.reactive.implicits.reactiveProgram

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.writing.WritingTransformation

object implicits {

  implicit object reactiveWritingToConsoleProgram
      extends ReactiveWritingProgram[ToConsole]()
      with Computation[ReactiveWriting[ToConsole]]()
      with Program[`=>RW`[ToConsole]]()
      with Writing[ToConsole, `=>RW`[ToConsole]]()
      with ComputationTransformation[Reactive, ReactiveWriting[ToConsole]]()
      with WritingTransformation[ToConsole, Reactive]()

}
