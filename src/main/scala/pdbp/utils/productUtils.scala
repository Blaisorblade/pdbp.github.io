package pdbp.utils

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

object productUtils {

  def `(y&&x)=>(y&&x)`[Y, X]: (Y && X) => (Y && X) = { `y&&x` =>
    `y&&x`
  }

  def `(z&&y)=>z`[Z, Y]: (Z && Y) => Z = { (z, _) =>
    z
  }

  def `(z&&y)=>y`[Z, Y]: (Z && Y) => Y = { (_, y) =>
    y
  }

  def `(z&&y&&x)=>(y&&x)`[Z, Y, X]: (Z && Y && X) => (Y && X) = {
    case ((_, y), x) => (y, x)
  }

  def `(z&&y&&x)=>(x&&y)`[Z, Y, X]: (Z && Y && X) => (X && Y) = {
    case ((_, y), x) => (x, y)
  }

  def `(z&&y&&x)=>y`[Z, Y, X]: (Z && Y && X) => Y = {
    case ((_, y), _) => y
  }

  def `(z&&y)=>(z&&y)`[Z, Y]: (Z && Y) => (Z && Y) = { `z&&y` =>
    `z&&y`
  }

  def `((z=>y)&&z)=>y`[Z, Y]: ((Z => Y) && Z) => Y = { (`z=>y`, z) =>
    `z=>y`(z)
  }

  def `((cz&&cy)=>c(z&&y)))=>((cz&&cy)&&cx)=>c(z&&y)&&cx`[C[+ _], Z, Y, X]
    : (((C[Z] && C[Y]) => C[Z && Y])) => (
        C[Z] && C[Y] && C[X]) => C[Z && Y] && C[X] = {
    `(cz&&cy)=>c(z&&y)` => (`cz&&cy`, cx) =>
      (`(cz&&cy)=>c(z&&y)`(`cz&&cy`), cx)
  }

  def `(x&&y)=>y`[X, Y]: (X && Y) => Y = { (_, y) =>
    y
  }

  def `(u&&y)=>y`[Y]: (Unit && Y) => Y = { (_, y) =>
    y
  }

  def `x=>z=>(x&&z)`[X, Z]: X => Z => (X && Z) = { x => z =>
    (x, z)
  }

}
