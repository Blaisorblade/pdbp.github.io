package pdbp.utils

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

object functionUtils {

  def `z=>z`[Z]: Z => Z = { z =>
    z
  }

  def `z=>u`[Z]: Z => Unit = { z =>
    ()
  }

  def `z=>(y=>z)`[Z, Y]: Z => Y => Z = { z => y =>
    z
  }

  def `z=>az`[Z]: Z => Active[Z] = { z =>
    z
  }

  def `w=>w`[W]: W => W = { w =>
    w
  }

  def `y=>y`[Y]: Y => Y = { y =>
    y
  }  

}
