package pdbp.computation.transformation.reading.writing

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

import pdbp.types.implicitFunctionType._

import pdbp.types.product.productType._

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.writable.Writable

import pdbp.program.writing.Writing

import pdbp.computation.Computation

import pdbp.computation.transformation.reading.ReadingTransformation
import pdbp.computation.transformation.reading.ReadingTransformation._

private[pdbp] trait ReadingWithWritingTransformation[
    R, W: Writable, 
    C[+ _]: Computation
           : [C[+ _]] => Writing[W, Kleisli[C]]]
    extends ReadingTransformation[R, C]
    with Writing[W, Kleisli[ReadingTransformed[R, C]]] {

  private val implicitWriting: Writing[W, Kleisli[C]] =
    implicitly[Writing[W, Kleisli[C]]]

  private type RTC = ReadingTransformed[R, C]

  private type `=>RTC` = Kleisli[RTC]

  override private[pdbp] val `w>-->u`: W `=>RTC` Unit = { w =>
    implicitWriting.`w>-->u`(w)
  }

}
