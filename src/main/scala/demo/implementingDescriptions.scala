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

import definingDescriptions._

case class Box[+Z](z: Z)

case class Bag[+Z](z: Z)

case class Cap[+Z](z: Z)

case class Fez[+Z](z: Z)

object implicitObjects {

  implicit object implicitBox extends Containing[Box] {

    override def contain[Z](z: Z): Box[Z] = Box(z)

    override def contained[Z](bz: Box[Z]) = bz match {
      case Box(z) => z
    }

  }

  implicit object implicitBag extends Containing[Bag] {

    override def contain[Z](z: Z): Bag[Z] = Bag(z)

    override def contained[Z](bz: Bag[Z]) = bz match {
      case Bag(z) => z
    }

  }

  implicit object implicitCap extends Covering[Cap] {

    override def cover[Z](z: Z): Cap[Z] = Cap(z)

    override def covered[Z](cz: Cap[Z]) = cz match {
      case Cap(z) => z
    }

  }

  implicit object implicitFez extends Covering[Fez] {

    override def cover[Z](z: Z): Fez[Z] = Fez(z)

    override def covered[Z](fz: Fez[Z]) = fz match {
      case Fez(z) => z
    }

  }

}

object implementingDescriptions {

  import implicitObjects._

  object someValuesContainedInBox extends SomeValuesContainedIn[Box]()

  object someValuesContainedInBag extends SomeValuesContainedIn[Bag]()

  object someValuesCoveredByCap extends SomeValuesCoveredBy[Cap]()

  object someValuesCoveredByFez extends SomeValuesCoveredBy[Fez]()

  val headContainedInBox: Box[Head.type] =
    someValuesContainedInBox.containedHead

  val ballContainedInBox: Box[Ball.type] =
    someValuesContainedInBox.containedBall

  val headContainedInBag: Bag[Head.type] =
    someValuesContainedInBag.containedHead

  val ballContainedInBag: Bag[Ball.type] =
    someValuesContainedInBag.containedBall

  val headCoveredByCap: Cap[Head.type] = someValuesCoveredByCap.coveredHead
  val ballCoveredByCap: Cap[Ball.type] = someValuesCoveredByCap.coveredBall

  val headCoveredByFez: Fez[Head.type] = someValuesCoveredByFez.coveredHead
  val ballCoveredByFez: Fez[Ball.type] = someValuesCoveredByFez.coveredBall

}

import implementingDescriptions._

object usingImplementedDescriptions {

  def main(args: Array[String]): Unit = {

    println(headContainedInBox)
    println(ballContainedInBox)
    println(headContainedInBag)
    println(ballContainedInBag)
    println(headCoveredByCap)
    println(ballCoveredByCap)
    println(headCoveredByFez)
    println(ballCoveredByFez)

  }

}
