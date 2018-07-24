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

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.folding.Folding

import pdbp.program.writing.Writing

import pdbp.computation.Computation

import pdbp.computation.transformation.reading.ReadingTransformation
import pdbp.computation.transformation.reading.ReadingTransformation._

private[pdbp] trait ReadingWithWritingTransformation[
    R,
    W : Folding, 
    FC[+ _]: Computation : [FC[+ _]] => Writing[W, Kleisli[FC]]]
    extends ReadingTransformation[R, FC]
    with Writing[W, Kleisli[ReadingTransformed[R, FC]]] {

  private val implicitWriting: Writing[W, Kleisli[FC]] =
    implicitly[Writing[W, Kleisli[FC]]]

  private type RTFC = ReadingTransformed[R, FC]

  private type `=>RTFC` = Kleisli[RTFC]

  override private[pdbp] val `w>-->u`: W `=>RTFC` Unit = { w =>
    implicitWriting.`w>-->u`(w)
  }

 }     
