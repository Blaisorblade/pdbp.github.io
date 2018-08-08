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

import pdbp.types.active.writing.activeWritingTypes._

import pdbp.program.implicits.active.writing.toConsole.implicits.activeWritingToConsoleProgram

import examples.mainPrograms.MainFactorial

import examples.utils.EffectfulUtils

object FactorialWrittenToConsoleMain
    extends MainFactorial[`=>AW`[ToConsole]]()
    with EffectfulUtils[`=>AW`[ToConsole]]() {

  import examples.utils.effects.implicits.writeFactorialOfIntToConsoleEffect

  override val producer = effectfulReadIntFromConsole

  override val consumer = activeWritingToConsoleProgram.write

  def main(args: Array[String]): Unit = {

    import pdbp.program.meaning.ofActiveWritingToConsole.active.implicits.activeMeaningOfActiveWritingToConsole.meaning

    meaning(factorialMain)(())

  }
}
