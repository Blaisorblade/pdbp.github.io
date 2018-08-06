package examples.main.active.effectfulReadingAndWriting

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

import pdbp.types.active.activeTypes._

import pdbp.program.compositionOperator._

import pdbp.program.implicits.active.implicits.activeProgram

import examples.programs.Factorial

import examples.utils.EffectfulUtils

object FactorialMain extends Factorial[`=>A`] with EffectfulUtils[`=>A`]() {

  def main(args: Array[String]): Unit = {

    import pdbp.program.meaning.ofActive.active.implicits.activeMeaningOfActive.meaning

    meaning(
      effectfulReadIntFromConsole >-->
        factorial >-->
        effectfulWriteFactorialOfIntToConsole
    )(())

  }

}
