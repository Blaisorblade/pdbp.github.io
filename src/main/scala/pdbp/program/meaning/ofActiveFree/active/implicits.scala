package pdbp.program.meaning.ofActiveFree.active

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

import pdbp.program.meaning.ProgramMeaning

import pdbp.computation.meaning.ComputationMeaning

import pdbp.computation.meaning.free.FreeTransformedMeaning

import pdbp.program.implicits.active.implicits.activeProgram
import pdbp.program.implicits.active.free.implicits.activeFreeProgram

object implicits {

  import pdbp.program.meaning.ofActive.active.implicits.activeMeaningOfActive

  implicit object activeMeaningOfActiveFree
      extends FreeTransformedMeaning[Active, Active]()
      with ComputationMeaning[ActiveFree, Active]()
      with ProgramMeaning[`=>AF`, `=>A`]()
      
}
