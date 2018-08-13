package pdbp.computation.meaning.free

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

import pdbp.computation.Computation

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.transformation.free.FreeTransformation
import pdbp.computation.transformation.free.FreeTransformation._

import pdbp.computation.meaning.ComputationMeaning

private[pdbp] trait FreeTransformedMeaning[C[+ _]: Computation, T[+ _]](
    implicit toBeTransformedMeaning: ComputationMeaning[C, T])
    extends ComputationMeaning[FreeTransformed[C], T] {

  private val implicitComputation = implicitly[Computation[C]]

  import implicitComputation._

  private type FTC = FreeTransformed[C]

  private val foldingUnaryTransformation: FTC `~U~>` C =
    new {
      @annotation.tailrec
      override private[pdbp] def apply[Z](ftcz: FTC[Z]): C[Z] = ftcz match {
        case Transform(cz) =>
          cz
        case Result(z) =>
          result(z)
        case Bind(Result(y), y2ftcz) =>
          apply(y2ftcz(y))
        case Bind(Bind(cx, x2ftcy), y2ftcz) =>
          apply(Bind(cx, { x =>
            Bind(x2ftcy(x), y2ftcz)
          }))
        case any =>
          sys.error("Impossible, since, 'apply' eliminates this case")
      }
    }

  override private[pdbp] val unaryTransformation: FTC `~U~>` T =
    foldingUnaryTransformation andThen toBeTransformedMeaning.unaryTransformation

}
