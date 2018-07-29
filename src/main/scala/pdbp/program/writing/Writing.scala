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

  def write[Z]: (Z => W) `I=>` Z >--> Unit =
    compose(function(implicitly), `w>-->u`)

  def pointfreeWriting[Z, Y, X]: X => Z >--> Y => ((X => W) `I=>` Z >--> Y) = {
    x => `z>-->y` =>
      compose(`x=>z>-->(x&&z)`(x), compose(and(write, `z>-->y`), `(u&&y)>-->y`))
  }

  def pointfulWritingUsing[Z, Y, X]
    : ((Z && Y) => X) => (Z >--> Y) => ((X => W) `I=>` Z >--> Y) = {
    `(z&&y)=>x` => `z>-->y` =>
      compose(compose(product(`let` { `z>-->y` } `in` { function(`(z&&y)=>x`) },
                              `z>-->y`),
                      and(write[X], `y>-->y`)),
              `(u&&y)>-->y`)
  }

}
