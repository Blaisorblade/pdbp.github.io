package pdbp.program.reactive.writing

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

import pdbp.writable.Writable

import pdbp.program.Program
import pdbp.program.writing.Writing

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.writing.WritingTransformation

private[pdbp] trait ReactiveWritingProgram[W: Writable]
    extends Computation[ReactiveWriting[W]]
    with Program[`=>RW`[W]]
    with Writing[W, `=>RW`[W]]
    with ComputationTransformation[Reactive, ReactiveWriting[W]]
    with WritingTransformation[W, Reactive]
