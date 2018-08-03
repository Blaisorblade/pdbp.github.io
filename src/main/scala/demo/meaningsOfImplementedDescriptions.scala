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

trait As[F[+ _], T[+ _]] {
  def meaning: NaturalTransformation[F, T]
}

trait ContainingAsContaining[F[+ _]: Containing, T[+ _]: Containing]
    extends As[F, T] {
  val implicitlyFrom = implicitly[Containing[F]]
  val implicitlyTo = implicitly[Containing[T]]
  override def meaning: NaturalTransformation[F, T] =
    new NaturalTransformation {
      override def apply[Z](fz: F[Z]): T[Z] = {
        implicitlyTo.contain(implicitlyFrom.contained(fz))
      }
    }
}

trait BoxAsContaining[C[+ _]: Containing]
    extends ContainingAsContaining[Box, C]

trait BagAsContaining[C[+ _]: Containing]
    extends ContainingAsContaining[Bag, C]

trait CoveringAsContaining[F[+ _]: Containing, T[+ _]: Covering]
    extends As[F, T] {
  val implicitlyFrom = implicitly[Containing[F]]
  val implicitlyTo = implicitly[Covering[T]]
  override def meaning: NaturalTransformation[F, T] =
    new NaturalTransformation {
      override def apply[Z](fz: F[Z]): T[Z] = {
        implicitlyTo.cover(implicitlyFrom.contained(fz))
      }
    }
}

trait BoxAsCovering[C[+ _]: Covering]
    extends CoveringAsContaining[Box, C]

trait BagAsCovering[C[+ _]: Covering]
    extends CoveringAsContaining[Bag, C]

object meaningObjects {

  object boxAsBox
      extends BoxAsContaining[Box]()
      with ContainingAsContaining[Box, Box]()

  object boxAsBag
      extends BoxAsContaining[Bag]()
      with ContainingAsContaining[Box, Bag]()

  object boxAsCap
      extends BoxAsCovering[Cap]()
      with CoveringAsContaining[Box, Cap]()

  object boxAsFez
      extends BoxAsCovering[Fez]()
      with CoveringAsContaining[Box, Fez]()

  object bagAsBox
      extends BagAsContaining[Box]()
      with ContainingAsContaining[Bag, Box]()

  object bagAsBag
      extends BagAsContaining[Bag]()
      with ContainingAsContaining[Bag, Bag]()

  object bagAsCap
      extends BagAsCovering[Cap]()
      with CoveringAsContaining[Bag, Cap]()

  object bagAsFez
      extends BagAsCovering[Fez]()
      with CoveringAsContaining[Bag, Fez]()

}

import meaningObjects._

object meaningsOfImplementedDescriptions {

  val headContainedInBoxAsBox: Box[Head.type] =
    boxAsBox.meaning(headContainedInBox)
  val ballContainedInBoxAsBox: Box[Ball.type] =
    boxAsBox.meaning(ballContainedInBox)

  val headContainedInBoxAsBag: Bag[Head.type] =
    boxAsBag.meaning(headContainedInBox)
  val ballContainedInBoxAsBag: Bag[Ball.type] =
    boxAsBag.meaning(ballContainedInBox)

  val headCoveredByBoxAsCap: Cap[Head.type] =
    boxAsCap.meaning(headContainedInBox)
  val ballCoveredByBoxAsCap: Cap[Ball.type] =
    boxAsCap.meaning(ballContainedInBox)

  val headCoveredByBoxAsFez: Fez[Head.type] =
    boxAsFez.meaning(headContainedInBox)
  val ballCoveredByBoxAsFez: Fez[Ball.type] =
    boxAsFez.meaning(ballContainedInBox)

  val headContainedInBagAsBox: Box[Head.type] =
    bagAsBox.meaning(headContainedInBag)
  val ballContainedInBagAsBox: Box[Ball.type] =
    bagAsBox.meaning(ballContainedInBag)

  val headContainedInBagAsBag: Bag[Head.type] =
    bagAsBag.meaning(headContainedInBag)
  val ballContainedInBagAsBag: Bag[Ball.type] =
    bagAsBag.meaning(ballContainedInBag)

  val headCoveredByBagAsCap: Cap[Head.type] =
    bagAsCap.meaning(headContainedInBag)
  val ballCoveredByBagAsCap: Cap[Ball.type] =
    bagAsCap.meaning(ballContainedInBag)

  val headCoveredByBagAsFez: Fez[Head.type] =
    bagAsFez.meaning(headContainedInBag)
  val ballCoveredByBagAsFez: Fez[Ball.type] =
    bagAsFez.meaning(ballContainedInBag)

}

import meaningsOfImplementedDescriptions._

object usingMeaningsOfImplementedDescriptions {

  def main(args: Array[String]): Unit = {

    println(headContainedInBoxAsBox)
    println(ballContainedInBoxAsBox)
    println(headContainedInBoxAsBag)
    println(ballContainedInBoxAsBag)
    println(headCoveredByBoxAsCap)
    println(ballCoveredByBoxAsCap)
    println(headCoveredByBoxAsFez)
    println(ballCoveredByBoxAsFez)
    println(headContainedInBagAsBox)
    println(ballContainedInBagAsBox)
    println(headContainedInBagAsBag)
    println(ballContainedInBagAsBag)
    println(headCoveredByBagAsCap)
    println(ballCoveredByBagAsCap)
    println(headCoveredByBagAsFez)
    println(ballCoveredByBagAsFez)

  }

}
