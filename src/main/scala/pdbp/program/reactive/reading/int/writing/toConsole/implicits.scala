package pdbp.program.reactive.reading.int.writing.toConsole

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
import pdbp.types.reactive.writing.reactiveWritingTypes._
import pdbp.types.reactive.reading.writing.reactiveReadingWithWritingTypes._
import pdbp.types.effect.toConsole.ToConsole

import pdbp.writable.implicits.toConsole.implicits.toConsoleWritable

import pdbp.program.Program

import pdbp.program.reading.Reading

import pdbp.program.writing.Writing

import pdbp.program.reactive.reading.writing.ReactiveReadingWithWritingProgram

import pdbp.program.reactive.writing.toConsole.implicits.reactiveWritingToConsoleProgram

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.reading.ReadingTransformation

import pdbp.computation.transformation.reading.writing.ReadingWithWritingTransformation

object implicits {

  implicit object reactiveIntReadingWithWritingToConsoleProgram
      extends ReactiveReadingWithWritingProgram[BigInt, ToConsole]()
      with Computation[ReactiveReadingWithWriting[BigInt, ToConsole]]()
      with Program[`=>RRW`[BigInt, ToConsole]]()
      with Reading[BigInt, `=>RRW`[BigInt, ToConsole]]()
      with Writing[ToConsole, `=>RRW`[BigInt, ToConsole]]()
      with ReadingWithWritingTransformation[BigInt,
                                            ToConsole,
                                            ReactiveWriting[ToConsole]]()
      with ReadingTransformation[BigInt, ReactiveWriting[ToConsole]]()
      with ComputationTransformation[
        ReactiveWriting[ToConsole],
        ReactiveReadingWithWriting[BigInt, ToConsole]]()

}
