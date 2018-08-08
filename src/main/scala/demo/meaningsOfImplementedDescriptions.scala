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

import implicitObjects._

import definingDescriptions._

import implementingDescriptions._

trait NaturalTransformation[F[+ _], T[+ _]] {
  def apply[Z](fz: F[Z]): T[Z]
}

trait Meaning[F[+ _], T[+ _]] {
  def meaning: NaturalTransformation[F, T]
}

trait ContainingMeaningOfContaining[F[+ _]: Containing, T[+ _]: Containing]
    extends Meaning[F, T] {
  val implicitlyFrom = implicitly[Containing[F]]
  val implicitlyTo = implicitly[Containing[T]]
  override def meaning: NaturalTransformation[F, T] =
    new NaturalTransformation {
      override def apply[Z](fz: F[Z]): T[Z] = {
        implicitlyTo.contain(implicitlyFrom.contained(fz))
      }
    }
}

trait CoveringMeaningOfContaining[F[+ _]: Containing, T[+ _]: Covering]
    extends Meaning[F, T] {
  val implicitlyFrom = implicitly[Containing[F]]
  val implicitlyTo = implicitly[Covering[T]]
  override def meaning: NaturalTransformation[F, T] =
    new NaturalTransformation {
      override def apply[Z](fz: F[Z]): T[Z] = {
        implicitlyTo.cover(implicitlyFrom.contained(fz))
      }
    }
}

object meaningObjects {

  object boxAsBox extends ContainingMeaningOfContaining[Box, Box]()

  object bagAsBox extends ContainingMeaningOfContaining[Box, Bag]()

  object capAsBox extends CoveringMeaningOfContaining[Box, Cap]()

  object fezAsBox extends CoveringMeaningOfContaining[Box, Fez]()

  object boxAsBag extends ContainingMeaningOfContaining[Bag, Box]()

  object bagAsBag extends ContainingMeaningOfContaining[Bag, Bag]()

  object capAsBag extends CoveringMeaningOfContaining[Bag, Cap]()

  object fezAsBag extends CoveringMeaningOfContaining[Bag, Fez]()

}

import meaningObjects._

object usingMeaningsOfImplementedDescriptions {

  def main(args: Array[String]): Unit = {

    {
      import someValuesContainedInBox.containedBike
      import boxAsBox.meaning
      println(meaning(containedBike))
    }
    {
      import someValuesContainedInBox.containedBall
      import bagAsBox.meaning
      println(meaning(containedBall))
    }
    {
      import someValuesContainedInBox.containedBike
      import capAsBox.meaning
      println(meaning(containedBike))
    }
    {
      import someValuesContainedInBox.containedBall
      import fezAsBox.meaning
      println(meaning(containedBall))
    }
    {
      import someValuesContainedInBag.containedBike
      import boxAsBag.meaning
      println(meaning(containedBike))
    }
    {
      import someValuesContainedInBag.containedBall
      import bagAsBag.meaning
      println(meaning(containedBall))
    }
    {
      import someValuesContainedInBag.containedBike
      import capAsBag.meaning
      println(meaning(containedBike))
    }
    {
      import someValuesContainedInBag.containedBall
      import fezAsBag.meaning
      println(meaning(containedBall))
    }

  }

}
