package examples.main.active.reading.int.writing.toConsole.effectfulWriting

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

import examples.objects.active.reading.int.writing.toConsole.effectfulWriting.mainFactorialOfIntReadPointfulWritingToConsole
import mainFactorialOfIntReadPointfulWritingToConsole.factorialMain

import examples.main.Main

object FactorialOfIntReadPointfulWritingToConsoleMain extends Main[`=>ARW`[BigInt, ToConsole]] {

  import examples.utils.effects.implicits.readIntFromConsoleEffect

  import examples.utils.effects.implicits.pointfulWriteToConsoleEffect

  private type `=>ARW[BigInt, ToConsole]` = `=>ARW`[BigInt, ToConsole]
          
  override val mainKleisliProgram: Unit `=>ARW[BigInt, ToConsole]` Unit = factorialMain

  override val run = mainKleisliProgram(()) match { case (ToConsole(effect), _) => effect(()) }

}
