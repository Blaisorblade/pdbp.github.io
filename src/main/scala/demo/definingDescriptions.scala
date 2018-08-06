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

trait Description[D[+ _]]

trait Containing[C[+ _]] extends Description[C] {

  def contain[Z](z: Z): C[Z]

  def contained[Z](cz: C[Z]): Z

}

trait Covering[C[+ _]] extends Description[C] {

  def cover[Z](z: Z): C[Z]

}

case class Bike()

case class Ball()

object definingDescriptions {

  class SomeValuesContainedIn[C[+ _]: Containing] {

    import implicitly._

    val containedBike: C[Bike] =
      contain(Bike())

    val containedBall: C[Ball] =
      contain(Ball())

  }

  class SomeValuesCoveredBy[C[+ _]: Covering] {

    import implicitly._

    val coveredBike: C[Bike] =
      cover(Bike())

    val coveredBall: C[Ball] =
      cover(Ball())

  }

}
