package pdbp.program.writing

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

import pdbp.writable.Writable

import pdbp.program.Function

import pdbp.program.Composition

import pdbp.program.Construction

trait Writing[W: Writable, >-->[- _, + _]] {
  this: Function[>-->] & Composition[>-->] & Construction[>-->] =>

  private[pdbp] val `w>-->u`: W >--> Unit = write(identity)

  private[pdbp] def `z>-w->u`[Z]: (Z => W) `I=>` Z >--> Unit =
    compose(function(implicitly), `w>-->u`)

  def write[Z]: (Z => W) `I=>` Z >--> Unit =
    `z>-w->u`

  def writingUsing[Z, Y, X](
      `(z&&y)=>x`: ((Z && Y) => X)): (Z >--> Y) => ((X => W) `I=>` Z >--> Y) = {
    `z>-->y` =>
      val `(z&&y)>-->x` = function(`(z&&y)=>x`)
      val `z>-->(x&&y)` =
        `let` {
          `z>-->y`
        } `in` {
          `let` {
            `(z&&y)>-->x`
          } `in` {
            `(z&&y&&x)>-->(x&&y)`
          }
        }
      compose(compose(`z>-->(x&&y)`, left(`z>-w->u`)), `(u&&y)>-->y`)
  }

}
