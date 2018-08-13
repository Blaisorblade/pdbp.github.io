package pdbp.computation.transformation.writing

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

import pdbp.types.implicitFunctionType._

import pdbp.types.product.productType._

private[pdbp] object WritingTransformation {

  private[pdbp] type WritingTransformed[W, C[+ _]] = [+Z] => C[W && Z]

}

import WritingTransformation._

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.writable.Writable

import pdbp.program.Program
import pdbp.program.writing.Writing

import pdbp.computation.Computation

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.transformation.ComputationTransformation

private[pdbp] trait WritingTransformation[W: Writable, C[+ _]: Computation]
    extends ComputationTransformation[C, WritingTransformed[W, C]]
    with Writing[W, Kleisli[WritingTransformed[W, C]]] {

  private type WTC = WritingTransformed[W, C]
  private type `=>WTC` = Kleisli[WTC]

  private val implicitComputation = implicitly[Computation[C]]

  import implicitComputation.{bind => bindC}
  import implicitComputation.{result => resultC}

  private val implicitWritable = implicitly[Writable[W]]

  import implicitWritable._

  override private[pdbp] val transform: C `~U~>` WTC = new {
    override private[pdbp] def apply[Z](cz: C[Z]): WTC[Z] =
      bindC(cz, { z =>
        resultC((start, z))
      })
  }

  override private[pdbp] def bind[Z, Y](
      wtcz: WTC[Z],
      `z=>wtcy`: => (Z => WTC[Y])): WTC[Y] =
    bindC(wtcz, { (leftW, z) =>
      bindC(`z=>wtcy`(z), { (rightW, y) =>
        resultC(append(leftW, rightW), y)
      })
    })

  private[pdbp] override val `w>-->u`: W `=>WTC` Unit = { w =>
    resultC((w, ()))
  }

}
