package examples.main.meaning.ofActiveFree.active.effectfulReadingAndWriting

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

import pdbp.program.meaning.ofActiveFree.active.implicits.activeMeaningOfActiveFree
import activeMeaningOfActiveFree.binaryTransformation

import examples.objects.active.free.effectfulReadingAndWriting.mainFactorial
import mainFactorial.factorialMain

import examples.main.Main

object FactorialMain extends Main[`=>A`] {

  override val mainKleisliProgram: Unit `=>A` Unit = binaryTransformation(factorialMain)
 
  override val run = mainKleisliProgram(())

}
