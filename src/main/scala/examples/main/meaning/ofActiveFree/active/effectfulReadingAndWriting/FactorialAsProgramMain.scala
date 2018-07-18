package examples.main.meaning.ofActiveFree.active.effectfulReadingAndWriting

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

import pdbp.program.meaning.ofActiveFree.active.activeMeaningOfActiveFree
import activeMeaningOfActiveFree.programMeaning

import examples.objects.active.free.effectfulReadingAndWriting.mainFactorialAsProgram
import mainFactorialAsProgram.factorialMain

object FactorialAsProgramMain {

  def main(args: Array[String]): Unit = {

    programMeaning(factorialMain)(())

  }

}