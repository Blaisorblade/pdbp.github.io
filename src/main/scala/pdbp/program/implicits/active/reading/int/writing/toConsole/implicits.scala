package pdbp.program.implicits.active.reading.int.writing.toConsole

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
import pdbp.types.active.writing.activeWritingTypes._
import pdbp.types.active.reading.writing.activeReadingWithWritingTypes._
import pdbp.types.effect.toConsole.ToConsole

import pdbp.writable.implicits.toConsole.implicits.toConsoleWritable

import pdbp.program.reading.Reading

import pdbp.program.writing.Writing

import pdbp.program.implicits.active.reading.writing.ActiveReadingWithWritingProgram

import pdbp.program.implicits.active.writing.toConsole.implicits.activeWritingToConsoleProgram

import pdbp.computation.transformation.ComputationTransformation
import pdbp.computation.transformation.reading.ReadingTransformation

import pdbp.computation.transformation.reading.writing.ReadingWithWritingTransformation

object implicits {

  implicit object activeIntReadingWithWritingToConsoleProgram
      extends ActiveReadingWithWritingProgram[BigInt, ToConsole]()
      with ComputationTransformation[
        ActiveWriting[ToConsole],
        ActiveReadingWithWriting[BigInt, ToConsole]]()
      with ReadingTransformation[BigInt, ActiveWriting[ToConsole]]()
      with ReadingWithWritingTransformation[BigInt,
                                            ToConsole,
                                            ActiveWriting[ToConsole]]()
      with Reading[BigInt, `=>ARW`[BigInt, ToConsole]]()
      with Writing[ToConsole, `=>ARW`[BigInt, ToConsole]]()

}
