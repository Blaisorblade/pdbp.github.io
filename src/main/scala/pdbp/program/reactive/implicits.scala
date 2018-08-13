package pdbp.program.reactive

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
import pdbp.types.reactive.reactiveTypes._

import pdbp.program.Program

import pdbp.computation.Computation

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.reactive.ReactiveTransformation

import pdbp.program.active.implicits.activeProgram

object implicits {
  
  implicit object reactiveProgram
      extends Computation[Reactive]
      with Program[`=>R`]
      with ReactiveTransformation[Active]()
      with ComputationTransformation[Active, Reactive]()
      
}