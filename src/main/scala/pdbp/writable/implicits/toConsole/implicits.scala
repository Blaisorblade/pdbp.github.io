package pdbp.writable.implicits.toConsole

import pdbp.types.product.productType._

import pdbp.types.effect.toConsole.ToConsole

import pdbp.writable.Writable

object implicits {

  implicit object toConsoleWritable extends Writable[ToConsole] {

    override private[pdbp] val start: ToConsole =
      ToConsole { _ =>
        ()
      }

    override private[pdbp] val append: ToConsole && ToConsole => ToConsole = {
      (tc1, tc2) =>
        ToConsole { _ =>
          { tc1.effect(()); tc2.effect(()) }
        }
    }

  }  

}