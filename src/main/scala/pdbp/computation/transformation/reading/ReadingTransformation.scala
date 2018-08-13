package pdbp.computation.transformation.reading

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

import pdbp.types.implicitFunctionType.`I=>`

private[pdbp] object ReadingTransformation {

  private[pdbp] type ReadingTransformed[R, C[+ _]] = [+Z] => R `I=>` C[Z]

}

import ReadingTransformation._

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.program.reading.Reading

import pdbp.computation.Computation

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.transformation.ComputationTransformation

private[pdbp] trait ReadingTransformation[R, C[+ _]: Computation]
    extends ComputationTransformation[C, ReadingTransformed[R, C]]
    with Reading[R, Kleisli[ReadingTransformed[R, C]]] {

  private type RTC = ReadingTransformed[R, C]
  private type `=>RTC` = Kleisli[RTC]

  import implicitly.{result => resultC}
  import implicitly.{bind => bindC}

  override private[pdbp] val transform: C `~U~>` RTC = new {
    override private[pdbp] def apply[Z](cz: C[Z]): RTC[Z] =
      cz
  }

  override private[pdbp] def bind[Z, Y](
      rtcz: RTC[Z],
      `z>=rtcy`: => (Z => RTC[Y])): RTC[Y] =
    bindC(rtcz, `z>=rtcy`(_))

  private[pdbp] override val `u>-->r`: Unit `=>RTC` R = { _ =>
    resultC(implicitly)
  }

}
