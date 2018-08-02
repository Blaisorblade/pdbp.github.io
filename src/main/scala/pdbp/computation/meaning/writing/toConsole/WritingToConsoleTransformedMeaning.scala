package pdbp.computation.meaning.writing.toConsole

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

import pdbp.types.effect.toConsole.ToConsole

import pdbp.computation.Computation

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.transformation.writing.WritingTransformation
import pdbp.computation.transformation.writing.WritingTransformation._

import pdbp.computation.meaning.ComputationMeaning

private[pdbp] trait WritingToConsoleTransformedMeaning[FC[+ _]: Computation,
T[+ _]](implicit toBeTransformedMeaning: ComputationMeaning[FC, T])
    extends ComputationMeaning[WritingTransformed[ToConsole, FC], T] {

  private val implicitComputation = implicitly[Computation[FC]]

  import implicitComputation._

  private type WTFC = WritingTransformed[ToConsole, FC]

  override private[pdbp] val unaryTransformation: WTFC `~U~>` T =
    new {
      override private[pdbp] def apply[Z](wtfcz: WTFC[Z]): T[Z] = {
        def executing(wtfcz: WTFC[Z]): FC[Z] =
          bind(wtfcz, {
            case (ToConsole(effect), z) =>
              effect(())
              result(z)
          })
        toBeTransformedMeaning.unaryTransformation(executing(wtfcz))
      }
    }

}
