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

class Cap[+Z](z: Z) {
  override def toString = s"Cap($z)"
}

class Fez[+Z](z: Z) {
  override def toString = s"Fez($z)"
}

object implicitObjects {

  implicit object box extends Containing[Box] {

    override def contain[Z](z: Z): Box[Z] = Box(z)

    override def contained[Z](bz: Box[Z]) = bz.z
  }

  implicit object bag extends Containing[Bag] {

    override def contain[Z](z: Z): Bag[Z] = Bag(z)

    override def contained[Z](bz: Bag[Z]) = bz.z

  } 

  implicit object cap extends Covering[Cap] {

    override def cover[Z](z: Z): Cap[Z] = new Cap(z)

  }

  implicit object fez extends Covering[Fez] {

    override def cover[Z](z: Z): Fez[Z] = new Fez(z)

  }

}

object implementingDescriptions {

  import implicitObjects._

  object someValuesContainedInBox extends SomeValuesContainedIn[Box]()

  object someValuesContainedInBag extends SomeValuesContainedIn[Bag]()

  object someValuesCoveredByCap extends SomeValuesCoveredBy[Cap]()

  object someValuesCoveredByFez extends SomeValuesCoveredBy[Fez]()

}

import implementingDescriptions._

object usingImplementedDescriptions {

  def main(args: Array[String]): Unit = {

  {
    import someValuesContainedInBox.containedBike
    println(containedBike)
  }
  {
    import someValuesContainedInBox.containedBall
    println(containedBall)
  } 
  {
    import someValuesContainedInBag.containedBike
    println(containedBike)
  }
  {
    import someValuesContainedInBag.containedBall
    println(containedBall)
  }    
  {
    import someValuesCoveredByCap.coveredBike
    println(coveredBike)
  }
  {
    import someValuesCoveredByCap.coveredBall
    println(coveredBall)
  }
  {
    import someValuesCoveredByFez.coveredBike
    println(coveredBike)
  }
  {
    import someValuesCoveredByFez.coveredBall
    println(coveredBall)
  }

  }

}

