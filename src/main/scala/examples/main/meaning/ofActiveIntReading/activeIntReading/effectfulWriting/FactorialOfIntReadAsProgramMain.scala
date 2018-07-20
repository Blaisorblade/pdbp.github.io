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

import pdbp.program.meaning.ofActiveIntReading.activeIntReading.implicits.activeIntReadingMeaningOfActiveIntReading
import activeIntReadingMeaningOfActiveIntReading.binaryTransformation

import examples.objects.active.reading.int.effectfulWriting.mainFactorialOfIntReadAsProgram
import mainFactorialOfIntReadAsProgram.factorialMain

import pdbp.utils.effects.implicits.readIntFromConsoleEffect

object FactorialOfIntReadAsProgramMain {

  def main(args: Array[String]): Unit = {

    binaryTransformation(factorialMain)(())

  }

}