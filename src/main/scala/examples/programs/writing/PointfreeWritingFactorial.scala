// package examples.programs.writing

// //       _______         __    __        _______
// //      / ___  /\       / /\  / /\      / ___  /\
// //     / /__/ / / _____/ / / / /_/__   / /__/ / /
// //    / _____/ / / ___  / / / ___  /\ /____  / /
// //   / /\____\/ / /__/ / / / /__/ / / \___/ / /
// //  /_/ /      /______/ / /______/ /     /_/ /
// //  \_\/       \______\/  \______\/      \_\/
// //                                           v1.0
// //  Program Description Based Programming Library
// //  author        Luc Duponcheel        2017-2018

// import pdbp.types.implicitFunctionType._

// import pdbp.program.Program

// import pdbp.writable.Writable

// import pdbp.program.writing.Writing

// import pdbp.program.compositionOperator._

// import examples.programs.HelperPrograms

// class PointfreeWritingFactorial[W: Writable, >-->[- _, + _]: Program: [>-->[- _, + _]] => Writing[W, >-->]] 
//     extends PointfreeWritingAtomicPrograms[W, >-->]() with HelperPrograms[>-->]() {

//   private val implicitProgram = implicitly[Program[>-->]]

//   private val implicitWriting = implicitly[Writing[W, >-->]]

//   import implicitProgram._

//   import implicitWriting._

//   val factorial: (String => W) `I=>` BigInt >--> BigInt = 
//     `if`(isZero) {
//        one
//     } `else` {
//       `let` {
//         subtractOne >-->
//           factorial
//       } `in` {
//         multiply
//        }
//      }

// }
