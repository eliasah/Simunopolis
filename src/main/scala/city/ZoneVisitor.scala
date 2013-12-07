package city

abstract class ZoneVisitor {
  // solution classique
  def visit(l: Land)
  def visit(lf: LeafZone)
  def visit(z: Zone) = z.accept(this)

  // solution par pattern matching
  // def visit(z: Zone) =
  //  z match {
  //    case leaf: LeafZone => leaf.accept(this)
  //    case land: Land => land.accept(this)
  // }

}