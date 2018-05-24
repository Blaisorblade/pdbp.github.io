package pdbp.program.instances.active.reading.int

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

import pdbp.program.reading.Reading

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.reading.ReadingTransformation

import pdbp.program.instances.active.reading.ActiveReadingProgram

import pdbp.program.implicits.active.implicits.implicitActiveProgram

object activeIntReadingProgram
    extends ActiveReadingProgram[BigInt]()
    with ComputationTransformation[Active, ActiveReading[BigInt]]()
    with ReadingTransformation[BigInt, Active]()