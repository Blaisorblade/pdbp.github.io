package examples.main.active.reading.int.effectfulReadingAndWriting

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

import pdbp.program.implicits.active.reading.int.implicits.activeIntReadingProgram

import examples.mainPrograms.reading.int.MainFactorialMultipliedByIntRead

object FactorialMultipliedByIntReadMain
    extends MainFactorialMultipliedByIntRead[`=>AR`[BigInt]]() {

  import examples.utils.EffectfulUtils

  private val effectfulUtils = new EffectfulUtils[`=>AR`[BigInt]]

  import effectfulUtils._

  override val producer = effectfulReadIntFromConsole

  override val consumer =
    effectfulWriteFactorialOfIntMultipliedByIntReadToConsole

  def main(args: Array[String]): Unit = {

    import examples.utils.effects.implicits.readIntFromConsoleEffect

    import pdbp.program.meaning.ofActiveIntReading.activeIntReading.implicits.activeIntReadingMeaningOfActiveIntReading.meaning

    meaning(mainFactorialMultipliedByIntRead)(())

  }
}
