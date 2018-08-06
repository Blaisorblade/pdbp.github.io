package examples.mainPrograms.reading.int

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
import pdbp.program.reading.Reading

import pdbp.program.compositionOperator._

import examples.programs.reading.int.FactorialMultipliedByIntRead

trait MainFactorialMultipliedByIntRead[
    >-->[- _, + _]: Program
                  : [>-->[- _, + _]] => Reading[BigInt, >-->]] {

  private object factorialMultipliedByIntReadObject extends FactorialMultipliedByIntRead[>-->]

  import factorialMultipliedByIntReadObject.factorialMultipliedByIntRead

  val producer: Unit >--> BigInt
  
  val consumer: BigInt >--> Unit

  lazy val factorialMultipliedByIntReadMain: Unit >--> Unit =
    producer >-->
      factorialMultipliedByIntRead >-->
      consumer

}