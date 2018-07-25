package pdbp.program.implicits.active.writing

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

import pdbp.types.active.activeTypes._
import pdbp.types.active.writing.activeWritingTypes._

import pdbp.writable.Writable

import pdbp.program.Program
import pdbp.program.writing.Writing

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.writing.WritingTransformation

private[pdbp] trait ActiveWritingProgram[W : Writable]
    extends Computation[ActiveWriting[W]]
    with Program[`=>AW`[W]]
    with Writing[W, `=>AW`[W]]
    with ComputationTransformation[Active, ActiveWriting[W]]
    with WritingTransformation[W, Active]