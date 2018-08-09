package pdbp.program.implicits.active.free

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
import pdbp.types.active.free.activeFreeTypes._

import pdbp.program.Program

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.free.FreeTransformation

import pdbp.program.implicits.active.implicits.activeProgram

object implicits {
  
  implicit object activeFreeProgram
      extends Computation[ActiveFree]
      with Program[`=>AF`]
      with FreeTransformation[Active]()
      with ComputationTransformation[Active, ActiveFree]()

}