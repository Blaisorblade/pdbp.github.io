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

import examples.programs.writing.utils.infoUtils

import examples.programs.writing.utils.infoUtils.{info => _, _}

trait WritingAtomicPrograms[
    W: Writable, 
    >-->[- _, + _]: Function
                  : [>-->[- _, + _]] => Writing[W, >-->]]
    extends HelperPrograms[>-->] {

  private val implicitFunction = implicitly[Function[>-->]]

  private val implicitWriting = implicitly[Writing[W, >-->]]

  import implicitFunction._

  import implicitWriting._

  def info[Z, Y](string: String): (Z >--> Y) => ((String => W) `I=>` Z >--> Y) =
    infoUtils.info(string)

  val isZero: (String => W) `I=>` BigInt >--> Boolean =
    info("isZero") {
      isZeroHelper
    }

  val subtractOne: (String => W) `I=>` BigInt >--> BigInt =
    info("subtractOne") {
      subtractOneHelper
    }

  val multiply: (String => W) `I=>` (BigInt && BigInt) >--> BigInt =
    info("multiply") {
      multiplyHelper
    }

  def one[Z]: (String => W) `I=>` Z >--> BigInt =
    info("one") {
      oneHelper
    }

}
