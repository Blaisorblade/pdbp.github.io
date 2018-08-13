package examples.main.reactive.reading.int.writing.toConsole

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

import pdbp.types.reactive.reading.writing.reactiveReadingWithWritingTypes._

import pdbp.program.reactive.reading.int.writing.toConsole.implicits.reactiveIntReadingWithWritingToConsoleProgram

import examples.mainPrograms.MainFactorial

object FactorialOfIntReadWrittenToConsoleMain
    extends MainFactorial[`=>RRW`[BigInt, ToConsole]]() {

  override val producer = reactiveIntReadingWithWritingToConsoleProgram.read

  import examples.utils.effects.implicits.writeFactorialOfIntReadFromConsoleToConsoleEffect

  override val consumer = reactiveIntReadingWithWritingToConsoleProgram.write

  def main(args: Array[String]): Unit = {

    import examples.utils.effects.implicits.readIntFromConsoleEffect

    import pdbp.program.meaning.ofReactiveIntReadingWithWritingToConsole.reactiveIntReading.implicits.reactiveIntReadingMeaningOfReactiveIntReadingWithWritingToConsole.meaning

    val mainFactorialMeaning: (Unit => Unit) => Unit = meaning(mainFactorial)(())

    mainFactorialMeaning(identity)

  }
}
