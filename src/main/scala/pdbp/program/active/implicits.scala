package pdbp.program.active

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

import pdbp.utils.functionUtils._

import pdbp.program.Program

import pdbp.computation.Computation

object implicits {

  implicit object activeProgram
      extends Computation[Active]
      with Program[`=>A`] {

    override private[pdbp] def result[Z]: Z => Active[Z] = `z=>az`

    override private[pdbp] def bind[Z, Y](
        az: Active[Z],
        `z=>ay`: => (Z => Active[Y])): Active[Y] =
      `z=>ay`(az)

    override def compose[Z, Y, X](`z=>ay`: Z `=>A` Y,
                                  `y=>ax`: => Y `=>A` X): Z `=>A` X = { z =>
      bind(`z=>ay`(z), `y=>ax`)
    }

  }

}
