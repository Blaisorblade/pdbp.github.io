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

class PointfulWritingFactorial[W: Writable, >-->[- _, + _]: Program: [>-->[- _, + _]] => Writing[W, >-->]] 
    extends PointfulWritingAtomicPrograms[W, >-->]() with HelperPrograms[>-->]() {

  private val implicitProgram = implicitly[Program[>-->]]

  private val implicitWriting = implicitly[Writing[W, >-->]]

  import implicitProgram._

  import implicitWriting._

  val factorial: (String => W) `I=>` BigInt >--> BigInt =
    `if`(isZero) {
      one
     } `else` {
       `let` {
         subtractOne >-->
           factorial
       } `in` {
         multiply
       }
    }

  // val factorialInfo: (BigInt && BigInt) => String = 
  //   { case (i, j) => s"[ ${System.nanoTime} ] factorial($i) == $j"}    

  // val factorial: (String => W) `I=>` BigInt >--> BigInt = {
  //   pointfulWriting (factorialInfo) { 
  //     factorialHelper
  //   } 
  // } 

  // val factorial: (String => W) `I=>` BigInt >--> BigInt = {
  //   pointfulWriting (factorialInfo) { 
  //     `if`(isZero) {
  //       one
  //      } `else` {
  //        `let` {
  //          subtractOne >-->
  //            factorial
  //        } `in` {
  //          multiply
  //        }
  //     }
  //   } 
  // }     

}
