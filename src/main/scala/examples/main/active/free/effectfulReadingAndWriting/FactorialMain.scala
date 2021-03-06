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

import pdbp.types.active.free.activeFreeTypes._

import pdbp.program.active.free.implicits.activeFreeProgram

import examples.mainPrograms.MainFactorial

object FactorialMain extends MainFactorial[`=>AF`]() {

  import examples.utils.EffectfulUtils

  private val effectfulUtils = new EffectfulUtils[`=>AF`]

  import effectfulUtils._

  override val producer = effectfulReadIntFromConsole

  override val consumer = effectfulWriteFactorialOfIntToConsole

  def main(args: Array[String]): Unit = {

    import pdbp.program.meaning.ofActiveFree.active.implicits.activeMeaningOfActiveFree.meaning

    val mainFactorialMeaning: Unit = meaning(mainFactorial)(())

  }

}
