package examples.objects.active.effectfulReadingAndWriting

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

import pdbp.types.active.activeTypes._

import pdbp.program.implicits.active.implicits
import implicits.implicitActiveProgram

import examples.programs.FactorialTrait

import examples.programs.effectfulReadingAndWriting.FactorialMainTrait

object factorialMainObject
    extends FactorialMainTrait[`=>A`]()
    with FactorialTrait[`=>A`]()
