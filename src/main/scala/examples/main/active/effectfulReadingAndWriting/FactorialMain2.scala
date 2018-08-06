package examples.main.active.effectfulReadingAndWriting

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

import pdbp.program.implicits.active.implicits
import implicits.activeProgram

import examples.objects.active.effectfulReadingAndWriting.effectfulUtils.effectfulReadIntFromConsole
import examples.objects.active.effectfulReadingAndWriting.effectfulUtils.effectfulWriteFactorialOfIntToConsole

import pdbp.program.meaning.ofActive.active.implicits.activeMeaningOfActive
import activeMeaningOfActive.meaning

import examples.mainPrograms.MainFactorial

object FactorialMain2 extends MainFactorial[`=>A`]() {

  override val producer = effectfulReadIntFromConsole

  override val consumer = effectfulWriteFactorialOfIntToConsole

  def main(args: Array[String]): Unit = {

    meaning(factorialMain)(())

  }
}
