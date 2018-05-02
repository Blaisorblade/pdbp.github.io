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

    def contained[Z](cz: C[Z]): Z

  }

  trait SomeValuesContainedIn[C[+ _]: Containing] {

    import implicitly._

    val containedZero: C[Int] =
      contain(0)

    val containedTrue: C[Boolean] =
      contain(true)

  }

  trait Covering[C[+ _]] extends Description[C] {

    def cover[Z](z: Z): C[Z]

    def covered[Z](cz: C[Z]): Z

  }

  trait SomeValuesCoveredBy[C[+ _]: Covering] {

    import implicitly._

    val coveredZero: C[Int] =
      cover(0)

    val coveredTrue: C[Boolean] =
      cover(true)

  }

}
