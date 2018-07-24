package pdbp.program.implicits.active.reading

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
import pdbp.types.active.reading.activeReadingTypes._

import pdbp.program.Program
import pdbp.program.reading.Reading

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.reading.ReadingTransformation

private[pdbp] trait ActiveReadingProgram[R]
    extends Computation[ActiveReading[R]]
    with Program[`=>AR`[R]]
    with Reading[R, `=>AR`[R]]
    with ComputationTransformation[Active, ActiveReading[R]]
    with ReadingTransformation[R, Active]
