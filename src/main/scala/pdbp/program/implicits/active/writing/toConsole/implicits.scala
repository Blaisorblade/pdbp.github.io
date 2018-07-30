package pdbp.program.implicits.active.writing.toConsole

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

import pdbp.types.active.activeTypes._
import pdbp.types.active.writing.activeWritingTypes._

import pdbp.writable.implicits.toConsole.implicits.toConsoleWritable

import pdbp.program.writing.Writing

import pdbp.program.implicits.active.writing.ActiveWritingProgram
import pdbp.program.implicits.active.implicits.activeProgram

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.writing.WritingTransformation

object implicits {

  implicit object activeWritingToConsoleProgram
      extends ActiveWritingProgram[ToConsole]()
      with ComputationTransformation[Active, ActiveWriting[ToConsole]]()
      with WritingTransformation[ToConsole, Active]()
      with Writing[ToConsole, `=>AW`[ToConsole]]()

}
