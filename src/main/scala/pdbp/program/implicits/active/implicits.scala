// package pdbp.program.implicits.active

// //       _______         __    __        _______
// //      / ___  /\       / /\  / /\      / ___  /\
// //     / /__/ / / _____/ / / / /_/__   / /__/ / /
// //    / _____/ / / ___  / / / ___  /\ /____  / /
// //   / /\____\/ / /__/ / / / /__/ / / \___/ / /
// //  /_/ /      /______/ / /______/ /     /_/ /
// //  \_\/       \______\/  \______\/      \_\/
// //                                           v1.0
// //  Program Description Based Programming Library
// //  author        Luc Duponcheel        2017-2018

// import pdbp.program.instances.active.activeProgram

// object implicits {

//   implicit val implicitActiveProgram: activeProgram.type = activeProgram

// }

package pdbp.program.implicits.active

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

import pdbp.types.product.productType._
import pdbp.types.sum.sumType._

import pdbp.types.active.activeTypes._

import pdbp.utils.functionUtils._
import pdbp.utils.sumUtils._

import pdbp.program.Program

import pdbp.computation.Computation

object implicits {

// TODO: change to activeProgram
implicit object implicitActiveProgram extends Computation[Active] with Program[`=>A`] {

  override private[pdbp] def result[Z]: Z => Active[Z] = `z=>az`

  override private[pdbp] def bind[Z, Y](
      az: Active[Z],
      `z=>ay`: => (Z => Active[Y])): Active[Y] = {
    lazy val `lazy z=>ay` = `z=>ay`   
    `lazy z=>ay`(az)
  }

  override def compose[Z, Y, X](`z=>ay`: Z `=>A` Y,
                                `y=>ax`: => Y `=>A` X): Z `=>A` X = { z =>
    lazy val `lazy y=>ax` = `y=>ax`                            
    bind(`z=>ay`(z), `lazy y=>ax`)
  }

  override def product[Z, Y, X](`z=>ay`: Z `=>A` Y,
                                `z=>ax`: => Z `=>A` X): Z `=>A` (Y && X) = {
    z =>
      lazy val `lazy z=>ax` = `z=>ax`
      bind(`z=>ay`(z), y => bind(`lazy z=>ax`(z), x => result(y, x)))
  }

  override def sum[Z, Y, X](`y=>az`: => Y `=>A` Z,
                            `x=>az`: => X `=>A` Z): (Y || X) `=>A` Z = {
    lazy val `lazy y=>az` = `y=>az`
    lazy val `lazy x=>az` = `x=>az`
    foldSum(`lazy y=>az`, `lazy x=>az`)  
  }  

}

}