package pdbp.computation.meaning

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

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.Computation

private[pdbp] trait IdentityMeaning[C[+ _]: Computation]
    extends ComputationMeaning[C, C] {

  override private[pdbp] val unaryTransformation: C `~U~>` C = new {
      override private[pdbp] def apply[Z](cz: C[Z]): C[Z] = {
        cz
      }
  }

}