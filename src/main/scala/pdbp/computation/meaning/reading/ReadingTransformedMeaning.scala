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

private[pdbp] trait ReadingTransformedMeaning[R, C[+ _]: Computation, T[+ _]](
    implicit toBeTransformedMeaning: ComputationMeaning[C, T])
    extends ComputationMeaning[ReadingTransformed[R, C],
                               ReadingTransformed[R, T]] {

  private type RTC = ReadingTransformed[R, C]
  private type RTT = ReadingTransformed[R, T]

  override private[pdbp] val unaryTransformation: RTC `~U~>` RTT =
    new {
      override private[pdbp] def apply[Z](rtcz: RTC[Z]): RTT[Z] =
        toBeTransformedMeaning.unaryTransformation(rtcz(implicitly))

    }

}
