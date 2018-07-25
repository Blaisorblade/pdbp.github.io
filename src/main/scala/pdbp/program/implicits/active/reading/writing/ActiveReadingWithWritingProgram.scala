package pdbp.program.implicits.active.reading.writing

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

import pdbp.types.active.writing.activeWritingTypes._

import pdbp.types.active.reading.writing.activeReadingWithWritingTypes._

import pdbp.writable.Writable

import pdbp.program.Program

import pdbp.program.reading.Reading

import pdbp.program.writing.Writing

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation

import pdbp.computation.transformation.reading.writing.ReadingWithWritingTransformation

trait ActiveReadingWithWritingProgram[R, W: Writable]
    extends Computation[ActiveReadingWithWriting[R, W]]
    with Program[`=>ARW`[R, W]]
    with Reading[R, `=>ARW`[R, W]]
    with Writing[W, `=>ARW`[R, W]]
    with ComputationTransformation[ActiveWriting[W], ActiveReadingWithWriting[R, W]]
    with ReadingWithWritingTransformation[R, W, ActiveWriting[W]]