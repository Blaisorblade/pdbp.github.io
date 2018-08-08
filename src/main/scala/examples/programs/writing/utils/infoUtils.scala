package examples.programs.writing.utils

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

import java.util.Calendar
import java.text.SimpleDateFormat

import pdbp.types.implicitFunctionType._

import pdbp.types.product.productType._

import pdbp.writable.Writable

import pdbp.program.writing.Writing

object infoUtils {

  def currentCalendarInMilliseconds: String = {
    val calendar = Calendar.getInstance();
    val millisecondsSimpleDateFormat = new SimpleDateFormat(
      "yyyy-MM-dd HH:mm:ss.SSS")
    millisecondsSimpleDateFormat.format(calendar.getTime())
  }

  def currentThreadId: Long = Thread.currentThread.getId

  def infoFunction[Z, Y](string: String): Z && Y => String = {
    case (z, y) =>
      s"INFO -- $currentCalendarInMilliseconds -- $string($z) => $y"
  }

  def info[
      W: Writable, 
      Z, 
      Y, 
       >-->[- _, + _]: [>-->[- _, + _]] => Writing[W, >-->]]
      (string: String): (Z >--> Y) => ((String => W) `I=>` Z >--> Y) = {
    val implicitWriting = implicitly[Writing[W, >-->]]
    implicitWriting.writeUsing(infoFunction(string))
  }

}
