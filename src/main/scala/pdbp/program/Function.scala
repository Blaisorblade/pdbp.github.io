package pdbp.program

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

import pdbp.types.product.productType._
import pdbp.types.sum.sumType._

import pdbp.utils.functionUtils._
import pdbp.utils.productUtils._
import pdbp.utils.sumUtils._
import pdbp.utils.productAndSumUtils._

trait Function[>-->[- _, + _]] {

  def function[Z, Y]: (Z => Y) => Z >--> Y

  def `z>-->z`[Z]: Z >--> Z =
    function(`z=>z`)

  def `z>-->u`[Z]: Z >--> Unit =
    function(`z=>u`)

  def `z=>(y>-->z)`[Z, Y]: Z => (Y >--> Z) = { z =>
    function(`z=>(y=>z)`(z))
  }

  def `z=>(u>-->z)`[Z]: Z => (Unit >--> Z) =
    `z=>(y>-->z)`[Z, Unit]

  def `(y&&x)>-->(y&&x)`[Y, X]: (Y && X) >--> (Y && X) =
    function(`(y&&x)=>(y&&x)`)

  def `(z&&y)>-->z`[Z, Y]: (Z && Y) >--> Z =
    function(`(z&&y)=>z`)

  def `(z&&y)>-->y`[Z, Y]: (Z && Y) >--> Y =
    function(`(z&&y)=>y`)

  def `(z&&y&&x)>-->(y&&x)`[Z, Y, X]: (Z && Y && X) >--> (Y && X) =
    function(`(z&&y&&x)=>(y&&x)`)

    def `(z&&y&&x)>-->(x&&y)`[Z, Y, X]: (Z && Y && X) >--> (X && Y) =
    function(`(z&&y&&x)=>(x&&y)`)  

  def `(z&&y&&x)>-->y`[Z, Y, X]: (Z && Y && X) >--> Y =
    function(`(z&&y&&x)=>y`)    

  def `(x&&y)>-->y`[X, Y]: (X && Y) >--> Y =
    function(`(x&&y)=>y`)

  def `(u&&y)>-->y`[Y]: (Unit && Y) >--> Y =
    function(`(u&&y)=>y`)

  def `x=>z>-->(x&&z)`[X, Z]: X => Z >--> (X && Z) = { x =>
    function(`x=>z=>(x&&z)`(x))
  }   

  def `y>-->y`[Y]: Y >--> Y =
    function(`y=>y`)   

  def `(y||x)>-->(y||x)`[Y, X]: (Y || X) >--> (Y || X) =
    function(`(y||x)=>(y||x)`)

  def `z>-->(z||y)`[Z, Y]: Z >--> (Z || Y) =
    function(`z=>(z||y)`)

  def `y>-->(z||y)`[Z, Y]: Y >--> (Z || Y) =
    function(`y=>(z||y)`)

  def `(y||x)>-->y`[Y, X]: (Y || X) >--> Y =
    function(`(y||x)=>y`)

  def `(y||x)>-->x`[Y, X]: (Y || X) >--> X =
    function(`(y||x)=>x`)

  def `(y||x)>-->b`[Y, X]: (Y || X) >--> Boolean =
    function(`(y||x)=>b`)

  def `(w&&b)>-->(w||w)`[W]: (W && Boolean) >--> (W || W) =
    function(`(w&&b)=>(w||w)`)

}
