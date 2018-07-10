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

  case class Box[+Z](z: Z)

  implicit object implicitBox extends Containing[Box] {

    override def contain[Z](z: Z): Box[Z] = Box(z)

    override def contained[Z](bz: Box[Z]) = bz match {
      case Box(z) => z
    }

  }

  case class Bag[+Z](z: Z)

  implicit object implicitBag extends Containing[Bag] {

    override def contain[Z](z: Z): Bag[Z] = Bag(z)

    override def contained[Z](bz: Bag[Z]) = bz match {
      case Bag(z) => z
    }

  }

  case class Cap[+Z](z: Z)

  implicit object implicitCap extends Covering[Cap] {

    override def cover[Z](z: Z): Cap[Z] = Cap(z)

    override def covered[Z](cz: Cap[Z]) = cz match {
      case Cap(z) => z
    }

  }

  case class Fez[+Z](z: Z)

  implicit object implicitFez extends Covering[Fez] {

    override def cover[Z](z: Z): Fez[Z] = Fez(z)

    override def covered[Z](fz: Fez[Z]) = fz match {
      case Fez(z) => z
    }

  }

  object someValuesContainedInBox extends SomeValuesContainedIn[Box]()

  object someValuesContainedInBag extends SomeValuesContainedIn[Bag]()

  object someValuesCoveredByCap extends SomeValuesCoveredBy[Cap]()

  object someValuesCoveredByFez extends SomeValuesCoveredBy[Fez]()

  def usingSomeValuesContainedInBox: Unit = {

    import someValuesContainedInBox._

    println(containedZero)
    println(containedTrue)

  }

  def usingSomeValuesContainedInBag: Unit = {

    import someValuesContainedInBag._

    println(containedZero)
    println(containedTrue)

  }

  def usingSomeValuesCoveredByCap: Unit = {

    import someValuesCoveredByCap._

    println(coveredZero)
    println(coveredTrue)

  }

  def usingSomeValuesCoveredByFez: Unit = {

    import someValuesCoveredByFez._

    println(coveredZero)
    println(coveredTrue)

  }

  def main(args: Array[String]): Unit = {

    usingSomeValuesContainedInBox

    usingSomeValuesContainedInBag

    usingSomeValuesCoveredByCap

    usingSomeValuesCoveredByFez

  }

}
