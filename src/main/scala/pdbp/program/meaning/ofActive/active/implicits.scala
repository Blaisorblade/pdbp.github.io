package pdbp.program.meaning.ofActive.active

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

import pdbp.program.active.implicits.activeProgram

import pdbp.program.meaning.ProgramMeaning

import pdbp.computation.meaning.ComputationMeaning

import pdbp.computation.meaning.ofActive.MeaningOfActive

object implicits {

  implicit object activeMeaningOfActive
      extends MeaningOfActive[Active]()
      with ComputationMeaning[Active, Active]()
      with ProgramMeaning[`=>A`, `=>A`]()

}
