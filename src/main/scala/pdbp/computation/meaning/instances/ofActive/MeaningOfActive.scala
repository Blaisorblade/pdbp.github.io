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

import pdbp.natural.transformation.computation.`~C~>`

import pdbp.computation.meaning.ComputationMeaning

trait MeaningOfActive[TC[+ _]: Resulting] extends ComputationMeaning[Active, TC] {

  override private[pdbp] val computationMeaning: Active `~C~>` TC =
    new `~C~>` {
      override private[pdbp] def apply[Z](az: Active[Z]): TC[Z] = {
        import implicitly._
        result(az)
      }
    }

}
