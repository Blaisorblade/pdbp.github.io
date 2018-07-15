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

import pdbp.utils.sumUtils._

import pdbp.program.Program
import pdbp.program.Applying

private[pdbp] trait Computation[C[+ _]]
    extends Resulting[C]
    with Binding[C]
    with Lifting[C]
    with Sequencing[C]
    with Program[Kleisli[C]]
    with Applying[Kleisli[C]] {

  override private[pdbp] def lift0[Z]: Z => C[Z] =
    result

  override private[pdbp] def lift1[Z, Y]: (Z => Y) => C[Z] => C[Y] = `z=>y` => {
    case cz =>
      bind(cz, z => result(`z=>y`(z)))
  }

  override private[pdbp] def lift2[Z, Y, X]
    : ((Z && Y) => X) => (C[Z] && C[Y]) => C[X] = `(z&&y)=>x` => {
    case (cz, cy) =>
      bind(cz, z => bind(cy, y => result(`(z&&y)=>x`(z, y))))
  }

  override private[pdbp] def lift3[Z, Y, X, W]
    : ((Z && Y && X) => W) => (C[Z] && C[Y] && C[X]) => C[W] =
    `(z&&y&&x)=>w` => {
      case ((cz, cy), cx) =>
        bind(
          cz,
          z => bind(cy, y => bind(cx, x => result(`(z&&y&&x)=>w`((z, y), x)))))
    }

  // and so on ...

  private type `=>C` = Kleisli[C]

  override def function[Z, Y]: (Z => Y) => Z `=>C` Y = { `z=>y` => z =>
    result(`z=>y`(z))
  }

  override def compose[Z, Y, X](`z=>cy`: Z `=>C` Y,
                                `y=>cx`: => Y `=>C` X): Z `=>C` X = { z =>
    bind(`z=>cy`(z), `y=>cx`)
  }

  override def product[Z, Y, X](`z=>cy`: Z `=>C` Y,
                                `z=>cx`: => Z `=>C` X): Z `=>C` (Y && X) = {
    z =>
      bind(`z=>cy`(z), y => bind(`z=>cx`(z), x => result(y, x)))
  }

  override def sum[Z, Y, X](`y=>cz`: => Y `=>C` Z,
                            `x=>cz`: => X `=>C` Z): (Y || X) `=>C` Z =
    foldSum(`y=>cz`, `x=>cz`)

  override private[pdbp] def apply[Z, Y]: (Z && (Z `=>C` Y)) `=>C` Y = {
    (z, `z=>cy`) =>
      `z=>cy`(z)
  }

}
