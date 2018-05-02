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

object LibraryLevelMeaning {

  trait NaturalTransformation[From[+ _], To[+ _]] {
    def apply[Z](fz: From[Z]): To[Z]
  }

  trait Meaning[From[+ _], To[+ _]] {
    def meaning: NaturalTransformation[From, To]
  }

  trait ContainingMeaningOfContaining[
      From[+ _]: Containing, To[+ _]: Containing]
      extends Meaning[From, To] {
    val implicitlyFrom = implicitly[Containing[From]]
    val implicitlyTo = implicitly[Containing[To]]
    override def meaning: NaturalTransformation[From, To] =
      new NaturalTransformation {
        override def apply[Z](fz: From[Z]): To[Z] = {
          implicitlyTo.contain(implicitlyFrom.contained(fz))
        }
      }
  }

  trait ContainingMeaningOfBox[C[+ _]: Containing]
      extends ContainingMeaningOfContaining[Box, C]

  trait CoveringMeaningOfContaining[From[+ _]: Containing, To[+ _]: Covering]
      extends Meaning[From, To] {
    val implicitlyFrom = implicitly[Containing[From]]
    val implicitlyTo = implicitly[Covering[To]]
    override def meaning: NaturalTransformation[From, To] =
      new NaturalTransformation {
        override def apply[Z](fz: From[Z]): To[Z] = {
          implicitlyTo.cover(implicitlyFrom.contained(fz))
        }
      }
  }

  trait CoveringMeaningOfBox[C[+ _]: Covering]
      extends CoveringMeaningOfContaining[Box, C]

  trait ContainingMeaningOfCovering[From[+ _]: Covering, To[+ _]: Containing]
      extends Meaning[From, To] {
    val implicitlyFrom = implicitly[Covering[From]]
    val implicitlyTo = implicitly[Containing[To]]
    override def meaning: NaturalTransformation[From, To] =
      new NaturalTransformation {
        override def apply[Z](fz: From[Z]): To[Z] = {
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
    import bagMeaningOfBox._

    println(meaning(containedZero))
    println(meaning(containedTrue))

  }

  def usingBoxMeaningOfValuesContainedInBox: Unit = {

    import someValuesContainedInBox._
    import boxMeaningOfBox._

    println(meaning(containedZero))
    println(meaning(containedTrue))

  }

  def usingCapMeaningOfValuesContainedInBox: Unit = {

    import someValuesContainedInBox._
    import capMeaningOfBox._

    println(meaning(containedZero))
    println(meaning(containedTrue))

  }

  def usingFezMeaningOfValuesContainedInBox: Unit = {

    import someValuesContainedInBox._
    import fezMeaningOfBox._

    println(meaning(containedZero))
    println(meaning(containedTrue))

  }

  def usingBoxMeaningOfValuesCoveredByCap: Unit = {

    import someValuesCoveredByCap._
    import boxMeaningOfCap._

    println(meaning(coveredZero))
    println(meaning(coveredTrue))

  }

  def usingBagMeaningOfValuesCoveredByCap: Unit = {

    import someValuesCoveredByCap._
    import bagMeaningOfCap._

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
