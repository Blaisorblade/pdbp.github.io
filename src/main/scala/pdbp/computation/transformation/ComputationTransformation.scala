package pdbp.computation.transformation

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

import pdbp.program.Program

import pdbp.computation.Computation

private[pdbp] trait ComputationTransformation[FC[+ _]: Computation, T[+ _]]
    extends Computation[T]
    with Program[Kleisli[T]] {

  private[pdbp] val transform: FC `~U~>` T

}
