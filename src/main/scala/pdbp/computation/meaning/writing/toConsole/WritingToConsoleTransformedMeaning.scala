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

private[pdbp] trait WritingToConsoleTransformedMeaning[C[+ _]: Computation,
T[+ _]](implicit toBeTransformedMeaning: ComputationMeaning[C, T])
    extends ComputationMeaning[WritingTransformed[ToConsole, C], T] {

  private val implicitComputation = implicitly[Computation[C]]

  import implicitComputation._

  private type WTC = WritingTransformed[ToConsole, C]

  val effectfulUnaryTransformation: WTC `~U~>` C =
    new {
      override private[pdbp] def apply[Z](wtcz: WTC[Z]): C[Z] =
        bind(wtcz, {
          case (ToConsole(effect), z) =>
            effect(())
            result(z)
        })
    }

  override private[pdbp] val unaryTransformation: WTC `~U~>` T =
    effectfulUnaryTransformation andThen toBeTransformedMeaning.unaryTransformation

}
