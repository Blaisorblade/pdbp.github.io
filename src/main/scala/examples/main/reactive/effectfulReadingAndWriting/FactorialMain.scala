package examples.main.reactive.effectfulReadingAndWriting

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

import pdbp.types.reactive.reactiveTypes._

import pdbp.program.reactive.implicits.reactiveProgram

import examples.mainPrograms.MainFactorial

object FactorialMain extends MainFactorial[`=>R`]() {

  import examples.utils.EffectfulUtils

  private val effectfulUtils = new EffectfulUtils[`=>R`]

  import effectfulUtils._

  override val producer = effectfulReadIntFromConsole

  override val consumer = effectfulWriteFactorialOfIntToConsole

  def main(args: Array[String]): Unit = {

    import pdbp.program.meaning.ofReactive.reactive.implicits.reactiveMeaningOfReactive.meaning

    meaning(mainFactorial)(())(identity)

  }

}
