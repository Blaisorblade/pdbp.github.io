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

import pdbp.types.active.reading.writing.activeReadingWithWritingTypes._

import pdbp.writable.implicits.toConsole.implicits.toConsoleWritable

import pdbp.program.implicits.active.reading.int.writing.toConsole.implicits.activeIntReadingWithWritingToConsoleProgram

import examples.mainPrograms.writing.MainWritingFactorial

object FactorialOfIntReadWritingToConsoleWrittenToConsoleMain
    extends MainWritingFactorial[ToConsole, `=>ARW`[BigInt, ToConsole]]() {

  import examples.utils.effects.implicits.readIntFromConsoleEffect

  import examples.utils.effects.implicits.writeFactorialOfIntToConsoleEffect

  import examples.utils.effects.implicits.writeToConsoleEffect

  override val producer = activeIntReadingWithWritingToConsoleProgram.read

  override val consumer = activeIntReadingWithWritingToConsoleProgram.write

  def main(args: Array[String]): Unit = {

    import pdbp.program.meaning.ofActiveIntReadingWithWritingToConsole.activeIntReading.implicits.activeIntReadingMeaningOfActiveIntReadingWithWritingToConsole.meaning

    meaning(writingFactorialMain)(())

  }
}
