package pdbp.examples.main.active.effectfulReadingAndWriting

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

import pdbp.program.active.implicits.activeProgram

import pdbp.examples.mainKleisliPrograms.MainSumOfSquares

import pdbp.examples.utils.EffectfulUtils

object SumOfSquaresMain
    extends MainSumOfSquares[Active]()
    with EffectfulUtils[Active]() {

  override val producer = effectfulReadTwoDoublesFromConsole

  override val consumer = effectfulWriteSumOfSquaresOfTwoDoublesToConsole

  def main(args: Array[String]): Unit = {

    import pdbp.program.meaning.ofActive.active.implicits.activeMeaningOfActive.meaning

    meaning(mainSumOfSquares)(())

  }

}
