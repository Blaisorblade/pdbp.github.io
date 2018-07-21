package pdbp.program.folding

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

import pdbp.types.const.constType._

import pdbp.utils.functionUtils._

import pdbp.computation.Lifting

private[pdbp] trait Folding[W]
    extends Starting[W]
    with Appending[W]
    with Lifting[Const[W]] {

  override private[pdbp] def liftFunction[Z, Y](`z=>y`: Z => Y): W => W = `w=>w`

}