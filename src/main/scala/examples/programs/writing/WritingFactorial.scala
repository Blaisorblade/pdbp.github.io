package examples.programs.writing

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

import pdbp.program.Program

import pdbp.writable.Writable

import pdbp.program.writing.Writing

import pdbp.program.compositionOperator._

import examples.programs.HelperPrograms

import examples.programs.writing.utils.infoUtils._

class WritingFactorial[
    W: Writable,
    >-->[- _, + _]: Program
                  : [>-->[- _, + _]] => Writing[W, >-->]]
    extends WritingAtomicPrograms[W, >-->]() 
    with HelperPrograms[>-->]() {

  private val implicitProgram = implicitly[Program[>-->]]

  private val implicitWriting = implicitly[Writing[W, >-->]]

  import implicitProgram._

  import implicitWriting._

  val writingFactorial: (String => W) `I=>` BigInt >--> BigInt =
    info("factorial") {
      `if`(isZero) {
        one
      } `else` {
        `let` {
          subtractOne >-->
            writingFactorial
        } `in` {
          multiply
        }
      }
    }

}
