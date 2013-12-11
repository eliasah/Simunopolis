package city

sealed abstract class Zone {
  var density: Int = 0
  var value: Int = 0
  var crime: Int = 0
  var pollution: Int = 0
  var growth: Int = 0

  def description
  def accept(v: ZoneVisitor)
}

case class ResidentialZone(var d: String) extends Zone {
  def description = println("Residential Zone " + d)
  def accept(v: ZoneVisitor) = v visit this
}
case class CommercialZone(var d: String) extends Zone {
  def description = println("Commercial Zone " + d)
  def accept(v: ZoneVisitor) = v visit this
}

case class IndustrialZone(var d: String) extends Zone {
  def description = println("Industrial Zone " + d)
  def accept(v: ZoneVisitor) = v visit this
}

case class PowerPlant extends Zone {
  def description = println("PowerPlant")
  def accept(v: ZoneVisitor) = v visit this
}

case class PoliceDepartement extends Zone {
  def description = println("Police Departement")
  def accept(v: ZoneVisitor) = v visit this
}

case class Land(var children: List[Zone]) extends Zone {
  def description = children.foreach(x => x.description)
  def accept(v: ZoneVisitor) = v visit this
}