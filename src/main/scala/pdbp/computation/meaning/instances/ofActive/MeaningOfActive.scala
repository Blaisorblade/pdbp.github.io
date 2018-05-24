package pdbp.computation.meaning.instances.ofActive

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

import pdbp.types.active.activeTypes._

import pdbp.computation.Resulting

import pdbp.natural.transformation.unary.`~C~>`

import pdbp.computation.meaning.ComputationMeaning

trait MeaningOfActive[TR[+ _]: Resulting] extends ComputationMeaning[Active, TR] {

  override private[pdbp] lazy val computationMeaning: Active `~C~>` TR =
    new `~C~>` {
      override private[pdbp] def apply[Z](az: Active[Z]): TR[Z] = {
        import implicitly._
        result(az)
      }
    }

}
