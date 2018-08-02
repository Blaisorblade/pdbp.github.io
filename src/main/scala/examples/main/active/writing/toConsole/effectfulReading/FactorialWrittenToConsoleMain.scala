package examples.main.active.writing.toConsole.effectfulReading

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

import pdbp.program.meaning.ofActiveToConsoleWriting.active.implicits.activeMeaningOfActiveWritingToConsole
import activeMeaningOfActiveWritingToConsole.meaning

import examples.objects.active.writing.toConsole.effectfulReading.mainFactorialWrittenToConsole
import mainFactorialWrittenToConsole.factorialMain

object FactorialWrittenToConsoleMain {

  import examples.utils.effects.implicits.writeFactorialOfIntToConsoleEffect

  def main(args: Array[String]): Unit = {

    meaning(factorialMain)(())

  }

}