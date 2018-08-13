package pdbp.computation.transformation.reactive

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

private[pdbp] object ReactiveTransformation {

  private[pdbp] type ReactiveTransformed =
    [C[+ _]] => [+Z] => (C[Z] => Unit) => Unit

}

import ReactiveTransformation._

import pdbp.types.kleisli.kleisliBinaryTypeConstructorType._

import pdbp.program.Program

import pdbp.computation.Computation

import pdbp.natural.transformation.unary.`~U~>`

import pdbp.computation.transformation.ComputationTransformation

private[pdbp] trait ReactiveTransformation[FC[+ _]: Computation]
    extends ComputationTransformation[FC, ReactiveTransformed[FC]] {

  private type RTFC = ReactiveTransformed[FC]

  import implicitly.{result => resultFC}
  import implicitly.{bind => bindFC}

  override private[pdbp] val transform: FC `~U~>` RTFC = new {
    override private[pdbp] def apply[Z](fcz: FC[Z]): RTFC[Z] = { `fcz=>u` =>
      `fcz=>u`(fcz)
    }
  }

  override private[pdbp] def bind[Z, Y](
      rtfcz: RTFC[Z],
      `z=>rtfcy`: => (Z => RTFC[Y])): RTFC[Y] = { `cy=>u` =>
    rtfcz { cz =>
      bindFC(cz, z => resultFC(`z=>rtfcy`(z)(`cy=>u`)))
    }
  }

}
