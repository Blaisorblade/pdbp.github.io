package pdbp.computation.meaning

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

import pdbp.types.kleisli.kleisliProgramType._

import pdbp.transformation.program.`~P~>`

import pdbp.transformation.computation.`~C~>`

import pdbp.computation.Computation

import pdbp.program.meaning.ProgramMeaning

private[pdbp] trait ComputationMeaning[FC[+ _]: Computation, T[+ _]]
    extends ProgramMeaning[Kleisli[FC], Kleisli[T]] {

  private[pdbp] val computationMeaning: FC `~C~>` T

  private type `=>FC` = Kleisli[FC]

  private type `=>T` = Kleisli[T]

  override val programMeaning: `=>FC` `~P~>` `=>T` = new `~P~>` {
    override def apply[Z, Y](`z=>fmy`: Z `=>FC` Y) = { z =>
      computationMeaning(`z=>fmy`(z))
    }
  }

}