package pdbp.demo.program

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

import pdbp.program.Program
import pdbp.program.Applying

import pdbp.computation.Resulting
import pdbp.computation.Binding

import pdbp.demo.types.kleisli.kleisliComputationType._

private[pdbp] trait ProgramWithApplying[>-->[- _, + _]]
    extends Program[>-->]
    with Applying[>-->]
    with Resulting[Kleisli[>-->]]
    with Binding[Kleisli[>-->]] {

  private type M = Kleisli[>-->]

  override private[pdbp] def result[Z]: Z => M[Z] =
    `z=>(u>-->z)`

  override private[pdbp] def bind[Z, Y](mz: M[Z], `z=>my`: => Z => M[Y]): M[Y] =
    compose(mz, compose(product(`z>-->u`, function(`z=>my`)), apply))

}
