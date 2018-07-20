package examples.main.active.reading.int.effectfulWriting

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

import examples.objects.active.reading.int.effectfulWriting.mainFactorialMultipliedByIntReadAsProgram
import mainFactorialMultipliedByIntReadAsProgram.factorialMultipliedByIntReadMain

import pdbp.utils.effects.implicits.readIntFromConsoleEffect

object FactorialMultipliedByIntReadAsProgramMain {

  def main(args: Array[String]): Unit = {

    factorialMultipliedByIntReadMain(())

  }

}
