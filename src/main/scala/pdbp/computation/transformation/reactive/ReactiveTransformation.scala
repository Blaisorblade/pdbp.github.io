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

private[pdbp] trait ReactiveTransformation[C[+ _]: Computation]
    extends ComputationTransformation[C, ReactiveTransformed[C]] {

  private type RTC = ReactiveTransformed[C]

  import implicitly.{result => resultC}
  import implicitly.{bind => bindC}

  override private[pdbp] val transform: C `~U~>` RTC = new {
    override private[pdbp] def apply[Z](cz: C[Z]): RTC[Z] = { `cz=>u` =>
      `cz=>u`(cz)
    }
  }

  override private[pdbp] def bind[Z, Y](rtcz: RTC[Z],
                                        `z=>rtcy`: => (Z => RTC[Y])): RTC[Y] = {
    `cy=>u` =>
      rtcz { cz =>
        bindC(cz, { z =>
          // Thread.sleep(10)
          // print(".")
          // Thread.sleep(200)
          resultC(`z=>rtcy`(z)(`cy=>u`))
        })
      }
  }

}
