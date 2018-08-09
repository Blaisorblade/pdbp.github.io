package examples.programs

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

import pdbp.program.Program

class FactorialTopDown[>-->[- _, + _]: Program]
    extends AtomicPrograms[>-->]()
    with HelperPrograms[>-->]() {

  import implicitly._

  import pdbp.program.compositionOperator._

  val factorial: BigInt >--> BigInt =
    `if`(isZero) {
      one
    } `else` {
      factorialOfNonZero
    }

  val factorialOfNonZero: BigInt >--> BigInt =
    `let` {
      subtractOneAndThenFactorial
    } `in` {
      multiply
    }

  val subtractOneAndThenFactorial: BigInt >--> BigInt =
    subtractOne >-->
      factorial

}
