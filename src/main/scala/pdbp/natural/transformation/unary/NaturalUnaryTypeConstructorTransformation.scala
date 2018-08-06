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

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.natural.transformation.binary.`~B~>`

private[pdbp] trait `~U~>`[F[+ _], T[+ _]]
    extends `~B~>`[Kleisli[F], Kleisli[T]] {
  `f~u~t` =>

  private[pdbp] def apply[Z](fz: F[Z]): T[Z]

  private type `=>F` = Kleisli[F]

  private type `=>T` = Kleisli[T]

  override def apply[Z, Y]: Z `=>F` Y => Z `=>T` Y = { `z=>fy` =>
    `z=>fy` andThen apply
  }

  private[pdbp] def andThen[T2[+ _]](`t~u~t2`: T `~U~>` T2): F `~U~>` T2 =
    new {
      override private[pdbp] def apply[Z](fz: F[Z]): T2[Z] =
        `t~u~t2`(`f~u~t`(fz))
    }

}
