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

  type ReadingTransformed[R, FC[+ _]] = [+Z] => R `I=>` FC[Z]

}

import ReadingTransformation._

import pdbp.types.kleisli.kleisliProgramType._

import pdbp.program.Program
import pdbp.program.reading.Reading

import pdbp.computation.Computation

import pdbp.natural.transformation.unary.`~C~>`

import pdbp.computation.transformation.ComputationTransformation

private[pdbp] trait ReadingTransformation[R, FC[+ _]: Computation]
    extends ComputationTransformation[FC, ReadingTransformed[R, FC]]
    with Computation[ReadingTransformed[R, FC]]
    with Program[Kleisli[ReadingTransformed[R, FC]]]
    with Reading[R, Kleisli[ReadingTransformed[R, FC]]] {

  private type RTFC = ReadingTransformed[R, FC]
  private type `=>RTFC` = Kleisli[RTFC]

  import implicitly.{result => resultFC}
  import implicitly.{bind => bindFC}

  override private[pdbp] def transform = new `~C~>` {
    override private[pdbp] def apply[Z](fcz: FC[Z]): RTFC[Z] =
      sys.error(
        "Impossible, since, for 'ReadingTransformation', 'transform' is used nowhere")
  }

  override private[pdbp] def result[Z]: Z => RTFC[Z] = { z =>
    resultFC(z)
  }

  override private[pdbp] def bind[Z, Y](rtfcz: RTFC[Z],
                                        `z>=rtfcy`: => (Z => RTFC[Y])): RTFC[Y] =
    bindFC(rtfcz, { z =>
      `z>=rtfcy`(z)
    })

  override val `u>-->r`: Unit `=>RTFC` R = { _ =>
    resultFC(implicitly)
  }

}