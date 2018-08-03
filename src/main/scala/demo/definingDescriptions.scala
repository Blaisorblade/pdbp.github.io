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

  def covered[Z](cz: C[Z]): Z

}

case object Head

case object Ball

object definingDescriptions {

  trait SomeValuesContainedIn[C[+ _]: Containing] {

    import implicitly._

    val containedHead: C[Head.type] =
      contain(Head)

    val containedBall: C[Ball.type] =
      contain(Ball)

  }

  trait SomeValuesCoveredBy[C[+ _]: Covering] {

    import implicitly._

    val coveredHead: C[Head.type] =
      cover(Head)

    val coveredBall: C[Ball.type] =
      cover(Ball)

  }

}
