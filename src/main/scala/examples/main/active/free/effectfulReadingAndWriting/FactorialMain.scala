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

import pdbp.program.implicits.active.free.implicits.activeFreeProgram

import examples.mainPrograms.MainFactorial

import examples.utils.EffectfulUtils

object FactorialMain
    extends MainFactorial[`=>AF`]()
    with EffectfulUtils[`=>AF`]() {

  override val producer = effectfulReadIntFromConsole

  override val consumer = effectfulWriteFactorialOfIntToConsole

  def main(args: Array[String]): Unit = {

    import pdbp.program.meaning.ofActiveFree.active.implicits.activeMeaningOfActiveFree.meaning

    meaning(factorialMain)(())

  }

}
