// package examples.mainPrograms.writing.toConsole.effectfulReading

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

// import pdbp.types.effect.toConsole.ToConsole

// import pdbp.program.Program

// import pdbp.program.writing.Writing

// import pdbp.program.compositionOperator._

// import examples.utils.EffectfulUtils

// import examples.programs.Factorial

// class MainFactorialWrittenToConsole[
//     >-->[- _, + _]: Program
//                   : [>-->[- _, + _]] => Writing[ToConsole, >-->]]
//     extends EffectfulUtils[>-->]() {

//   private val implicitIntWriting = implicitly[Writing[ToConsole, >-->]]

//   import implicitIntWriting._

//   private object factorialObject extends Factorial[>-->]

//   import factorialObject.factorial

//   val factorialMain: (BigInt => ToConsole) `I=>` Unit >--> Unit =
//     effectfulReadIntFromConsole >-->
//       factorial >-->
//       write

// }