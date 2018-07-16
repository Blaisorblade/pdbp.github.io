package examples.main.meaning.ofActive.active.effectfulReadingAndWriting

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

import examples.objects.active.effectfulReadingAndWriting.mainFactorialAsProgram
import mainFactorialAsProgram.factorialMain

import pdbp.computation.meaning.instances.ofActive.active.activeMeaningOfActive
import activeMeaningOfActive.programMeaning

object FactorialAsProgramMain {

  def main(args: Array[String]): Unit = {

    programMeaning.applyToProgram(factorialMain)(())

  }

}