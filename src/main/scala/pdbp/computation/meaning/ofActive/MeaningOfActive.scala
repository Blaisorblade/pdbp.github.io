package pdbp.computation.meaning.ofActive

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

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.meaning.ComputationMeaning

private[pdbp] trait MeaningOfActive[TR[+ _]: Resulting] extends ComputationMeaning[Active, TR] {

  override private[pdbp] val unaryTransformation: Active `~U~>` TR =
    new {
      override private[pdbp] def apply[Z](az: Active[Z]): TR[Z] = {
        import implicitly._
        result(az)
      }
    }

}
