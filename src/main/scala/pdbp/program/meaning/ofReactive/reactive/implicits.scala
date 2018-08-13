package pdbp.program.meaning.ofReactive.reactive

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

import pdbp.program.reactive.implicits.reactiveProgram

import pdbp.program.meaning.ProgramMeaning

import pdbp.computation.meaning.ComputationMeaning

import pdbp.computation.meaning.IdentityMeaning

object implicits {

  implicit object reactiveMeaningOfReactive
      extends IdentityMeaning[Reactive]()
      with ComputationMeaning[Reactive, Reactive]()
      with ProgramMeaning[`=>R`, `=>R`]()

}
