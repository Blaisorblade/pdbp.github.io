package pdbp.computation.meaning.instances.ofActiveFree.active

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

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.free.FreeTransformation

import pdbp.computation.meaning.instances.ofActive.active.activeMeaningOfActive

import pdbp.program.implicits.active.implicits.implicitActiveProgram
import pdbp.program.implicits.active.free.implicits.implicitActiveFreeProgram

object freeTransformationOfActive
    extends FreeTransformation[Active]()
    with ComputationTransformation[Active, ActiveFree]()

object activeMeaningOfActiveFree
    extends FreeTransformedMeaning[Active, Active](activeMeaningOfActive,
                                                   Some(freeTransformationOfActive))
    with ComputationMeaning[ActiveFree, Active]()
    with ProgramMeaning[`=>AF`, `=>A`]()
  