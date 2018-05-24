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

  type ReadingTransformed[R, C[+ _]] = [+Z] => R `I=>` C[Z]

}

import ReadingTransformation._

import pdbp.types.kleisli.kleisliProgramType._

import pdbp.program.Program
import pdbp.program.reading.Reading

import pdbp.computation.Computation

import pdbp.natural.transformation.unary.`~C~>`

import pdbp.computation.transformation.ComputationTransformation

private[pdbp] trait ReadingTransformation[R, C[+ _]: Computation]
    extends ComputationTransformation[C, ReadingTransformed[R, C]]
    with Computation[ReadingTransformed[R, C]]
    with Program[Kleisli[ReadingTransformed[R, C]]]
    with Reading[R, Kleisli[ReadingTransformed[R, C]]] {

  private type RTC = ReadingTransformed[R, C]
  private type `=>RTC` = Kleisli[RTC]

  import implicitly.{result => resultC}
  import implicitly.{bind => bindC}

  override private[pdbp] def transform = new `~C~>` {
    override private[pdbp] def apply[Z](mz: C[Z]): RTC[Z] =
      sys.error(
        "Impossible, since, for 'ReadingTransformation', 'transform' is used nowhere")
  }

  override private[pdbp] def result[Z]: Z => RTC[Z] = { z =>
    resultC(z)
  }

  override private[pdbp] def bind[Z, Y](rtmz: RTC[Z],
                                        `z>=rtmy`: => (Z => RTC[Y])): RTC[Y] =
    bindC(rtmz, { z =>
      `z>=rtmy`(z)
    })

  override val `u>-->r`: Unit `=>RTC` R = { _ =>
    resultC(implicitly)
  }

}