package city

import city.ZoneLib._

abstract class ZoneVisitor {
  // solution par pattern matching
  def visit(z: Zone): Unit =
    z match {
      case ResidentialZone(_) => z.accept(this)
      case CommercialZone(_) => z.accept(this)
      case IndustrialZone(_) => z.accept(this)
      //case Land(_) => z.accept(this)
      case _ => println("Warning! Invalid Action")
    }

}