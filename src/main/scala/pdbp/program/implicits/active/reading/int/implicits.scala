package pdbp.program.implicits.active.reading.int

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

import pdbp.program.implicits.active.reading.ActiveReadingProgram

import pdbp.program.implicits.active.implicits.activeProgram

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.reading.ReadingTransformation

object implicits {

  implicit object activeIntReadingProgram
      extends ActiveReadingProgram[BigInt]()
      with Computation[ActiveReading[BigInt]]()
      with Program[`=>AR`[BigInt]]()
      with Reading[BigInt, `=>AR`[BigInt]]()      
      with ReadingTransformation[BigInt, Active]()
      with ComputationTransformation[Active, ActiveReading[BigInt]]()

}
