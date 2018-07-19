package examples.mainPrograms.effectfulReadingAndWriting

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

import pdbp.program.Program

import pdbp.program.compositionOperator._

import examples.utils.EffectfulUtils

import examples.programs.FactorialAsProgram

class MainFactorialAsProgram[>-->[- _, + _]: Program] extends EffectfulUtils[>-->]() {

  private object factorialAsProgram extends FactorialAsProgram[>-->]

  import factorialAsProgram.factorial

  val factorialMain: Unit >--> Unit =
    intProducer >-->
      factorial >-->
      factorialOfIntConsumer  

}