package pdbp.program.reactive.reading.writing

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

import pdbp.types.reactive.writing.reactiveWritingTypes._

import pdbp.types.reactive.reading.writing.reactiveReadingWithWritingTypes._

import pdbp.writable.Writable

import pdbp.program.Program

import pdbp.program.reading.Reading

import pdbp.program.writing.Writing

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation

import pdbp.computation.transformation.reading.writing.ReadingWithWritingTransformation

private[pdbp] trait ReactiveReadingWithWritingProgram[R, W: Writable]
    extends Computation[ReactiveReadingWithWriting[R, W]]
    with Program[`=>RRW`[R, W]]
    with Reading[R, `=>RRW`[R, W]]
    with Writing[W, `=>RRW`[R, W]]
    with ComputationTransformation[ReactiveWriting[W],
                                   ReactiveReadingWithWriting[R, W]]
    with ReadingWithWritingTransformation[R, W, ReactiveWriting[W]]
