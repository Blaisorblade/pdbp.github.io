package pdbp.computation

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

private[pdbp] trait Binding[C[+ _]] {

  private[pdbp] def bind[Z, Y](cz: C[Z], `z=>cy`: => Z => C[Y]): C[Y]

}

private[pdbp] object bindingOperator {

  implicit class bindingOperator[C[+ _] : Binding, -Z, ZZ <: Z](czz: C[ZZ]) {

    private[pdbp] def bind[Y](`zz=>cy`: ZZ => C[Y]): C[Y] =
      implicitly.bind(czz, `zz=>cy`)
  }

}
