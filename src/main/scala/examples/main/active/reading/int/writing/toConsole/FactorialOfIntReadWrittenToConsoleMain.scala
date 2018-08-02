package examples.main.active.reading.int.writing.toConsole

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

import pdbp.types.effect.toConsole.ToConsole

import pdbp.program.meaning.ofActiveIntReadingWithWritingToConsole.activeIntReading.implicits.activeIntReadingMeaningOfActiveIntReadingWithWritingToConsole
import activeIntReadingMeaningOfActiveIntReadingWithWritingToConsole.meaning

import examples.objects.active.reading.int.writing.toConsole.mainFactorialOfIntReadWrittenToConsole
import mainFactorialOfIntReadWrittenToConsole.factorialMain

object FactorialOfIntReadWrittenToConsoleMain {

  import examples.utils.effects.implicits.readIntFromConsoleEffect

  import examples.utils.effects.implicits.writeFactorialOfIntReadFromConsoleToConsoleEffect

  def main(args: Array[String]): Unit = {

    meaning(factorialMain)(())

  }

}
