 package city
 
 import city.ZoneLib._


class DisplayZoneVisitor extends ZoneVisitor {
  def display(z: Zone) = z.description
  def visit(l: Land) = {
    println("visiting land")
    l.description
  }

  /* def visit(lf: Zone) = {
    println("visiting leafzone")
    lf.description
    lf match {
      case r : ResidentialZone => println("bleu");
      case c : CommercialZone => println("rouge")
      
    }
  }*/
}