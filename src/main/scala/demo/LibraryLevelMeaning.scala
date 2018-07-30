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

import LanguageLevelMeaning._

trait NaturalTransformation[F[+ _], T[+ _]] {
  def apply[Z](fz: F[Z]): T[Z]
}

trait Meaning[F[+ _], T[+ _]] {
  def meaning: NaturalTransformation[F, T]
}

object LibraryLevelMeaning {

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

  trait ContainingMeaningOfBox[C[+ _]: Containing]
      extends ContainingMeaningOfContaining[Box, C]

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

  trait CoveringMeaningOfBox[C[+ _]: Covering]
      extends CoveringMeaningOfContaining[Box, C]

  trait ContainingMeaningOfCovering[F[+ _]: Covering, T[+ _]: Containing]
      extends Meaning[F, T] {
    val implicitlyFrom = implicitly[Covering[F]]
    val implicitlyTo = implicitly[Containing[T]]
    override def meaning: NaturalTransformation[F, T] =
      new NaturalTransformation {
        override def apply[Z](fz: F[Z]): T[Z] = {
          implicitlyTo.contain(implicitlyFrom.covered(fz))
        }
      }
  }

  trait ContainingMeaningOfCap[C[+ _]: Containing]
      extends ContainingMeaningOfCovering[Cap, C]

  object bagMeaningOfBox
      extends ContainingMeaningOfBox[Bag]()
      with ContainingMeaningOfContaining[Box, Bag]()

  object boxMeaningOfBox
      extends ContainingMeaningOfBox[Box]()
      with ContainingMeaningOfContaining[Box, Box]()

  object capMeaningOfBox
      extends CoveringMeaningOfBox[Cap]()
      with CoveringMeaningOfContaining[Box, Cap]()

  object fezMeaningOfBox
      extends CoveringMeaningOfBox[Fez]()
      with CoveringMeaningOfContaining[Box, Fez]()

  object boxMeaningOfCap
      extends ContainingMeaningOfCap[Box]()
      with ContainingMeaningOfCovering[Cap, Box]()

  object bagMeaningOfCap
      extends ContainingMeaningOfCap[Bag]()
      with ContainingMeaningOfCovering[Cap, Bag]()

  def usingBagMeaningOfValuesContainedInBox: Unit = {

    import someValuesContainedInBox._
    import bagMeaningOfBox.meaning

    println(meaning(containedZero))
    println(meaning(containedTrue))

  }

  def usingBoxMeaningOfValuesContainedInBox: Unit = {

    import someValuesContainedInBox._
    import boxMeaningOfBox.meaning

    println(meaning(containedZero))
    println(meaning(containedTrue))

  }

  def usingCapMeaningOfValuesContainedInBox: Unit = {

    import someValuesContainedInBox._
    import capMeaningOfBox.meaning

    println(meaning(containedZero))
    println(meaning(containedTrue))

  }

  def usingFezMeaningOfValuesContainedInBox: Unit = {

    import someValuesContainedInBox._
    import fezMeaningOfBox.meaning

    println(meaning(containedZero))
    println(meaning(containedTrue))

  }

  def usingBoxMeaningOfValuesCoveredByCap: Unit = {

    import someValuesCoveredByCap._
    import boxMeaningOfCap.meaning

    println(meaning(coveredZero))
    println(meaning(coveredTrue))

  }

  def usingBagMeaningOfValuesCoveredByCap: Unit = {

    import someValuesCoveredByCap._
    import bagMeaningOfCap.meaning

    println(meaning(coveredZero))
    println(meaning(coveredTrue))

  }

  def main(args: Array[String]): Unit = {

    usingBagMeaningOfValuesContainedInBox

    usingBoxMeaningOfValuesContainedInBox

    usingCapMeaningOfValuesContainedInBox

    usingFezMeaningOfValuesContainedInBox

    usingBoxMeaningOfValuesCoveredByCap

    usingBagMeaningOfValuesCoveredByCap

  }

}
