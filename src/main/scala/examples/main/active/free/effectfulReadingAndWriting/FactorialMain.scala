package examples.main.active.free.effectfulReadingAndWriting

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

import pdbp.program.meaning.ofActiveFree.active.implicits.activeMeaningOfActiveFree
import activeMeaningOfActiveFree.meaning

import examples.objects.active.free.effectfulReadingAndWriting.mainFactorial
import mainFactorial.factorialMain

import examples.main.Main

object FactorialMain extends Main[`=>AF`] {

  override val mainKleisliProgram: Unit `=>AF` Unit = factorialMain

  val mainKleisliProgramMeaning: Unit `=>A` Unit = meaning(mainKleisliProgram)

  override val run: Unit = mainKleisliProgramMeaning(())

}