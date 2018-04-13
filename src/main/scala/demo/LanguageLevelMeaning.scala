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

import DefiningDescriptions._

object LanguageLevelMeaning {

  case class Box[+Z](unbox: Z)

  implicit object box extends Containing[Box] {

    override def contain[Z](z: Z): Box[Z] = Box(z)

  }

  case class Wrap[+Z](unwrap: Z)

  implicit object wrap extends Containing[Wrap] {

    override def contain[Z](z: Z): Wrap[Z] = Wrap(z)

  }

  object someBoxedValues extends SomeValuesContainedIn[Box]()

  object someWrappedValues extends SomeValuesContainedIn[Wrap]()

  def usingBoxedValues: Unit = {

    import someBoxedValues._

    println(containedZero)
    println(containedTrue)

  }

  def usingWrappedValues: Unit = {

    import someWrappedValues._

    println(containedZero)
    println(containedTrue)

  }

  def main(args: Array[String]): Unit = {

    usingBoxedValues

    usingWrappedValues

  }

}
