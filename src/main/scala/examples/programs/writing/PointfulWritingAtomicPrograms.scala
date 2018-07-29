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

import pdbp.program.Function

import pdbp.writable.Writable

import pdbp.program.writing.Writing

import examples.utils.functionUtils._

import examples.programs.HelperPrograms

trait PointfulWritingAtomicPrograms[W: Writable, >-->[- _, + _] : Function: [>-->[- _, + _]] => Writing[W, >-->]]
    extends HelperPrograms[>-->] {

  private val implicitFunction = implicitly[Function[>-->]]

  private val implicitWriting = implicitly[Writing[W, >-->]]

  import implicitFunction._

  import implicitWriting._

  val isZeroInfo: BigInt && Boolean => String = 
    { case (i, b) => s"[ ${System.nanoTime} ] isZero($i) == $b"}

  val subtractOneInfo: BigInt && BigInt => String = 
    { case (i, j) => s"[ ${System.nanoTime} ] subtractOne($i) == $j"}

  val multiplyInfo: (BigInt && BigInt) && BigInt => String = 
    { case ((i, j), k) => s"[ ${System.nanoTime} ] multiply($i, $j) == $k"}

  def oneInfo[Z]: Z && BigInt => String = 
    { case (z, i) => s"[ ${System.nanoTime} ] one($z) == $i"}

  val isZero: (String => W) `I=>` BigInt >--> Boolean =
    pointfulWriting (isZeroInfo) {
      isZeroHelper
    }  

  val subtractOne: (String => W) `I=>` BigInt >--> BigInt =
    pointfulWriting (subtractOneInfo) {
      subtractOneHelper
  }

  val multiply: (String => W) `I=>` (BigInt && BigInt) >--> BigInt =
    pointfulWriting (multiplyInfo) {
      multiplyHelper
  } 

  def one[Z]: (String => W) `I=>` Z >--> BigInt =
    pointfulWriting (oneInfo) {
      oneHelper
  }

}