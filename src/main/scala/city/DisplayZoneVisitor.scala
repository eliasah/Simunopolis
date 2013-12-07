package city


class DisplayZoneVisitor extends ZoneVisitor {
  def display(z: Zone) = z.description
  def visit(l: Land) = {
    println("visiting land")
    l.description
  }

  def visit(lf: LeafZone) = {
    println("visiting leafzone")
    lf.description
  }
}