package pdbp.computation

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

import pdbp.types.kleisli.kleisliProgramType.Kleisli

import pdbp.types.product.productType._
import pdbp.types.sum.sumType._

// import pdbp.utils.productUtils._
import pdbp.utils.sumUtils._

import pdbp.program.Program
import pdbp.program.Applying

private[pdbp] trait Computation[M[+ _]]
    extends Resulting[M]
    with Binding[M]
    with Lifting[M]
    with Sequencing[M]
    with Program[Kleisli[M]]
    with Applying[Kleisli[M]] {

  override private[pdbp] def liftObject[Z](z: Z): M[Z] =
    result(z)

  override private[pdbp] def liftFunction[Z, Y](
      `z=>y`: Z => Y): M[Z] => M[Y] = { mz =>
    bind(mz, z => result(`z=>y`(z)))
  }

  override private[pdbp] def liftOperator[Z, Y, X](
      `(z&&y)=>x`: (Z && Y) => X): (M[Z] && M[Y]) => M[X] = { (mz, my) =>
    bind(mz, z => bind(my, y => result(`(z&&y)=>x`(z, y))))
  }

  private type `=>M` = Kleisli[M]

  override def function[Z, Y]: (Z => Y) => Z `=>M` Y = { `z=>y` => z =>
    result(`z=>y`(z))
  }

  override def compose[Z, Y, X](`z=>my`: Z `=>M` Y,
                                `y=>mx`: => Y `=>M` X): Z `=>M` X = { z =>
    bind(`z=>my`(z), `y=>mx`)
  }

  override def product[Z, Y, X](`z=>my`: Z `=>M` Y,
                                `z=>mx`: => Z `=>M` X): Z `=>M` (Y && X) = {
    z =>
      bind(`z=>my`(z), y => bind(`z=>mx`(z), x => result(y, x)))
  }

  override def sum[Z, Y, X](`y=>mz`: => Y `=>M` Z,
                            `x=>mz`: => X `=>M` Z): (Y || X) `=>M` Z =
    foldSum(`y=>mz`, `x=>mz`)

  override private[pdbp] def apply[Z, Y]: (Z && (Z `=>M` Y)) `=>M` Y = {
    (z, `z=>my`) =>
      `z=>my`(z)
  }

}
