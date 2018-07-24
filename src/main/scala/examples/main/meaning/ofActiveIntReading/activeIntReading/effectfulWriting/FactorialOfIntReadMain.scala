package examples.main.meaning.ofActiveIntReading.activeIntReading.effectfulWriting

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

import pdbp.types.active.reading.activeReadingTypes._

import pdbp.program.meaning.ofActiveIntReading.activeIntReading.implicits.activeIntReadingMeaningOfActiveIntReading
import activeIntReadingMeaningOfActiveIntReading.binaryTransformation

import examples.objects.active.reading.int.effectfulWriting.mainFactorialOfIntRead
import mainFactorialOfIntRead.factorialMain

import examples.main.Main

object FactorialOfIntReadMain extends Main[`=>AR`[BigInt]] {

  import pdbp.utils.effects.implicits.readIntFromConsoleEffect
 
  private type `=>AR[BigInt]` = `=>AR`[BigInt]

  override val mainKleisliProgram: Unit `=>AR[BigInt]` Unit = factorialMain
 
  override val run = mainKleisliProgram(())

}
