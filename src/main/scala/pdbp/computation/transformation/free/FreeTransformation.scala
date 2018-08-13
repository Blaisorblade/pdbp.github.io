package pdbp.computation.transformation.free

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

private[pdbp] object FreeTransformation {

  sealed trait Free[C[+ _], +Z]

  final case class Transform[C[+ _], +Z](cz: C[Z]) extends Free[C, Z]
  final case class Result[C[+ _], +Z](z: Z) extends Free[C, Z]
  final case class Bind[C[+ _], -Z, ZZ <: Z, +Y](fczz: Free[C, ZZ],
                                                 `z=>fcy`: Z => Free[C, Y])
      extends Free[C, Y]

  private[pdbp] type FreeTransformed[C[+ _]] = [+Z] => Free[C, Z]

}

import FreeTransformation._

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.program.Program

import pdbp.computation.Computation

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.transformation.ComputationTransformation

private[pdbp] trait FreeTransformation[C[+ _]: Computation]
    extends ComputationTransformation[C, FreeTransformed[C]] {

  private type FTC = FreeTransformed[C]

  override private[pdbp] val transform: C `~U~>` FTC = new {
    override private[pdbp] def apply[Z](cz: C[Z]): FTC[Z] =
      Transform(cz)
  }

  override private[pdbp] def result[Z]: Z => FTC[Z] = { z =>
    Result(z)
  }

  override private[pdbp] def bind[Z, Y](
      ftcz: FTC[Z],
      `z=>ftcy`: => (Z => FTC[Y])): FTC[Y] =
    Bind(ftcz, `z=>ftcy`)

}
