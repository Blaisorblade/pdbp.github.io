package examples.utils.reading

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

import pdbp.utils.effectfulUtils._

trait EffectfreeUtils[>-->[- _, + _]: [>-->[- _, + _]] => Reading[BigInt, >-->]] {

  import implicitly._

  private val readInt: Unit >--> BigInt = `u>-->r`

  val effectfreeIntProducer: Unit >--> BigInt =
    readInt

}