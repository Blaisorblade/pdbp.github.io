package pdbp.types.reactive.reading.writing

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

import pdbp.types.reactive.writing.reactiveWritingTypes._

import pdbp.computation.transformation.reading.ReadingTransformation._

object reactiveReadingWithWritingTypes {

  type ReactiveReadingWithWriting[R, W] = ReadingTransformed[R, ReactiveWriting[W]]

  type `=>RRW`[R, W] = Kleisli[ReactiveReadingWithWriting[R, W]]

}