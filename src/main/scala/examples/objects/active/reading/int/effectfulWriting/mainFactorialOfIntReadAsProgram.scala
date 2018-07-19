package examples.objects.active.reading.int.effectfulWriting

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

import pdbp.types.active.reading.activeReadingTypes._

import pdbp.program.implicits.active.reading.int.implicits
import implicits.activeIntReadingProgram

import examples.mainPrograms.effectfreeReadingAndEffectfulWriting.MainFactorialOfIntReadAsProgram

object mainFactorialOfIntReadAsProgram extends MainFactorialOfIntReadAsProgram[`=>AR`[BigInt]]()