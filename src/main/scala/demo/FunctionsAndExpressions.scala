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

object FunctionsAndExpressions {

  private val z = 3.0
  private val y = 4.0

  private type &&[+Z, +Y] = Tuple2[Z, Y]

    import scala.math.{sqrt => squareRoot}

    private val result01: Double = squareRoot(z * z + y * y)

    private val square: Double => Double =
      z => z * z

    private val result02: Double = squareRoot(square(z) + square(y))

    private val sum: Double && Double => Double =
      (z, y) => z + y

    private val result03: Double = squareRoot(sum(square(z), square(y)))

    private val squares: Double && Double => Double && Double =
      (z, y) => (square(z), square(y))

    private val result04: Double = squareRoot(sum(squares(z, y)))

    private val result05: Double = (squares andThen sum andThen squareRoot)(z, y)

    private val result06: Double = (squares andThen sum andThen squareRoot) apply (z, y)

    import bindingOperator.BindingOperator

    private val result07: Double = (z, y) bind (squares andThen sum andThen squareRoot)

    private val result08: Double = (z, y) bind squares bind sum bind squareRoot

    // private val result09: Double = (z, y) bind (squares bind sum bind squareRoot)

    private val squareRootOfSumOfSquares: Double && Double => Double = 
      squares andThen sum andThen squareRoot

    private val result10: Double = squareRootOfSumOfSquares(z, y)

    private val result11: Double = squareRootOfSumOfSquares apply (z, y)  

    private val result12: Double = (z, y) bind squareRootOfSumOfSquares  

    private val bindToSquaresAndThenBindToSumAndThenBindToSquareRoot: Double && Double => Double  = 
      _ bind squares bind sum bind squareRoot

    private val result13: Double = bindToSquaresAndThenBindToSumAndThenBindToSquareRoot(z, y)

    private val result14: Double = bindToSquaresAndThenBindToSumAndThenBindToSquareRoot apply (z, y)  

    private val toSquaresAndThenBindToSumAndThenBindToSquareRoot: Double && Double => Double  = 
      bindToSquaresAndThenBindToSumAndThenBindToSquareRoot

    private val result15: Double = (z, y) bind toSquaresAndThenBindToSumAndThenBindToSquareRoot  

  def main(args: Array[String]): Unit = {      

    println(result01)
    println(result02)
    println(result03)
    println(result04)
    println(result05)
    println(result06)
    println(result07)
    println(result08)
    // println(result09)
    println(result10)
    println(result11)
    println(result12)
    println(result13)
    println(result14)
    println(result15)

  }

}
