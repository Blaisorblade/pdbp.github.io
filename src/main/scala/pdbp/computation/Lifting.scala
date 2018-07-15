package pdbp.computation

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

import pdbp.utils.productUtils._

private[pdbp] trait Lifting[C[+ _]]
    extends ObjectLifting[C]
    with FunctionLifting[C]
    with OperatorLifting[C] {

  private[pdbp] def lift3[Z, Y, X, W]
    : ((Z && Y && X) => W) => (C[Z] && C[Y] && C[X]) => C[W] =
    `((z&&y)&&x)=>w` =>
      `((cz&&cy)=>c(z&&y)))=>((cz&&cy)&&cx)=>c(z&&y)&&cx`(
        lift2(`(z&&y)=>(z&&y)`)) andThen lift2(`((z&&y)&&x)=>w`)

  // and so on ...

  private[pdbp] def liftedAnd[Z, Y]: (C[Z] && C[Y]) => C[Z && Y] =
    liftOperator(`(z&&y)=>(z&&y)`)

  private[pdbp] def liftedApply[Z, Y]: (C[Z => Y] && C[Z]) => C[Y] =
    liftOperator(`((z=>y)&&z)=>y`)

  private[pdbp] override def lift1[Z, Y]: (Z => Y) => C[Z] => C[Y] = {
    `z=>y` => cz =>
      lift2(`((z=>y)&&z)=>y`)(lift0(`z=>y`), cz)

  }

}
