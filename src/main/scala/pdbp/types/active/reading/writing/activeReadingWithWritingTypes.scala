package pdbp.types.active.reading.writing

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

import pdbp.types.active.writing.activeWritingTypes._

import pdbp.computation.transformation.reading.ReadingTransformation._

object activeReadingWithWritingTypes {

  type ActiveReadingWithWriting[R, W] = ReadingTransformed[R, ActiveWriting[W]]

  type `=>ARW`[R, W] = Kleisli[ActiveReadingWithWriting[R, W]]

}