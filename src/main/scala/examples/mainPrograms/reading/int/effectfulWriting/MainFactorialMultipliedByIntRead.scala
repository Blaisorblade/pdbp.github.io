package examples.mainPrograms.reading.int.effectfulWriting

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

import examples.utils.EffectfulUtils

import examples.programs.reading.int.FactorialMultipliedByIntRead

class MainFactorialMultipliedByIntRead[
    >-->[- _, + _]: Program
                  : [>-->[- _, + _]] => Reading[BigInt, >-->]] 
    extends EffectfulUtils[>-->]() {

  private object factorialMultipliedByIntReadObject
      extends FactorialMultipliedByIntRead[>-->]

  import factorialMultipliedByIntReadObject.factorialMultipliedByIntRead

  val factorialMultipliedByIntReadMain: Unit >--> Unit =
    effectfulReadIntFromConsole >-->
      factorialMultipliedByIntRead >-->
      effectfulWriteFactorialOfIntToConsole

}
