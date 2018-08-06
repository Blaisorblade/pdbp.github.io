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

private[pdbp] trait FreeTransformedMeaning[FC[+ _]: Computation, T[+ _]](
    implicit toBeTransformedMeaning: ComputationMeaning[FC, T])
    extends ComputationMeaning[FreeTransformed[FC], T] {

  private val implicitComputation = implicitly[Computation[FC]]

  import implicitComputation._

  private type FTFC = FreeTransformed[FC]   

  private val foldingUnaryTransformation: FTFC `~U~>` FC =
    new {
      @annotation.tailrec
      override private[pdbp] def apply[Z](ftfcz: FTFC[Z]): FC[Z] = ftfcz match {
        case Transform(fcz) =>
          fcz
        case Result(z) =>
          result(z)
        case Bind(Result(y), y2ftfcz) =>
          apply(y2ftfcz(y))
        case Bind(Bind(fcx, x2ftfcy), y2ftfcz) =>
          apply(Bind(fcx, { x =>
            Bind(x2ftfcy(x), y2ftfcz)
          }))
        case any =>
          sys.error(
            "Impossible, since, 'apply' eliminates this case")
        }
      }  

  override private[pdbp] val unaryTransformation: FTFC `~U~>` T =
    foldingUnaryTransformation andThen toBeTransformedMeaning.unaryTransformation


}