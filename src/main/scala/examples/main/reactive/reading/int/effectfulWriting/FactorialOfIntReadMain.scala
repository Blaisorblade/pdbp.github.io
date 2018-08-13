package examples.main.reactive.reading.int.effectfulWriting

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

import pdbp.types.reactive.reading.reactiveReadingTypes._

import pdbp.program.reactive.reading.int.implicits.reactiveIntReadingProgram

import examples.mainPrograms.MainFactorial

object FactorialOfIntReadMain extends MainFactorial[`=>RR`[BigInt]]() {

  import examples.utils.EffectfulUtils

  private val effectfulUtils = new EffectfulUtils[`=>RR`[BigInt]]

  import effectfulUtils._

  override val producer = reactiveIntReadingProgram.read

  override val consumer = effectfulWriteFactorialOfIntReadToConsole

  def main(args: Array[String]): Unit = {

    import examples.utils.effects.implicits.readIntFromConsoleEffect

    import pdbp.program.meaning.ofReactiveIntReading.reactiveIntReading.implicits.reactiveIntReadingMeaningOfReactiveIntReading.meaning

    val mainFactorialMeaning: (Unit => Unit) => Unit = meaning(mainFactorial)(())

    mainFactorialMeaning(identity)

  }
}
