package pdbp.types.reactive.free

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

import pdbp.types.reactive.reactiveTypes._

import pdbp.computation.transformation.free.FreeTransformation._

object reactiveFreeTypes {

  type ReactiveFree = FreeTransformed[Reactive]

  type `=>RF` = Kleisli[ReactiveFree]

}