package pdbp.program.reactive.reading

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

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.reading.ReadingTransformation

private[pdbp] trait ReactiveReadingProgram[R]
    extends Computation[ReactiveReading[R]]
    with Program[`=>RR`[R]]
    with Reading[R, `=>RR`[R]]
    with ComputationTransformation[Reactive, ReactiveReading[R]]
    with ReadingTransformation[R, Reactive]
