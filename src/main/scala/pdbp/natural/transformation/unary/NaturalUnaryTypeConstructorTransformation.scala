package pdbp.natural.transformation.unary

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

import pdbp.types.kleisli.kleisliProgramType._

import pdbp.natural.transformation.binary.`~P~>`

private[pdbp] trait `~C~>`[F[+ _], T[+ _]]
    extends `~P~>`[Kleisli[F], Kleisli[T]] {

  private[pdbp] def apply[Z](fz: F[Z]): T[Z]

  private def applyToComputation[Z](fz: F[Z]): T[Z] =
    apply(fz)

  private type `=>F` = Kleisli[F]

  private type `=>T` = Kleisli[T]  

  override def applyToProgram[Z, Y](`z=>fy`: Z `=>F` Y): Z `=>T` Y  = { z =>
    val fy: F[Y] = `z=>fy`(z)
    applyToComputation(fy)
  }

}
