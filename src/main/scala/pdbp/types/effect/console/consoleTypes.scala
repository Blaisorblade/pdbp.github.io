package pdbp.types.effect.console

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


object consoleTypes {

  // implicit, language level effect
  type ReadFromConsoleEffect[R] = R

  // import pdbp.types.effect.effectType._

  // case class Console(effect: Effect)

  // explicit, library level
  // type WriteToConsoleEffect[W] = W => Effect

}
