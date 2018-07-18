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

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.transformation.reading.ReadingTransformation
import pdbp.computation.transformation.reading.ReadingTransformation._

import pdbp.computation.meaning.ComputationMeaning

trait ReadingTransformedMeaning[R, FC[+ _]: Computation, T[+ _]](
    toBeTransformedMeaning: ComputationMeaning[FC, T]) // ,
    // optionalReadingTransformation: Option[ReadingTransformation[R, FC]])
    extends ComputationMeaning[ReadingTransformed[R, FC],
                               ReadingTransformed[R, T]] {

  private type RTFC = ReadingTransformed[R, FC]
  private type RTT = ReadingTransformed[R, T]

  override private[pdbp] val computationMeaning: RTFC `~U~>` RTT =
    new `~U~>` {
      override private[pdbp] def apply[Z](rtfcz: RTFC[Z]): RTT[Z] =
        toBeTransformedMeaning.computationMeaning(rtfcz(implicitly))

    }

}