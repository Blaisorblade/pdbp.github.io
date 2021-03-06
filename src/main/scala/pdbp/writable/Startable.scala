package pdbp.writable

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

import pdbp.computation.ObjectLifting

private[pdbp] trait Startable[W] extends ObjectLifting[Const[W]] {

  private[pdbp] val start: W

  override private[pdbp] def liftObject[Z](z: Z): W = start

}