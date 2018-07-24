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

import pdbp.types.product.productType._

import pdbp.utils.productUtils._

private[pdbp] object WritingTransformation { 

  type WritingTransformed[W, FC[+ _]] = [+Z] => FC[W && Z]

}

import WritingTransformation._

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.folding.Folding

import pdbp.program.Program
import pdbp.program.writing.Writing

import pdbp.computation.Computation

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.transformation.ComputationTransformation

private[pdbp] trait WritingTransformation[W: Folding, FC[+ _]: Computation]
    extends ComputationTransformation[FC, WritingTransformed[W, FC]]
    with Computation[WritingTransformed[W, FC]]
    with Program[Kleisli[WritingTransformed[W, FC]]]
    with Writing[W, Kleisli[WritingTransformed[W, FC]]] {

  private type WTFC = WritingTransformed[W, FC]
  private type `=>WTFC` = Kleisli[WTFC]

  private val implicitComputation = implicitly[Computation[FC]]

  import implicitComputation.{bind => bindFC}
  import implicitComputation.{result => resultFC}

  private val implicitFolding = implicitly[Folding[W]]

  import implicitFolding._

  override private[pdbp] val transform: FC `~U~>` WTFC = new {
    override private[pdbp] def apply[Z](fcz: FC[Z]): WTFC[Z] =
      bindFC(fcz, { z =>
        resultFC((start, z))
      })
  }

  override private[pdbp] def result[Z]: Z => WTFC[Z] = { z =>
    resultFC((start, z))
  }

  override private[pdbp] def bind[Z, Y](wtfcz: WTFC[Z],
                                        `z=>wtfcy`: => (Z => WTFC[Y])): WTFC[Y] =
    bindFC(wtfcz, { (leftW, z) =>
      bindFC(`z=>wtfcy`(z), { (rightW, y) => 
      resultFC(append(leftW, rightW), y)
      })
    })

  private[pdbp] override val `w>-->u`: W `=>WTFC` Unit = { w =>
    resultFC((w, ()))
  }

}