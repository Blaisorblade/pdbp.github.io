package pdbp.folding.implicits.toConsole

import pdbp.types.product.productType._

import pdbp.types.effect.toConsole.ToConsole

import pdbp.folding.Folding


object implicits {

  implicit object toConsoleFolding extends Folding[ToConsole] {

    override private[pdbp] val start: ToConsole =
      ToConsole { _ =>
        ()
      }

    override private[pdbp] val append: ToConsole && ToConsole => ToConsole = {
      (l1, l2) =>
        ToConsole { _ =>
          { l1.effect(()); l2.effect(()) }
        }
    }

  }  

}