package pdbp.computation.meaning.reading

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

import pdbp.computation.Computation

import pdbp.natural.transformation.unary.`~C~>`

import pdbp.computation.transformation.reading.ReadingTransformation._

import pdbp.computation.meaning.ComputationMeaning

trait ReadingTransformedMeaning[R, FC[+ _]: Computation, T[+ _]](
    toBeTransformedMeaning: ComputationMeaning[FC, T])
    extends ComputationMeaning[ReadingTransformed[R, FC],
                               ReadingTransformed[R, T]] {

  private type RTFC = ReadingTransformed[R, FC]
  private type RTT = ReadingTransformed[R, T]

  override private[pdbp] lazy val computationMeaning: RTFC `~C~>` RTT =
    new `~C~>` {
      override private[pdbp] def apply[Z](rtfcz: RTFC[Z]): RTT[Z] =
        toBeTransformedMeaning.computationMeaning(rtfcz(implicitly))

    }

}