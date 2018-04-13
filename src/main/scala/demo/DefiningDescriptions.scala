package demo

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

object DefiningDescriptions {

  trait Description[D[+ _]]

  trait Containing[C[+ _]] extends Description[C] {

    def contain[Z](z: Z): C[Z]

  }

  trait SomeValuesContainedIn[C[+ _]: Containing] {

    val containedZero: C[Int] =
      implicitly.contain(0)

    val containedTrue: C[Boolean] =
      implicitly.contain(true)

  }

}
