package pdbp.program.meaning.ofReactiveFree.reactive

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
import pdbp.types.reactive.free.reactiveFreeTypes._

import pdbp.program.meaning.ProgramMeaning

import pdbp.computation.meaning.ComputationMeaning

import pdbp.computation.meaning.free.FreeTransformedMeaning

import pdbp.program.reactive.implicits.reactiveProgram
import pdbp.program.reactive.free.implicits.reactiveFreeProgram

object implicits {

  import pdbp.program.meaning.ofReactive.reactive.implicits.reactiveMeaningOfReactive

  implicit object reactiveMeaningOfReactiveFree
      extends FreeTransformedMeaning[Reactive, Reactive]()
      with ComputationMeaning[ReactiveFree, Reactive]()
      with ProgramMeaning[`=>RF`, `=>R`]()
      
}
