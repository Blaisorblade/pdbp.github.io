package examples.main.reactive.free.effectfulReadingAndWriting

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

import pdbp.types.reactive.free.reactiveFreeTypes._

import pdbp.program.reactive.free.implicits.reactiveFreeProgram

import examples.mainPrograms.MainFactorial

object FactorialMain extends MainFactorial[`=>RF`]() {

  import examples.utils.EffectfulUtils

  private val effectfulUtils = new EffectfulUtils[`=>RF`]

  import effectfulUtils._

  override val producer = effectfulReadIntFromConsole

  override val consumer = effectfulWriteFactorialOfIntToConsole

  def main(args: Array[String]): Unit = {

    import pdbp.program.meaning.ofReactiveFree.reactive.implicits.reactiveMeaningOfReactiveFree.meaning

    val mainFactorialMeaning: (Unit => Unit) => Unit = meaning(mainFactorial)(())

    mainFactorialMeaning(identity)

  }

}
