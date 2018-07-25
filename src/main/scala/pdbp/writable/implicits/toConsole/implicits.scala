package pdbp.writable.implicits.toConsole

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

import pdbp.types.effect.toConsole.ToConsole

import pdbp.writable.Writable

object implicits {

  implicit object toConsoleWritable extends Writable[ToConsole] {

    override private[pdbp] val start: ToConsole =
      ToConsole { _ =>
        ()
      }

    override private[pdbp] val append: ToConsole && ToConsole => ToConsole = {
      (tc1, tc2) =>
        ToConsole { _ =>
          { tc1.effect(()); tc2.effect(()) }
        }
    }

  }  

}