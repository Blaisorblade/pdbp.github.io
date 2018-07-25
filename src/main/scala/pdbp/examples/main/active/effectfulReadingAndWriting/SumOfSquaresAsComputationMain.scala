package pdbp.examples.main.active.effectfulReadingAndWriting

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

import pdbp.examples.objects.active.effectfulReadingAndWriting.mainSumOfSquaresAsComputation
import mainSumOfSquaresAsComputation.sumOfSquaresMain

import examples.main.Main

object SumOfSquaresAsComputationMain extends Main[`=>A`] {

  override val mainKleisliProgram: Unit `=>A` Unit = sumOfSquaresMain
 
  override val run = mainKleisliProgram(())

}