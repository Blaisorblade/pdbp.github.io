package examples.objects.active.writing.toConsole.effectfulReading

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

import pdbp.types.effect.toConsole.ToConsole

import pdbp.types.active.writing.activeWritingTypes._

import pdbp.program.implicits.active.writing.toConsole.implicits
import implicits.activeWritingToConsoleProgram

import examples.mainPrograms.writing.toConsole.effectfulReading.MainFactorialWrittenToConsole

object mainFactorialWrittenToConsole
    extends MainFactorialWrittenToConsole[`=>AW`[ToConsole]]()
