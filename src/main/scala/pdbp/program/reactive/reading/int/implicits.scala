package pdbp.program.reactive.reading.int

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

import pdbp.program.Program

import pdbp.program.reading.Reading

import pdbp.program.reactive.reading.ReactiveReadingProgram

import pdbp.program.reactive.implicits.reactiveProgram

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.reading.ReadingTransformation

object implicits {

  implicit object reactiveIntReadingProgram
      extends ReactiveReadingProgram[BigInt]()
      with Computation[ReactiveReading[BigInt]]()
      with Program[`=>RR`[BigInt]]()
      with Reading[BigInt, `=>RR`[BigInt]]()
      with ReadingTransformation[BigInt, Reactive]()
      with ComputationTransformation[Reactive, ReactiveReading[BigInt]]()

}
