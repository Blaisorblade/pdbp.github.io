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

  trait Meaning[D[+ _], M[+ _]] {
    def meaning: NaturalTransformation[D, M]
  }

  trait MeaningOfContaining[C[+ _]: Containing, M[+ _]] extends Meaning[C, M]

  trait MeaningOfBox[C[+ _]: Containing] extends MeaningOfContaining[Box, C] {
    override def meaning: NaturalTransformation[Box, C] =
      new NaturalTransformation {
        override def apply[Z](bz: Box[Z]): C[Z] = {
          implicitly.contain(bz.unbox)
        }
      }
  }

  object wrapMeaningOfBox
      extends MeaningOfBox[Wrap]()
      with MeaningOfContaining[Box, Wrap]()

  object boxMeaningOfBox
      extends MeaningOfBox[Box]()
      with MeaningOfContaining[Box, Box]()

  def usingWrappedMeaningOfBoxedValues: Unit = {

    import someBoxedValues._
    import wrapMeaningOfBox._

    println(meaning(containedZero))
    println(meaning(containedTrue))

  }

  def usingBoxedMeaningOfBoxedValues: Unit = {

    import someBoxedValues._
    import boxMeaningOfBox._

    println(meaning(containedZero))
    println(meaning(containedTrue))

  }

  def main(args: Array[String]): Unit = {

    usingWrappedMeaningOfBoxedValues

    usingBoxedMeaningOfBoxedValues

  }

}
